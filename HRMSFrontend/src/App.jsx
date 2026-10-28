import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Login from './component/Login'
import SampleCode from './component/SampleCode'
import UseFetchApi from './component/useFetchApi'
import Dashboard from './component/Dashboard'
import Registration from './component/Registration'
import Home from './component/Home'

function App() {

  const employee=[{
    "ename":"Rahul",
    "empid":"101"
  },{
    "ename":"Amit",
    "empid":"102"
  },{
    "ename":"Ankit",
    "empid":"103"
  },{
    "ename":"Piyush",
    "empid":"104"
  }
]

  return (
    <>
        {/* <h2>Welcome to HRMS</h2> */}
        {/* <SampleCode ename="rahul" empid="28833" /> */}
        {/* <SampleCode empData={employee} /> */}

        {/* {employee.map((ele) => (
          <h2>
          <SampleCode empData={ele}/>
          </h2>
          ))} 
          <SampleCode />
          <UseFetchApi />
          */}
        
        <div>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<Home />}></Route>
            <Route path='/dashboard' element={<Dashboard />}></Route>
            <Route path='/login' element={<Login />}></Route>
            <Route path='/register' element={<Registration />}></Route>
          </Routes>
        </BrowserRouter>
      </div>  
    </>
  )
}

export default App
