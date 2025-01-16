

 // Simulating an asynchronous operation using a promise
function fetchData(userId) {
        return new Promise(
            
        (f1, f2) => {
            setTimeout(() => {
                if (userId) {
                    f1({ id: userId, name: "John Doe", age: 30 });
                } else {
                    f2("User ID is required");
                }
            }, 2000); // Simulates a 2-second delay
        }
    
    );

    }



// Async function to use await
    async function getUserData(userId) {
        try {
            console.log("Fetching user data...");
            const user = await fetchData(userId); // Await the promise resolution
            console.log("User Data:", user);
        } catch (error) {
            console.error("Error:", error); // Handle errors
        }
    }

    getUserData(1);



