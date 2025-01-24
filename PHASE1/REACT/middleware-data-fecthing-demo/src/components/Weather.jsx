
const Weather = ({ loading, weatherData, error }) => {

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>{error}</div>;
    }

    if (!weatherData) {
        return <div style={{'border':'solid 2px blue'}}>Weather Data not available. Choose some city</div>;
    }

    return (
        <div style={{'border':'solid 2px blue'}}>
            WEATHER DATA  
            <p>Current temperature: {weatherData.main.temp}°F</p>
            <p>Feels like: {weatherData.main.feels_like}°F</p>
            <p>Humidity: {weatherData.main.humidity}%</p>
            <p>Pressure: {weatherData.main.pressure} hPa</p>
        </div>

    )

}

export default Weather;