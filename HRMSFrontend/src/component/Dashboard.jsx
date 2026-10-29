import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

function Dashboard({ currentUser }) {
  const [empId, setEmpId] = useState(currentUser?.id || localStorage.getItem("empId") || '');
  const [empName, setEmpName] = useState(currentUser?.name || localStorage.getItem("empName") || '');
  const [checkInTime, setCheckInTime] = useState('');
  const [checkOutTime, setCheckOutTime] = useState('');
  const [statusMessage, setStatusMessage] = useState('');
  const [loadingAction, setLoadingAction] = useState(false);

  // All employees & attendance list
  const [allEmployees, setAllEmployees] = useState([]);
  const [todayAttendanceMap, setTodayAttendanceMap] = useState({});
  const [loadingData, setLoadingData] = useState(true);

  const navigate = useNavigate();
  const todayIso = new Date().toISOString().split('T')[0];
  const todayFormatted = new Date().toLocaleDateString(undefined, {
    weekday: 'long',
    year: 'numeric',
    month: 'short',
    day: 'numeric'
  });

  // Sync state if currentUser prop changes
  useEffect(() => {
    if (currentUser?.id) setEmpId(currentUser.id);
    if (currentUser?.name) setEmpName(currentUser.name);
  }, [currentUser]);

  // Load user name & attendance details
  useEffect(() => {
    if (!empId) return;

    if (!empName) {
      async function fetchName() {
        try {
          const res = await fetch(`http://localhost:8080/v1/users/get/${empId}`);
          if (res.ok) {
            const data = await res.json();
            if (data?.emp_name) {
              setEmpName(data.emp_name);
              localStorage.setItem("empName", data.emp_name);
            }
          }
        } catch (e) {
          console.log(e);
        }
      }
      fetchName();
    }

    const savedIn = localStorage.getItem(`checkIn_${empId}_${todayIso}`);
    const savedOut = localStorage.getItem(`checkOut_${empId}_${todayIso}`);
    if (savedIn) setCheckInTime(savedIn);
    if (savedOut) setCheckOutTime(savedOut);

    loadDashboardData();
  }, [empId, todayIso]);

  // Load all employees and today's attendance logs
  async function loadDashboardData() {
    setLoadingData(true);
    try {
      // 1. Fetch all employees
      const empRes = await fetch("http://localhost:8080/v1/users/employees");
      let empList = [];
      if (empRes.ok) {
        empList = await empRes.json();
        setAllEmployees(empList);
      }

      // 2. Fetch today's attendance
      const attRes = await fetch("http://localhost:8080/v1/users/attendance/today");
      if (attRes.ok) {
        const attList = await attRes.json();
        const map = {};
        attList.forEach((att) => {
          const id = att.employee?.empId;
          if (id) {
            map[id] = {
              inTime: att.inTime ? String(att.inTime) : '',
              outTime: att.outTime ? String(att.outTime) : '',
            };
          }
        });
        setTodayAttendanceMap(map);

        // Also sync current user's time if present in backend
        if (empId && map[empId]) {
          const savedIn = localStorage.getItem(`checkIn_${empId}_${todayIso}`);
          const savedOut = localStorage.getItem(`checkOut_${empId}_${todayIso}`);
          if (map[empId].inTime && !savedIn) {
            setCheckInTime(map[empId].inTime);
            localStorage.setItem(`checkIn_${empId}_${todayIso}`, map[empId].inTime);
          }
          if (map[empId].outTime && !savedOut) {
            setCheckOutTime(map[empId].outTime);
            localStorage.setItem(`checkOut_${empId}_${todayIso}`, map[empId].outTime);
          }
        }
      }
    } catch (err) {
      console.log("Error loading dashboard data:", err);
    } finally {
      setLoadingData(false);
    }
  }

  // Handle Check In
  async function handleCheckIn() {
    if (!empId) return;
    setLoadingAction(true);
    try {
      const attendance = {
        employee: { empId: Number(empId) },
        attendanceDate: todayIso
      };

      const res = await fetch("http://localhost:8080/v1/users/attendance/mark", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(attendance)
      });

      const text = await res.text();
      setStatusMessage(text);

      const now = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit', second: '2-digit' });
      setCheckInTime(now);
      localStorage.setItem(`checkIn_${empId}_${todayIso}`, now);

      // Refresh list
      loadDashboardData();
    } catch (err) {
      console.log(err);
      setStatusMessage("Error marking attendance");
    } finally {
      setLoadingAction(false);
    }
  }

  // Handle Check Out
  async function handleCheckOut() {
    if (!empId) return;
    setLoadingAction(true);
    try {
      const res = await fetch(`http://localhost:8080/v1/users/attendance/checkout?empId=${empId}`, {
        method: "POST"
      });

      const text = await res.text();
      setStatusMessage(text);

      const now = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit', second: '2-digit' });
      setCheckOutTime(now);
      localStorage.setItem(`checkOut_${empId}_${todayIso}`, now);

      // Refresh list
      loadDashboardData();
    } catch (err) {
      console.log(err);
      setStatusMessage("Error marking check out");
    } finally {
      setLoadingAction(false);
    }
  }

  if (!empId) {
    return (
      <div className="container py-5 text-center" style={{ maxWidth: '480px' }}>
        <div className="card shadow-sm p-4 border">
          <h5 className="fw-semibold mb-2">Access Required</h5>
          <p className="text-secondary mb-3">Please sign in to access your dashboard.</p>
          <button className="btn btn-dark" onClick={() => navigate("/login")}>
            Sign In
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="container py-4" style={{ maxWidth: '960px' }}>
      {/* Top Header */}
      <div className="mb-4 pb-2 border-bottom">
        <h4 className="fw-semibold text-dark mb-1">
          Welcome, {empName || `Employee #${empId}`}
        </h4>
        <span className="text-muted small">
          Employee ID: #{empId} &bull; {todayFormatted}
        </span>
      </div>

      {/* My Attendance Card */}
      <div className="card shadow-sm border mb-4">
        <div className="card-header bg-white py-3 border-bottom d-flex justify-content-between align-items-center">
          <h6 className="mb-0 fw-semibold text-dark">My Daily Attendance</h6>
          <span className="text-muted small">{todayIso}</span>
        </div>
        <div className="card-body p-4">
          {statusMessage && (
            <div className="alert alert-light border py-2 px-3 small mb-3">
              {statusMessage}
            </div>
          )}

          <div className="row g-3 mb-4">
            {/* Check In Tile */}
            <div className="col-sm-6">
              <div className="p-3 border rounded bg-light">
                <div className="d-flex justify-content-between align-items-center mb-1">
                  <span className="text-muted small fw-semibold">CHECK IN TIME</span>
                  <span className={`badge ${checkInTime ? 'bg-success text-white' : 'bg-secondary text-white'}`} style={{ fontSize: '0.7rem' }}>
                    {checkInTime ? 'Recorded' : 'Pending'}
                  </span>
                </div>
                <div className="fs-5 fw-bold text-dark font-monospace">
                  {checkInTime || '--:--:--'}
                </div>
              </div>
            </div>

            {/* Check Out Tile */}
            <div className="col-sm-6">
              <div className="p-3 border rounded bg-light">
                <div className="d-flex justify-content-between align-items-center mb-1">
                  <span className="text-muted small fw-semibold">CHECK OUT TIME</span>
                  <span className={`badge ${checkOutTime ? 'bg-dark text-white' : 'bg-secondary text-white'}`} style={{ fontSize: '0.7rem' }}>
                    {checkOutTime ? 'Recorded' : 'Pending'}
                  </span>
                </div>
                <div className="fs-5 fw-bold text-dark font-monospace">
                  {checkOutTime || '--:--:--'}
                </div>
              </div>
            </div>
          </div>

          {/* Action Buttons */}
          <div className="d-flex gap-2">
            <button
              className="btn btn-dark px-4"
              onClick={handleCheckIn}
              disabled={loadingAction || Boolean(checkInTime)}
            >
              {checkInTime ? 'Checked In' : 'Check In'}
            </button>

            <button
              className="btn btn-outline-dark px-4"
              onClick={handleCheckOut}
              disabled={loadingAction || !checkInTime || Boolean(checkOutTime)}
            >
              {checkOutTime ? 'Checked Out' : 'Check Out'}
            </button>
          </div>
        </div>
      </div>

      {/* All Employees Attendance Table */}
      <div className="card shadow-sm border">
        <div className="card-header bg-white py-3 border-bottom d-flex justify-content-between align-items-center">
          <div>
            <h6 className="mb-0 fw-semibold text-dark">Employee Attendance Directory</h6>
            <span className="text-muted small">Status of all registered employees for today</span>
          </div>
          <button className="btn btn-light btn-sm border text-secondary" onClick={loadDashboardData}>
            Refresh
          </button>
        </div>

        <div className="table-responsive">
          <table className="table table-hover align-middle mb-0">
            <thead>
              <tr>
                <th className="ps-4">ID</th>
                <th>Employee Name</th>
                <th>Designation</th>
                <th>Stack</th>
                <th>Check In</th>
                <th>Check Out</th>
                <th className="text-end pe-4">Status</th>
              </tr>
            </thead>
            <tbody>
              {loadingData ? (
                <tr>
                  <td colSpan="7" className="text-center py-4 text-muted">
                    Loading attendance records...
                  </td>
                </tr>
              ) : allEmployees.length === 0 ? (
                <tr>
                  <td colSpan="7" className="text-center py-4 text-muted">
                    No employees registered yet.
                  </td>
                </tr>
              ) : (
                allEmployees.map((emp) => {
                  const isCurrent = Number(emp.empId) === Number(empId);
                  const att = todayAttendanceMap[emp.empId];

                  // Resolve checkIn & checkOut (prefer local state for current user)
                  const inT = isCurrent && checkInTime ? checkInTime : (att?.inTime || '');
                  const outT = isCurrent && checkOutTime ? checkOutTime : (att?.outTime || '');

                  // Status badge logic
                  let badge = <span className="badge bg-light text-secondary border">Not Checked In</span>;
                  if (inT && outT) {
                    badge = <span className="badge bg-light text-dark border border-dark">Completed</span>;
                  } else if (inT) {
                    badge = <span className="badge bg-success-subtle text-success border border-success">Present</span>;
                  }

                  return (
                    <tr key={emp.empId} className={isCurrent ? "table-active" : ""}>
                      <td className="ps-4 fw-semibold text-secondary">
                        #{emp.empId}
                      </td>
                      <td>
                        <span className="fw-medium text-dark">
                          {emp.emp_name}
                        </span>
                        {isCurrent && (
                          <span className="badge bg-dark text-white ms-2" style={{ fontSize: '0.65rem' }}>
                            You
                          </span>
                        )}
                      </td>
                      <td className="text-muted">{emp.designation || '-'}</td>
                      <td className="text-muted">{emp.stack || '-'}</td>
                      <td className="font-monospace text-dark">
                        {inT || <span className="text-muted">--:--</span>}
                      </td>
                      <td className="font-monospace text-dark">
                        {outT || <span className="text-muted">--:--</span>}
                      </td>
                      <td className="text-end pe-4">
                        {badge}
                      </td>
                    </tr>
                  );
                })
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

export default Dashboard
