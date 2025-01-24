import {
    FETCH_WEATHER_REQUEST,
    FETCH_WEATHER_SUCCESS,
    FETCH_WEATHER_FAILURE,
    FETCH_PRODUCTS_REQUEST,
    FETCH_PRODUCTS_SUCCESS,
    FETCH_PRODUCTS_FAILURE
} from '../actions/weather/action';

const initialState = {
    loading: false,
    data: null,
    error: null,
    products: [],
    productsLoading: false,
    productsError: null,
};

export const weatherReducer = (state = initialState, action) => {
    switch (action.type) {

        case FETCH_WEATHER_REQUEST:
            return {
                ...state,
                loading: true
            };

        case FETCH_WEATHER_SUCCESS:
            return {
                loading: false,
                data: action.payload,
                error: null
            };

        case FETCH_WEATHER_FAILURE:
            return {
                loading: false,
                data: null,
                error: action.payload
            };

        case FETCH_PRODUCTS_REQUEST:
            return {
                ...state,
                productsLoading: true
            };

        case FETCH_PRODUCTS_SUCCESS:
            return {
                productsLoading: false,
                products: action.payload,
                productsError: null
            };

        case FETCH_PRODUCTS_FAILURE:
            return {
                productsLoading: false,
                products: [],
                productsError: action.payload
            };

        default: return state;
    }

}