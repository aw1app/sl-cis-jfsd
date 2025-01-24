import { useState } from "react";


function WeatherForm({ onSubmit }) {

    const [city, setCity] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmit(city);  // Call the onSubmit function passed as a prop
    };

    return (
        <div style={{'border':'solid 2px red'}}>
            WEATHER FORM 
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                placeholder="Enter city"
            />
            <button type="submit">Get Weather</button>
        </form>
        </div>
    )

}

export default WeatherForm;