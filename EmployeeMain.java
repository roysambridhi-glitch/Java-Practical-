import java.util.Scanner;

class Employee {
    int emp_no;
    String name, department;
    double basic_pay, DA, HRA, gross_salary;

    Employee(int emp_no, String name, String department, double basic_pay) {
        this.emp_no = emp_no;
        this.name = name;
        this.department = department;
        this.basic_pay = basic_pay;

        DA = 0.50 * basic_pay;    // assumed 50%
        HRA = 0.20 * basic_pay;   // assumed 20%
        gross_salary = basic_pay + DA + HRA;
    }

    void display() {
        System.out.println("Emp No      : " + emp_no);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Basic Pay   : " + basic_pay);
        System.out.println("DA          : " + DA);
        System.out.println("HRA         : " + HRA);
        System.out.println("Gross Salary: " + gross_salary);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees? ");
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of employee " + (i + 1));
            System.out.print("Emp No: ");
            int no = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Department: ");
            String dept = sc.next();
            System.out.print("Basic Pay: ");
            double basic = sc.nextDouble();

            emp[i] = new Employee(no, name, dept, basic);
        }

        Employee highest = emp[0];
        for (int i = 1; i < n; i++) {
            if (emp[i].gross_salary > highest.gross_salary)
                highest = emp[i];
        }

        System.out.println("\nEmployee with highest gross salary:");
        highest.display();
    }
}