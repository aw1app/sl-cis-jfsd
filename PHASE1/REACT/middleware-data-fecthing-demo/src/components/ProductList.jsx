const Productlist = ({ productsLoading, products, productsError, onFetch }) => {

    if (productsLoading) {
        return <div>Loading...</div>;
    }

    if (productsError) {
        return <div>{productsError}</div>;
    }

    if (!products) {
        return <div style={{ 'border': 'solid 2px purple' }}>Products Data not available.</div>;
    }

    return (
        <div style={{ 'border': 'solid 2px purple' }}>
            <h2>PRODUCT LIST COMPONENT</h2>
            <table border="1">
                {products && <thead><th>NAME</th><th>PRICE</th><th> EDIT </th></thead>}

                {products && products.map((product) => (
                    <tr> <td>{product.name}</td><td>{product.price}</td>
                        <td> <button >EDIT</button></td> </tr>
                ))}

            </table>

            <button onClick={onFetch}>Get products</button>

        </div>

    )

}

export default Productlist;