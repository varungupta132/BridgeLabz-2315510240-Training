package aadi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {

    interface Department {
        void assignDepartment(String deptName);
        String getDepartmentDetails();
    }

    abstract static class Employee {
        private int employeeId;
        private String name;
        private double baseSalary;

        public Employee(int employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }

        public abstract double calculateSalary();

        public void displayDetails() {
            System.out.println("ID: " + employeeId);
            System.out.println("Name: " + name);
            System.out.println("Base Salary: " + baseSalary);
            System.out.println("Final Salary: " + calculateSalary());
        }
    }

    static class FullTimeEmployee extends Employee implements Department {
        private String departmentName;

        public FullTimeEmployee(int employeeId, String name, double baseSalary) {
            super(employeeId, name, baseSalary);
        }

        @Override
        public double calculateSalary() {
            return getBaseSalary() + (0.20 * getBaseSalary());
        }

        @Override
        public void assignDepartment(String deptName) {
            this.departmentName = deptName;
        }

        @Override
        public String getDepartmentDetails() {
            return "Department: " + departmentName;
        }
    }

    static class PartTimeEmployee extends Employee implements Department {
        private int hoursWorked;
        private double hourlyRate;
        private String departmentName;

        public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
            super(employeeId, name, 0);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }

        @Override
        public void assignDepartment(String deptName) {
            this.departmentName = deptName;
        }

        @Override
        public String getDepartmentDetails() {
            return "Department: " + departmentName;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee f1 = new FullTimeEmployee(101, "Aadi Sharma", 50000);
        f1.assignDepartment("IT");
        PartTimeEmployee p1 = new PartTimeEmployee(102, "Ravi Kumar", 500, 40);
        p1.assignDepartment("Support");
        employees.add(f1);
        employees.add(p1);
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                Department dept = (Department) emp;
                System.out.println(dept.getDepartmentDetails());
            }
            System.out.println("-----------------------");
        }
    }
}
