

 // Async function to fetch data from an API
 async function fetchUserData() {
    try {
        console.log("Fetching user data...");
        const response = await fetch("https://jsonplaceholder.typicode.com/todos/1"); // API call
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const user = await response.json(); // Parse the JSON response
        console.log("User Data:", user);
    } catch (error) {
        console.error("Error fetching data:", error); // Handle errors
    }
}

fetchUserData();