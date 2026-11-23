export const isEligible = (atten) => {
    if (atten < 0 || atten > 100) {
        throw new Error("Invalid Attendance Value");
    }
    return atten >= 75;
};