import { useState,useEffect } from "react";

const DemoUseEffect = () => {

    const [x, setX] = useState(10);
    const [y, setY] = useState(10);

    useEffect(
        
        () => {
        console.log(`1 INSIDE USE EFFECT x has changed to: ${x}`);
        }, 
    
        [x,y]
    );

    useEffect(
        
        () => {
        console.log(`2 INSIDE USE EFFECT x has changed to: ${x}`);
        }, 
    
        [y]
    );

    useEffect(
        
        () => {
        console.log(`3 INSIDE USE EFFECT`);
        }, 
    
        []
    );

    const handleXChange = () => {
        setX(x + 5);
    }
    const handleYChange = () => {
        setY(y + 1);
    }

    return (
        <div style={{ border: "solid 1px", "border-color": 'pink' }}>
            <p> x = {x} </p>
            <p> y = {y} </p>

            <br /><button onClick={handleXChange}> Change X </button>
            <br /><button onClick={handleYChange}> Change Y </button>
        </div>
    );


}

export default DemoUseEffect;