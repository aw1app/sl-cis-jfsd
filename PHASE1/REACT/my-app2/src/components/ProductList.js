
import { Component } from "react";
import productsData from '../products-data'

class ProductList extends Component {
    
    constructor(props){
        super(props);

        this.state={
            products: productsData
        };       

    }


    editProduct = (evt) => {
        console.log("IN editProduct");
    }

    render() {
        return (
            <div style={ {border:"solid 1px", "border-color": 'red'} } >
                <h2>PRODUCT LIST COMPONENT</h2>
                <table border="1">
                    <th>NAME</th><th>PRICE</th><th> EDIT </th>

                    {this.state.products.map( (product) => (
                        <tr> <td>{product.name}</td><td>{product.price}</td> 
                        <td> <button onClick={this.editProduct} >EDIT</button></td> </tr>
                    ))}

                </table>
            </div>
        )
    }
}
export default ProductList;