import useCounter from "./hooks/useCounter";


const DemoUseCounterHook = () =>{

    let { count, increment, decrement}=  useCounter(100);
    
    
    return(
        <div style={{ border: "dotted 2px", "border-color": 'black' }}>
             <p> Demo Custom Hook  </p>
             <h3> Count : {count} </h3>

             <button onClick={increment}> + </button>
             <button onClick={decrement}> - </button>

        </div>
    )
};

export default DemoUseCounterHook;