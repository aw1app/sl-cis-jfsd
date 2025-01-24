const Productlist = ({ productsLoading, products, productsError, onFetch }) => {

    if (productsLoading) {
        return <div>Loading...</div>;
    }

    if (productsError) {
        return <div>{productsError}</div>;
    }

    if (!products) {
        return <div style={{ 'border': 'solid 2px purple' }}>Weather Data not available. Choose some city</div>;
    }

    return (
        <div style={{ 'border': 'solid 2px purple' }}>
            Product list <br />
            {
                products && products.map(product => <p>{product.name}</p>)
            }

            <button onClick={onFetch}>Get products</button>

        </div>

    )

}

export default Productlist;