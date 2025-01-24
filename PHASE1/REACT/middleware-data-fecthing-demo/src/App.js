import './App.css';
import { BrowserRouter as Router, Route, Routes, Link, useParams } from 'react-router-dom';

import { useSelector, useDispatch } from 'react-redux';
import Weather from './components/Weather';
import WeatherForm from './components/WeatherForm';
import { fetchWeather, fetchProducts } from './actions/weather/action'
import Productlist from './components/ProductList';
import NavBar from './components/NavBar';
import './NavBar.css';


function App() {
  const weatherData = useSelector((state) => state.data);
  const loading = useSelector((state) => state.loading);
  const error = useSelector((state) => state.error);

  const products = useSelector((state) => state.products);
  const productsLoading = useSelector((state) => state.productsLoading);
  const productsError = useSelector((state) => state.productsError);

  const dispatch = useDispatch();

  const handleCitySubmit = (city) => {
    dispatch(fetchWeather(city));  // Dispatch the fetchWeather action
  };

  const handleFetchProducts = () => {
    dispatch(fetchProducts());
  };

  return (

    <Router>
      {/* <div className="App">
        <WeatherForm onSubmit={handleCitySubmit} />
        <Weather weatherData={weatherData} loading={loading} error={error} />
        <Productlist
          products={products}
          productsLoading={productsLoading}
          productsError={productsError}
          onFetch={handleFetchProducts} />
      </div> */}

      <NavBar />
      <Route
        path="/weather"
        element={
          <>
            <WeatherForm onSubmit={handleCitySubmit} />
            <Weather weatherData={weatherData} loading={loading} error={error} />
          </>
        }
      />

      <Route
        path="/products"
        element={
          <Productlist
            products={products}
            productsLoading={productsLoading}
            productsError={productsError}
            onFetch={handleFetchProducts}
          />
        }
      />

      {/* Default Route */}
      <Route
        path="/"
        element={<h1>Welcome! Use /weather or /products in the URL.</h1>}
      />
    </Router>

  );
}

export default App;
