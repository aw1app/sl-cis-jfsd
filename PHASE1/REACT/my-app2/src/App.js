// import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import Product from './components/Product';

function App() {


  return (
    <div className="App">
      <h1 >
        Welcome to Amazon EStore
      </h1>

      <Product name="Samsung Galaxy"  price="20000" />

      <Product name="HP Laptop"  price="25000" />

      <Welcome />
      
    </div>
  );

}

export default App;
