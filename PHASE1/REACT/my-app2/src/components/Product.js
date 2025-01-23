import { Component } from "react";

class Product extends Component {

    productName = "Samsung Mobile";
    productPrice = 0;


    constructor(props){
        super(props);

        this.productName = this.props.name;
        this.productPrice = this.props.price;
    }


    render(){

        return (
            <div style={{'border-width':'2px','border-color':'blue'}}>
            <h2> Name : { this.productName }</h2>
            <h3> Price : { this.productPrice }</h3>
            </div>
        )

    }
}

export default Product;