#Testing
1. Unit testing -> isolation
2. Integrated Testing
3. End to End Testing

NodeJs by default support in built testing framework from node=>23 version

create simple node app in node-test folder
npm init -y

update package.json
"test": "test" & "type": "module"

create app.js in node-test

```
export const app = (name) =>{
    return `Hello, ${name}`
};
```

export here signify that the method should be used by other file

```
import { test } from 'node:test';
import assert from "node:assert";
```
We use 2 libraries for testing

```
test("greet returns the correct greeting", ()=>{
    const expected = `Hello, World!`;
    const actual = greet("World");

    assert.strictEqual(actual, expected);
})
```
We have used the test function to write the test
and assert for checking the equality

#Suites
When we test different functions combined then it was called as suites

#Jest Framework with Vite and React

Create a vite project in Root folder

npm create vite@latest

install below package under developer dependency

> npm install -D jest babel-jest @babel/core@^7 @babel preset-env@^7 @babel/preset-react@^7

> npm i -D jest-environment-jsdom @testing-library/react @testing-library/jest-dom @testing-library/user-event

> npm install -D identity-obj-proxy

update these files to package.json

```
"test": "test",
"test:watch": "jest --watch",
"test-coverage":"jest --coverage",
```

add these files in folder

1. babel.config.js -> root folder
2. jest.config.js -> root folder
3. src/setupTests.js