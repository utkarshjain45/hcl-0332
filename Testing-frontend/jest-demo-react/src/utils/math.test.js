import {add, subtract, multiply} from "./math.js"

describe("Math Utility Testing", () => {

    //first test
    test('should add two numbers', () => {
        expect(add(10, 20)).toBe(30);
    });

    //second test
    test('should subtract two numbers', () => {
        expect(subtract(30, 20)).toBe(10);
    });

    //third test
    test('should multiply two numbers', () => {
        expect(multiply(10, 20)).toBe(200);
    });
});