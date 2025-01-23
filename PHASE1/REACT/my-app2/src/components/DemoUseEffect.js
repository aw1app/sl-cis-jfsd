import { useState, useEffect } from "react";

const DemoUseEffect = () => {
    const [products, setProducts] = useState(null);

    const [x, setX] = useState(10);
    const [y, setY] = useState(10);

    useEffect(

        () => {
            console.log("INSIDE USE EFFECT to Fetch products data");
            for(let i=0; i<1000000000; i++){};// simulate delay
            fetch('http://localhost:5000/products')
                .then(response => response.json())
                .then(data => setProducts(data))
                .catch(error => console.error(error));
        },

        []
    );

    useEffect(

        () => {
            console.log(`1 INSIDE USE EFFECT x has changed to: ${x}`);
        },

        [x, y]
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
            {products ? (
                <ul>
                    {products.map(item => (
                        <li key={item.id}>{item.name}</li>
                    ))}
                </ul>
            ) : (
                <p>Loading...</p>
            )}
            <br/>

            <p> x = {x} </p>
            <p> y = {y} </p>

            <br /><button onClick={handleXChange}> Change X </button>
            <br /><button onClick={handleYChange}> Change Y </button>
        </div>
    );


}

export default DemoUseEffect;