import React from 'react'
import { Link } from 'react-router-dom'

function Home({ currentUser }) {
  return (
    <div className="container py-5" style={{ maxWidth: '560px' }}>
      <div className="card shadow-sm border p-4 text-center">
        <h4 className="fw-semibold text-dark mb-2">HRMS Portal</h4>
        <p className="text-secondary small mb-4">
          Human Resource Management System &bull; Manage employee registration and track daily check-in and check-out attendance.
        </p>

        {currentUser ? (
          <div className="p-3 bg-light rounded border mb-4 text-start">
            <span className="text-muted small d-block">Signed in as</span>
            <span className="fw-semibold text-dark fs-6">
              {currentUser.name || `Employee #${currentUser.id}`}
            </span>
            <div className="mt-3">
              <Link to="/dashboard" className="btn btn-dark btn-sm px-4">
                Go to Dashboard
              </Link>
            </div>
          </div>
        ) : (
          <div className="d-flex justify-content-center gap-3">
            <Link to="/login" className="btn btn-dark px-4 py-2">
              Sign In
            </Link>
            <Link to="/register" className="btn btn-outline-dark px-4 py-2">
              Register Employee
            </Link>
          </div>
        )}
      </div>
    </div>
  )
}

export default Home
