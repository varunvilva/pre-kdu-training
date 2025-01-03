/*
  Create a utility function findById that takes an array of User objects and a number as arguments and returns a User | undefined (if the user with the given ID exists).
  Extend the function to support a new parameter, which specifies if the returned user should include undefined or throw an error. Use TypeScript's never type to represent the error-throwing case.
  Test the function using a sample array of User objects and handle both scenarios (with and without throwing an error).

  Export the function findById so that it can be used in the test file.
*/

// Define the User interface
interface User {
  id: number;
  name: string;
  email: string;
}

// Utility function to find a user by ID
export function findById(
  users: User[],
  id: number,
  throwError: boolean = false
): User | undefined {
  const user = users.find((user) => user.id === id);

  if (!user && throwError) {
    throw new Error(`User with ID ${id} not found.`);
  }

  return user;
}

// Example usage
const users: User[] = [
  { id: 1, name: "Alice", email: "alice@company.com" },
  { id: 2, name: "Bob", email: "bob@gmail.com" },
  { id: 3, name: "Charlie", email: "charlie@company.com" },
];

// Scenario 1: Find user without throwing an error
try {
  const foundUser = findById(users, 2); // Should return Bob
  console.log("Found User:", foundUser);
} catch (error) {
  console.error("Error:", error);
}

// Scenario 2: Find user and throw an error if not found
try {
  const foundUser = findById(users, 5, true); // Should throw an error
  console.log("Found User:", foundUser);
} catch (error) {
  console.error("Error:", error.message);
}
