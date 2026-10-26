import { useEffect, useState } from "react"

function SampleCode() {
  const[count, setCount] = useState(10);
  const[pointer, setPointer] = useState(100);

  function changeCount(){
    setCount(count+1);
  }
  
  function changePointer(){
    setPointer(pointer-1);
  }

  useEffect(() =>{
    console.log("count=" + count);
    console.log("Pointer=" + pointer);
  },[count,pointer])

  return (
    <div>
      <h2>Counter Value= {count}</h2>
      <h2>Pointer Value= {pointer}</h2>
      <button onClick={changeCount}
      style={{border:'1px solid black', margin:'1px', padding:'1px'}}>
        Count
      </button>
      <button onClick={changePointer}
      style={{border:'1px solid black', margin:'1px', padding:'1px'}}>
        Pointer
      </button>
    </div>
  
  // <div>
  //   <h2>Employee Details</h2>
  //   <div style={{border:'2px solid black', maxWidth:'110px', margin:'10px', padding:'10px'}}>
  //     <h3>Name: {empData.ename}</h3>
  //     <h3>Id: {empData.empid}</h3>
  //   </div>
  // </div>
  )
}

export default SampleCode