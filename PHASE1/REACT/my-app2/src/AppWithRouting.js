// import logo from './logo.svg';
import './App.css';
import './NavBar.css';
import Welcome from './components/Welcome';
import Product from './components/Product';
import ProductF from './components/ProductF';
import ProductList from './components/ProductList';
import EventHandlingDemo from './components/EventHandlingDemo';
import ParentFunctionInPropsDemo from './components/ParentFunctionInPropsDemo';
import Timer from './components/Timer';
import DemoUseEffect from './components/DemoUseEffect'
import DemoUseCounterHook from './DemoUseCounterHook';

import { BrowserRouter as Router, Route, Routes, Link, useParams } from 'react-router-dom';
import NavBar from './components/NavBar';

//function App { 
const AppWithRouting = () => {

  const myFunc = () => {
    alert("Hi from Parent!")
  };


  return (
    <Router>
      <div className="App">

        <h1 style={{ textAlign: 'center' }}>Amzn Product Management</h1>
        <NavBar/>

        {/* Routes for different views */}
        <Routes>
          <Route path="/" element={null} />
          <Route path="/list-products" element={<ProductList />} />
          <Route path="/welcome" element={<Welcome />} />
          <Route path="/timer" element={<Timer />} />
          <Route path="/product" element={<Product />} />          
        </Routes>

      </div>
    </Router>
  );

}

export default AppWithRouting;
