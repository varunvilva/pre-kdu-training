/*
  Create an enum Status with the following members:
  Active
  Inactive
  Suspended

  Define a tuple type UserStatus that contains:
  A User object (from Question 1)
  A Status value

  Write a function printUserStatus that accepts a UserStatus tuple as a parameter and logs a message in the format:
  "[UserName] is currently [Status]."
  
  Create a sample tuple and call the function with it.

  Export the enum Status, the UserStatus tuple type, and the printUserStatus function.
  So that the code can be tested in the test file.
 */
// Define the Status enum
export enum Status {
  Active = "Active",
  Inactive = "Inactive",
  Suspended = "Suspended",
}

// Define the User type alias (from previous question)
export type User = {
  id: number;
  name: string;
  email: string;
  role?: string | undefined;
};

// Define the UserStatus tuple type
export type UserStatus = [User, Status];

// Write the function printUserStatus
export function printUserStatus(userStatus: UserStatus): void {
  const [user, status] = userStatus;
  console.log(`${user.name} is currently ${status}.`);
}

// Sample usage with a tuple
const sampleUser: User = {
  id: 1,
  name: "John Doe",
  email: "john.doe@example.com",
  role: "user",
};

const sampleStatus: Status = Status.Active;

const userStatus: UserStatus = [sampleUser, sampleStatus];

// Call the function with the sample tuple
printUserStatus(userStatus);
