import java.util.Scanner;

public class Employee_Mgmt {
    private Employee[] employees;
    private int count;

    Employee_Mgmt(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
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
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
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
        Employee_Mgmt ems = new Employee_Mgmt(10);
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Traverse Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter employee position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = sc.nextDouble();
                    ems.addEmployee(new Employee(id, name, position, salary));
                    break;
                case 2:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = sc.nextInt();
                    Employee emp = ems.searchEmployee(searchId);
                    if (emp != null) {
                        System.out.println("Employee found: " + emp);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    ems.deleteEmployee(deleteId);
                    break;
                case 4:
                    System.out.println("All Employees:");
                    ems.traverseEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

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
