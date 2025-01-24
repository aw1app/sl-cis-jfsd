import {
    FETCH_WEATHER_REQUEST,
    FETCH_WEATHER_SUCCESS,
    FETCH_WEATHER_FAILURE
} from '../actions/weather/action';

const initialState = {
    loading: false,
    data: null,
    error: null
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

    }

}