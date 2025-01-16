
let add = (a, b) => {

    for (let i = 0; i < 1000000000; i++) { };
    //console.log("Inside add function " + (a + b));
    return a + b;
};


// console.log("STATEMENT1");
// console.log("STATEMENT2");
// console.log(`STATEMENT 3  ${add(2, 5)}`);
// console.log("STATEMENT4");
// console.log("STATEMENT5");

let myPromise = new Promise(

    (f1, f2) => {
        // do some long runing job
        let result = add(2, 5);

        let jobSuccess = true; // simulating the job success
        if (jobSuccess) {
            f1(result);
        } else {
            f2(new Error("Could not do the sum"));
        }

    }
);

console.log("STATEMENT 10");
console.log("STATEMENT 20");

myPromise
.then ( res => console.log(`result from the promise is ${res}`))
.catch( err => console.log(`error from the promise is ${err}`));

console.log(`STATEMENT 30 `);
console.log("STATEMENT 40");
console.log("STATEMENT 50");

