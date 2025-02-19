export const FETCH_WEATHER_REQUEST = 'FETCH_WEATHER_REQUEST';
export const FETCH_WEATHER_SUCCESS = 'FETCH_WEATHER_SUCCESS';
export const FETCH_WEATHER_FAILURE = 'FETCH_WEATHER_FAILURE';

export const FETCH_PRODUCTS_REQUEST = 'FETCH_PRODUCTS_REQUEST';
export const FETCH_PRODUCTS_SUCCESS = 'FETCH_PRODUCTS_SUCCESS';
export const FETCH_PRODUCTS_FAILURE = 'FETCH_PRODUCTS_FAILURE';

export const ADD_PRODUCT_REQUEST = 'ADD_PRODUCTS_REQUEST';

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

  export const fetchProductsRequest = () => (
    {
        type: FETCH_PRODUCTS_REQUEST
    }
);

export const fetchProductsSuccess = (data) => (
    {
    type: FETCH_PRODUCTS_SUCCESS,
    payload: data
  }
);

export const fetchProductsFailure = (error) => ({
    type: FETCH_PRODUCTS_FAILURE,
    payload: error
  });

  export const addProductRequest = (product) => ({
    type: ADD_PRODUCT_REQUEST,
    payload: product
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

  export const fetchProducts = () => {
    return async (dispatch) => {

      dispatch(fetchProductsRequest());

      try {
        const response = await fetch(`http://localhost:5000/products`);
        const data = await response.json();

        console.log("INSIDE fetchProducts of action.js ",data);

        dispatch(fetchProductsSuccess(data));

      } catch (error) {
        dispatch(fetchProductsFailure(error.message));
      }
    };
  };


  export const addProducts = product => {
    return async (dispatch) => {

      dispatch(addProductRequest(product));

      try {
        const response = await fetch(`http://localhost:5000/products`, {
            method:"POST",
            headers: {
                "Content-Type": "application/json", // Set the content type
              },
              body: JSON.stringify(product),
        });
        if (!response.ok) {
            throw new Error("Failed to add the product");
        };
        
        const data = await response.json();
        console.log("INSIDE addProduct of action.js ",data);      

      } catch (error) {
        console.log(error.message);
      }
    };
  };



