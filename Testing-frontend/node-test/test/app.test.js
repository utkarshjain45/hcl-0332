import { greet, greetInHindi, processOrder } from "../app.js";
import { describe, mock, test } from 'node:test';
import assert from "node:assert";

describe("Order Feature", ()=>{
    test("That it process the order correctly", ()=>{
        //mock funtion
        const mockedProcessPayment = mock.fn((amount)=>{
            console.log("I am Mock process payment Function")
            return {id: "123", amount};
        });

        const expected = {id: "123", amount: 5000};
        const actual = processOrder({amount:5000}, {processpayment:mockedProcessPayment})
        assert.deepStrictEqual(actual, expected);
    });
});

describe("Greeting Functions", ()=>{
    test("greet returns the correct greeting in English", ()=>{
        const expected = `Hello, World!`;
        const actual = greet("World");
    
        assert.strictEqual(actual, expected);
    })
    
    test("greet returns the correct greeting in Hindi", ()=>{
        const expected = `Namaste, Duniya!`;
        const actual = greetInHindi("Duniya");
    
        assert.strictEqual(actual, expected);
    })
})
