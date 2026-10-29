export default class Employee {
  constructor(empId, emp_name, designation, stack, email, password) {
    this.empId = empId !== undefined && empId !== "" ? Number(empId) : null;
    this.id = this.empId;
    this.emp_name = emp_name;
    this.designation = designation;
    this.stack = stack;
    this.email = email;
    this.password = password;
  }
}
