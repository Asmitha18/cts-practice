import java.util.Scanner;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Method to search an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Method to traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Scanner sc = new Scanner(System.in);

        // Adding some employees
        ems.addEmployee(new Employee(1, "John Doe", "Manager", 50000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Developer", 40000));
        ems.addEmployee(new Employee(3, "Bob Johnson", "Designer", 45000));

        // Traversing employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Searching for an employee
        System.out.print("Enter employee ID to search: ");
        int searchId = sc.nextInt();
        Employee emp = ems.searchEmployee(searchId);
        if (emp != null) {
            System.out.println("Employee found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        System.out.print("Enter employee ID to delete: ");
        int deleteId = sc.nextInt();
        ems.deleteEmployee(deleteId);

        // Traversing employees again
        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();

        sc.close();
    }
}

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}
