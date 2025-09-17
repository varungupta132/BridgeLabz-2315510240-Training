package snippet;

class Employee {
 String name;
 int id;
 double salary;

 Employee(String name, int id, double salary) {
     this.name = name;
     this.id = id;
     this.salary = salary;
 }
 void displayDetails() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
     System.out.println("Salary: " + salary);
 }
}
class Manager extends Employee {
 int teamSize;

 Manager(String name, int id, double salary, int teamSize) {
     super(name, id, salary);
     this.teamSize = teamSize;
 }
 void displayDetails() {
     super.displayDetails();
     System.out.println("Team Size: " + teamSize);
     System.out.println("---------------------------");
 }
}
class Developer extends Employee {
 String programmingLanguage;

 Developer(String name, int id, double salary, String programmingLanguage) {
     super(name, id, salary);
     this.programmingLanguage = programmingLanguage;
 }
 void displayDetails() {
     super.displayDetails();
     System.out.println("Programming Language: " + programmingLanguage);
     System.out.println("---------------------------");
 }
}

class Intern extends Employee {
 String schoolName;

 Intern(String name, int id, double salary, String schoolName) {
     super(name, id, salary);
     this.schoolName = schoolName;
 }

 void displayDetails() {
     super.displayDetails();
     System.out.println("School/College: " + schoolName);
     System.out.println("---------------------------");
 }
}

public class EmployeeManagementSystem {
 public static void main(String[] args) {
     Employee manager = new Manager("Alice", 101, 90000, 10);
     Employee developer = new Developer("Bob", 102, 70000, "Java");
     Employee intern = new Intern("Charlie", 103, 20000, "XYZ University");
     manager.displayDetails();
     developer.displayDetails();
     intern.displayDetails();
 }
}
