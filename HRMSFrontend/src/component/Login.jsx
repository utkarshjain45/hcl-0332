import React, { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom'

function Login({ onLoginSuccess }) {
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState('');
  const navigate = useNavigate();

  async function sendData(e) {
    e.preventDefault();
    setLoading(true);
    setErrorMsg('');

    try {
      const formData = new FormData();
      formData.append("id", id);
      formData.append("password", password);

      const response = await fetch("http://localhost:8080/v1/users/login", {
        method: "POST",
        body: formData
      });

      const data = await response.text();

      if (data === "Login Successfull") {
        let empName = "";
        try {
          const userRes = await fetch(`http://localhost:8080/v1/users/get/${id}`);
          if (userRes.ok) {
            const userData = await userRes.json();
            if (userData && userData.emp_name) {
              empName = userData.emp_name;
            }
          }
        } catch (err) {
          console.log("Could not load employee name", err);
        }

        if (onLoginSuccess) {
          onLoginSuccess({ id, name: empName });
        } else {
          localStorage.setItem("empId", id);
          if (empName) localStorage.setItem("empName", empName);
        }

        alert(data);
        navigate("/dashboard");
      } else {
        setErrorMsg(data);
        alert(data);
      }
    } catch (error) {
      console.log(error);
      setErrorMsg("Error connecting to server");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="container py-5" style={{ maxWidth: '440px' }}>
      <div className="card shadow-sm border p-4">
        <h5 className="fw-semibold text-dark mb-1">Employee Login</h5>
        <p className="text-muted small mb-4">Enter your credentials to access the portal</p>

        {errorMsg && (
          <div className="alert alert-light border border-danger text-danger py-2 px-3 small mb-3">
            {errorMsg}
          </div>
        )}

        <form onSubmit={sendData}>
          <div className="mb-3">
            <label htmlFor="id" className="form-label small fw-semibold text-dark">
              Employee ID
            </label>
            <input
              type="number"
              className="form-control"
              id="id"
              name="id"
              placeholder="Enter your Employee ID"
              value={id}
              onChange={(e) => setId(e.target.value)}
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
              placeholder="Enter your password"
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
            {loading ? 'Signing in...' : 'Sign In'}
          </button>
        </form>

        <div className="text-center pt-2 border-top">
          <span className="text-muted small">Don't have an account? </span>
          <Link to="/register" className="small text-dark fw-medium text-decoration-none">
            Register here
          </Link>
        </div>
      </div>
    </div>
  )
}

export default Login
