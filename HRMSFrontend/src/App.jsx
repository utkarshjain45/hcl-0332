import { useState } from 'react'
import { BrowserRouter, Route, Routes, Link, useNavigate } from 'react-router-dom'
import './App.css'
import Login from './component/Login'
import Dashboard from './component/Dashboard'
import Registration from './component/Registration'
import Home from './component/Home'

function Navbar({ currentUser, onLogout }) {
  const navigate = useNavigate();

  const handleLogout = () => {
    onLogout();
    navigate("/login");
  };

  return (
    <nav className="navbar navbar-expand navbar-light bg-white border-bottom shadow-sm py-3">
      <div className="container" style={{ maxWidth: '960px' }}>
        <Link className="navbar-brand fw-bold text-dark fs-5 mb-0" to="/">
          HRMS
        </Link>

        <div className="navbar-nav ms-auto align-items-center gap-2">
          <Link className="nav-link text-secondary px-2" to="/">Home</Link>
          <Link className="nav-link text-secondary px-2" to="/register">Register</Link>
          <Link className="nav-link text-secondary px-2" to="/dashboard">Dashboard</Link>

          {currentUser ? (
            <div className="d-flex align-items-center ms-2 ps-3 border-start gap-3">
              <span className="small fw-semibold text-dark">
                {currentUser.name || `ID: #${currentUser.id}`}
              </span>
              <button
                onClick={handleLogout}
                className="btn btn-outline-secondary btn-sm py-1 px-3"
              >
                Logout
              </button>
            </div>
          ) : (
            <Link className="btn btn-dark btn-sm ms-2 py-1 px-3" to="/login">
              Login
            </Link>
          )}
        </div>
      </div>
    </nav>
  );
}

function App() {
  const [currentUser, setCurrentUser] = useState(() => {
    const id = localStorage.getItem("empId");
    const name = localStorage.getItem("empName");
    return id ? { id, name } : null;
  });

  const handleLoginSuccess = (user) => {
    localStorage.setItem("empId", user.id);
    if (user.name) localStorage.setItem("empName", user.name);
    setCurrentUser(user);
  };

  const handleLogout = () => {
    localStorage.removeItem("empId");
    localStorage.removeItem("empName");
    setCurrentUser(null);
  };

  return (
    <BrowserRouter>
      <Navbar currentUser={currentUser} onLogout={handleLogout} />
      <main className="min-vh-100 py-4" style={{ backgroundColor: "#f8fafc" }}>
        <Routes>
          <Route path='/' element={<Home currentUser={currentUser} />} />
          <Route path='/dashboard' element={<Dashboard currentUser={currentUser} onLogout={handleLogout} />} />
          <Route path='/login' element={<Login onLoginSuccess={handleLoginSuccess} />} />
          <Route path='/register' element={<Registration />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App
