export const FETCH_WEATHER_REQUEST = 'FETCH_WEATHER_REQUEST';
export const FETCH_WEATHER_SUCCESS = 'FETCH_WEATHER_SUCCESS';
export const FETCH_WEATHER_FAILURE = 'FETCH_WEATHER_FAILURE';

export const fetchWeatherRequest = () => (
    {
        type: FETCH_WEATHER_REQUEST
    }
);

export const fetchWeatherSuccess = (data) => (
    {
    type: FETCH_WEATHER_SUCCESS,
    payload: data
  }
);

export const fetchWeatherFailure = (error) => ({
    type: FETCH_WEATHER_FAILURE,
    payload: error
  });

  export const fetchWeather = (city) => {
    return async (dispatch) => {

      dispatch(fetchWeatherRequest());

      try {
        const response = await fetch(
          `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=c706e8c31d7e3e0fcdbb5761d05d6907&units=metric`
        );
        const data = await response.json();

        dispatch(fetchWeatherSuccess(data));

      } catch (error) {
        dispatch(fetchWeatherFailure(error.message));
      }
    };
  };



