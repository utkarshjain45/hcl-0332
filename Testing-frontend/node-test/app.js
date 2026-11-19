export const greet = (name) =>{
    return `Hello, ${name}!`
};

export const greetInHindi= (name) => {
    return `Namaste, ${name}!`;
};

export const processOrder = (data, depedency) => {
    //apply logic
    //call payment gateway
    const paymentInfo = depedency.processpayment(data.amount);
    return paymentInfo;
};

//implementation 
const processPayment = (amount) => {
    //API call to external payment gateway
    console.log("I am original processPayment");
    return {id : 123, amount};
};