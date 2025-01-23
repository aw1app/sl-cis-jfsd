import { useState } from "react";


// const ProductF = (props) => {
    const ProductF = ({name,price}) => { // Destructured props

    // let productName = props.name;
    // let productPrice = props.price;

    // Destructured props
    let productName = name;
    let productPrice = price;

    let [name1,setName1] = useState('Bajaj TV');
    let [price1, setPrice1] = useState(100);
    let [inStock,setInStock] = useState(true);

    const changeName = () => {
        //alert("INSIDE changeName method of ProductF");    
        // name = " HA HA 3" ; 
        setName1(" HA HA 3");       
    };

    return (
        <div style={{ border: "solid 1px", "border-color": 'red' }}>
            <h2> Name(F) : {productName}</h2>
            <h3> Price(F) : {productPrice}</h3>

            <h2> Name from State : { name1 }</h2>
            <h3> Price from State: { price1 }</h3>
            <h3> inStock from State: { inStock ? 'YES' : 'NO' }</h3>

            <br/>
            <button onClick={changeName} > Click me to change state   name </button>
            <br/>
        </div>
    )

};

export default ProductF;