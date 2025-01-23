import { Component } from "react";

class Product extends Component {

    productName = "Samsung Mobile";
    productPrice = 0;


    constructor(props){
        super(props);

        this.productName = this.props.name;
        this.productPrice = this.props.price;

        this.state = {
            name: this.props.name,
            price: this.props.price,
            quantity: 10
        };

        this.changeName = this.changeName.bind(this);
        this.changeNameOfInstacnceVar = this.changeNameOfInstacnceVar.bind(this);
    }

    changeNameOfInstacnceVar(){
        alert("INSIDE changeNameOfInstacnceVar method");
        this.productName = "HAHA 2";
        console.log("this.productName = ", this.productName);
    }

    changeName(){
        //alert("INSIDE changeName method");
        //this.state.name = "HAHA"; // will not work. state variable/data cannot be changed directly

        this.setState( {name:"HAHA 1" });
    }


    render(){

        return (
            <div style={{border:"solid 1px", "border-color": 'blue'} }>
            <h2> Name : { this.productName }</h2>
            <h3> Price : { this.productPrice }</h3>

            <h2> Name from State : { this.state.name }</h2>
            <h3> Price from State: { this.state.price }</h3>
            <h3> Quantity from State: { this.state.quantity }</h3>

            <button onClick={this.changeName} > Click me to change state   name </button>
            <br/>
            <button onClick={this.changeNameOfInstacnceVar} > Click me to change non-state name </button>
            </div>
        )

    }
}

export default Product;