import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import Employee from '../types/Employee';

function Registration() {
  const [empId, setEmpId] = useState('');
  const [name, setName] = useState('');
  const [designation, setDesignation] = useState('');
  const [stack, setStack] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const [statusMsg, setStatusMsg] = useState('');
  const navigate = useNavigate();

  async function sendData(e) {
    e.preventDefault();
    if (!empId) {
      alert("Please enter an Employee ID");
      return;
    }

    setLoading(true);
    setStatusMsg('');

    try {
      const employee = new Employee(
        empId,
        name,
        designation,
        stack,
        email,
        password
      );

      const server = await fetch("http://localhost:8080/v1/users/register", {
        method: 'POST',
        body: JSON.stringify(employee),
        headers: { "Content-Type": "application/json" }
      });

      const status = await server.text();
      alert(status);
      setStatusMsg(status);

      if (status.includes("Added") || status.includes("Successfully")) {
        navigate("/login");
      }
    } catch (error) {
      console.log(error);
      setStatusMsg("Failed to register employee.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="container py-5" style={{ maxWidth: '500px' }}>
      <div className="card shadow-sm border p-4">
        <h5 className="fw-semibold text-dark mb-1">Register New Employee</h5>
        <p className="text-muted small mb-4">Create an account to join the HRMS portal</p>

        {statusMsg && (
          <div className="alert alert-light border py-2 px-3 small mb-3">
            {statusMsg}
          </div>
        )}

        <form onSubmit={sendData}>
          <div className="row g-3 mb-3">
            <div className="col-sm-6">
              <label htmlFor="id" className="form-label small fw-semibold text-dark">
                Employee ID
              </label>
              <input
                type="number"
                className="form-control"
                id="id"
                name="id"
                placeholder="e.g. 101"
                value={empId}
                onChange={(e) => setEmpId(e.target.value)}
                required
              />
            </div>

            <div className="col-sm-6">
              <label htmlFor="emp_name" className="form-label small fw-semibold text-dark">
                Full Name
              </label>
              <input
                type="text"
                className="form-control"
                id="emp_name"
                name="emp_name"
                placeholder="e.g. John Doe"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
              />
            </div>
          </div>

          <div className="row g-3 mb-3">
            <div className="col-sm-6">
              <label htmlFor="stack" className="form-label small fw-semibold text-dark">
                Tech Stack
              </label>
              <input
                type="text"
                className="form-control"
                id="stack"
                name="stack"
                placeholder="e.g. Java, Python"
                value={stack}
                onChange={(e) => setStack(e.target.value)}
              />
            </div>

            <div className="col-sm-6">
              <label htmlFor="designation" className="form-label small fw-semibold text-dark">
                Designation
              </label>
              <input
                type="text"
                className="form-control"
                id="designation"
                name="designation"
                placeholder="e.g. Developer"
                value={designation}
                onChange={(e) => setDesignation(e.target.value)}
              />
            </div>
          </div>

          <div className="mb-3">
            <label htmlFor="email" className="form-label small fw-semibold text-dark">
              Email Address
            </label>
            <input
              type="email"
              className="form-control"
              id="email"
              name="email"
              placeholder="e.g. employee@example.com"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          <div className="mb-4">
            <label htmlFor="password" className="form-label small fw-semibold text-dark">
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="password"
              name="password"
              placeholder="Create a password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <button
            type="submit"
            className="btn btn-dark w-100 py-2 mb-3"
            disabled={loading}
          >
            {loading ? 'Submitting...' : 'Register Employee'}
          </button>
        </form>

        <div className="text-center pt-2 border-top">
          <span className="text-muted small">Already registered? </span>
          <Link to="/login" className="small text-dark fw-medium text-decoration-none">
            Sign in here
          </Link>
        </div>
      </div>
    </div>
  )
}

export default Registration
