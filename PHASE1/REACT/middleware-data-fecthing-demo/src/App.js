import './App.css';

import {useSelector, useDispatch, Provider } from 'react-redux';
import Weather from './components/Weather';
import WeatherForm from './components/WeatherForm';
import {fetchWeather,fetchProducts} from './actions/weather/action'
import Productlist from './components/ProductList';

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
   
      <div className="App">
      <WeatherForm onSubmit={handleCitySubmit}/>
      <Weather weatherData={weatherData} loading={loading} error={error} />
      <Productlist 
      products={products} 
      productsLoading={productsLoading}
      productsError={productsError} 
      onFetch={handleFetchProducts} />
      </div>
    
  );
}

export default App;
