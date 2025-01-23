

const ProductF = (props) => {

   let productName = props.name;
  let productPrice = props.price ;




    return (
        <div style={{border:"solid 1px", "border-color": 'red'} }>
        <h2> Name(F) : { productName }</h2>
        <h3> Price(F) : { productPrice }</h3>
        </div>
    )

};

export default ProductF;