export default {
  testEnvironment: "jsdom",

  transform: {
    "^.+\\.[jt]sx?$": "babel-jest",
  },

  setupFilesAfterEnv: ["<rootDir>/src/setupTest.js"],

  moduleNameMapper: {
    "\\.(css|less|scss)$": "identity-obj-proxy",
  },
};
