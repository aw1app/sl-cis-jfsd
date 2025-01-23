import { useState } from "react";


const ProductF = (props) => {

    let productName = props.name;
    let productPrice = props.price;

    let [name,setName] = useState('Bajaj TV');
    let [price, setPrice] = useState(100);
    let [inStock,setInStock] = useState(true);

    const changeName = () => {
        //alert("INSIDE changeName method of ProductF");    
        // name = " HA HA 3" ; 
        setName(" HA HA 3");       
    };

    return (
        <div style={{ border: "solid 1px", "border-color": 'red' }}>
            <h2> Name(F) : {productName}</h2>
            <h3> Price(F) : {productPrice}</h3>

            <h2> Name from State : { name }</h2>
            <h3> Price from State: { price }</h3>
            <h3> inStock from State: { inStock ? 'YES' : 'NO' }</h3>

            <br/>
            <button onClick={changeName} > Click me to change state   name </button>
            <br/>
        </div>
    )

};

export default ProductF;