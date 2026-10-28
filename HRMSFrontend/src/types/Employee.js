export default class Employee {
  constructor(id, emp_name, designation, stack, email, password) {
    this.id = Number(id);
    this.emp_name = emp_name;
    this.designation = designation;
    this.stack = stack;
    this.email = email;
    this.password = password;
  }
}