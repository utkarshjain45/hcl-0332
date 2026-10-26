import './App.css'
import SampleCode from './component/SampleCode'
import UseFetchApi from './component/useFetchApi'

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
      <h2>Welcome to HRMS</h2>
      <div>
        {/* <SampleCode ename="rahul" empid="28833" /> */}
        {/* <SampleCode empData={employee} /> */}

        {/* {employee.map((ele) => (
          <h2>
            <SampleCode empData={ele}/>
          </h2>
        ))} */}

        <SampleCode />
        <UseFetchApi />
      </div>  
    </>
  )
}

export default App
