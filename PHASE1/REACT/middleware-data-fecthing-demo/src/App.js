import './App.css';

import {useSelector, useDispatch, Provider } from 'react-redux';
import Weather from './components/Weather';
import WeatherForm from './components/WeatherForm';
import {fetchWeather} from './actions/weather/action'

function App() {
  const weatherData = useSelector((state) => state.data);
  const loading = useSelector((state) => state.loading);
  const error = useSelector((state) => state.error);

  const dispatch = useDispatch();

  const handleCitySubmit = (city) => {
    dispatch(fetchWeather(city));  // Dispatch the fetchWeather action
  };

  return (
   
      <div className="App">
      <WeatherForm onSubmit={handleCitySubmit}/>
      <Weather weatherData={weatherData} loading={loading} error={error} />
      
      </div>
    
  );
}

export default App;
