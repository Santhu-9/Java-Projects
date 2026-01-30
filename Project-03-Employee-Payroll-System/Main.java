import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double calculateSalary() {
        return 0;
    }

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;

    public FullTimeEmployee(int id, String name,  double baseSalary, double bonus) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public double calculateSalary() {
        return baseSalary + bonus;
    }

    public void display() {
        super.display();
        System.out.println("Salary: " +  calculateSalary());
        System.out.println("Type: Full Time");
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hours;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hours) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    public double calculateSalary() {
        return hourlyRate * hours;
    }

    public void display() {
        super.display();
        System.out.println("Salary: " +  calculateSalary());
        System.out.println("Type: Part Time");
    }
}

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                              1.Add Full Time Employee
                              2.Add Part Time Employee
                              3.Display All Employees
                              4.Calculate salary(by employee Id:)
                              5.Exit""");

            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> addFullTimeEmployee();
                case 2 -> addPartTimeEmployee();
                case 3 -> displayAllEmployees();
                case 4 -> calculateSalaryById();
                case 5 -> {
                    System.out.println("Thank you for using this program!");
                    System.out.println("Exiting....");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addFullTimeEmployee() {
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Name: ");
        String name = input.nextLine();
        System.out.println("Enter Employee Base Salary: ");
        double baseSalary = input.nextDouble();
        System.out.println("Enter Employee Bonus: ");
        double bonus = input.nextDouble();

        employees.add(new FullTimeEmployee(id, name, baseSalary, bonus));

        System.out.println("Full Time Employee Added Successfully!");
    }

    static void addPartTimeEmployee() {
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Name: ");
        String name = input.nextLine();
        System.out.println("Enter Employee hourly Rate: ");
        double hourlyRate = input.nextDouble();
        System.out.println("Enter Employee hours: ");
        int hours = input.nextInt();

        employees.add(new PartTimeEmployee(id, name, hourlyRate, hours));

        System.out.println("Part Time Employee Added Successfully!");
    }

    static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("There are no employees available!");
            return;
        }
        for (Employee employee : employees) {
            employee.display();
            System.out.println("___________________________");
        }
    }

    static void calculateSalaryById() {
        if (employees.isEmpty()) {
            System.out.println("There are no employees available!");
            return;
        }

        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Employee Salary: Rs " + employee.calculateSalary());
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }
}