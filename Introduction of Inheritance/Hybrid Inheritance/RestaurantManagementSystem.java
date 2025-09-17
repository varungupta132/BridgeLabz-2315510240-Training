package snippet;

interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    public void performDuties() {
        System.out.println(name + " is cooking " + specialty + " dishes.");
    }
}

class Waiter extends Person implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Alice", 101, "Italian");
        Waiter waiter = new Waiter("Bob", 202, 5);

        chef.displayInfo();
        chef.performDuties();
        System.out.println("-------------------");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
