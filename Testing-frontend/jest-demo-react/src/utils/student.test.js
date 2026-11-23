import {isEligible} from "./student.js"

describe("Student Attendance Test", () => {

    test('attendance with 85%', () => {
        expect(isEligible(85)).toBe(true);
    });
    
    test('attendace with 60%', () => {
        expect(isEligible(60)).toBe(false);
    });
    
    test('attendace with 75%', () => {
        expect(isEligible(75)).toBe(true);
    });
    
    test('Invalid Attendance', () => {
        expect(() => isEligible(110)).toThrow("Invalid Attendance Value");
    });
});