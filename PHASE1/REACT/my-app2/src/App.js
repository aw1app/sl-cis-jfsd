// import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import Product from './components/Product';
import ProductF from './components/ProductF';
import ProductList from './components/ProductList';

//function App { 
const App = () => {


  return (
    <div className="App">
      <h1 >
        Welcome to Amazon EStore
      </h1>
      <ProductList />

      <Product name="Samsung Galaxy"  price="20000" />

      <Product name="HP Laptop"  price="25000" />

      <ProductF name="Dell Mouse"  price="200" />

      <Welcome />
      
    </div>
  );

}

export default App;
