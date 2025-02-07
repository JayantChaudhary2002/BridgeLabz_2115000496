// Superclass Person
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + " | ID: " + id);
    }
}

// Interface Worker for multiple behavior
interface Worker {
    void performDuties();
}

// Chef subclass inheriting from Person and implementing Worker
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        super.displayDetails();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Cooking delicious meals.");
    }
}

// Waiter subclass inheriting from Person and implementing Worker
class Waiter extends Person implements Worker {
    private int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        super.displayDetails();
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Serving food and attending to customers.");
    }
}

public class Q10_RestaurentManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "French Cuisine");
        Waiter waiter = new Waiter("John Doe", 202, 5);

        System.out.println("--- Chef Details ---");
        chef.performDuties();

        System.out.println("\n--- Waiter Details ---");
        waiter.performDuties();
    }
}



