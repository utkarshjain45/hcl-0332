import React, { useState } from 'react'

function Login() {
    const[email,setEmail] = useState();
    const[password,setPassword] = useState();

function sendData(){

}

  return (
    <div>
        <form>
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              placeholder="Enter Email"
              onChange={(e)=>setEmail(e.target.value)}
              />
          </div>

          <div class="form-group">
            <label for="password">Password</label>
            <input
              type="password"
              class="form-control"
              id="password"
              name="password"
              placeholder="Enter Password"
              onChange={(e)=>setPassword(e.target.value)}
            />
          </div>

          <button type="submit" class="btn btn-primary" onClick={sendData}>Submit</button>
        </form>
    </div>
  )
}

export default Login