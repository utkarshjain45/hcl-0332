import React, { useEffect, useState } from 'react'

function UseFetchApi() {
    const[products, setProducts] = useState([]);

    useEffect(() => {
        async function getData(){
            try{
                const products = await fetch("http://localhost:8080/employees");
                const jsonData = await products.json();
                setProducts(jsonData);
                console.log(jsonData);
            }
            catch(e){
                console.log(e);
            }
        }

        getData();
    },[])

  return (
    <div>
        {
            JSON.stringify(products)
        }
    </div>
  )
}

export default UseFetchApi