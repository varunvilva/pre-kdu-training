/*
  Define a generic function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] that filters an array based on a predicate function.
  Use this function to filter an array of numbers and return only even numbers.
  Use the same function to filter an array of User objects and return users whose email includes "@company.com".

  Export the filterArray function so that the code can be tested in the test file.
*/
// Generic function to filter an array based on a predicate
export function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] {
  return arr.filter(predicate);
}

// Example usage with an array of numbers to filter only even numbers
const numbers = [1, 2, 3, 4, 5, 6];
const evenNumbers = filterArray(numbers, (num) => num % 2 === 0);
console.log("Even Numbers:", evenNumbers); // Output: [2, 4, 6]

// Define a User interface
interface User {
  name: string;
  email: string;
}

// Example usage with an array of User objects to filter users with "@company.com" in their email
const users: User[] = [
  { name: "Alice", email: "alice@company.com" },
  { name: "Bob", email: "bob@gmail.com" },
  { name: "Charlie", email: "charlie@company.com" },
];

const companyUsers = filterArray(users, (user) => user.email.includes("@company.com"));
console.log("Company Users:", companyUsers);
// Output: [{ name: "Alice", email: "alice@company.com" }, { name: "Charlie", email: "charlie@company.com" }]
