import React, { useState } from 'react'
import Employee from '../types/Employee';

function Registration() {
    const[empId, setEmpId] = useState();
    const[name, setName] = useState();
    const[designation, setDesignation] = useState();
    const[stack, setStack] = useState();
    const[email, setEmail] = useState();
    const[password, setPassword] = useState();

async function sendData(e){
    try {
      e.preventDefault();
      const employee = new Employee(
                        empId,
                        name,
                        designation,
                        stack,
                        email,
                        password
                      );

      const server = await fetch("http://localhost:8080/v1/users/add",{
                  method:'Post',
                  body: JSON.stringify(employee),
                  headers:{"Content-Type":"application/json"} 
                });
      const status = await server.text();
      alert(status);
    } catch (error) {
      console.log(error);
    }
}

  return (
    <div>
        <htmlForm>
          <div className="htmlForm-group">
            <label htmlFor="id">ID</label>
            <input
              type="number"
              className="htmlForm-control"
              id="id"
              name="id"
              placeholder="Enter ID"
              onChange={(e)=>setEmpId(e.target.value)}
              />
          </div>

          <div className="htmlForm-group">
            <label htmlFor="emp_name">Employee Name</label>
            <input
              type="text"
              className="htmlForm-control"
              id="emp_name"
              name="emp_name"
              placeholder="Enter Employee Name"
              onChange={(e)=>setName(e.target.value)}
              />
          </div>

          <div className="htmlForm-group">
            <label htmlFor="stack">Stack</label>
            <input
              type="text"
              className="htmlForm-control"
              id="stack"
              name="stack"
              placeholder="Enter Stack (e.g., Java, Python)"
              onChange={(e)=>setStack(e.target.value)}
              />
          </div>
          
          <div className="htmlForm-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              className="htmlForm-control"
              id="email"
              name="email"
              placeholder="Enter Email"
              onChange={(e)=>setEmail(e.target.value)}
              />
          </div>

          <div className="htmlForm-group">
            <label htmlFor="designation">Designation</label>
            <input
              type="text"
              className="htmlForm-control"
              id="designation"
              name="designation"
              placeholder="Enter Designation"
              onChange={(e)=>setDesignation(e.target.value)}
              />
          </div>

          <div className="htmlForm-group">
            <label htmlFor="password">Password</label>
            <input
              type="password"
              className="htmlForm-control"
              id="password"
              name="password"
              placeholder="Enter Password"
              onChange={(e)=>setPassword(e.target.value)}
            />
          </div>

          <button type="submit" className="btn btn-primary" onClick={sendData}>Submit</button>
        </htmlForm>
    </div>
  )
}

export default Registration