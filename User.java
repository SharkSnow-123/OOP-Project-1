public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayMenu();
}

class Customer extends User {
    public Customer(String name, String id) {
        super(name); 
    }

    @Override
    public void displayMenu() {
        System.out.println("1. View Movies & Showtimes");
        System.out.println("2. Book Tickets");
        System.out.println("3. View Available Seats");
        System.out.println("4. Back to Main");
    }
}

class Admin extends User {
    public Admin(String name, String id) {
        super(name);
    }

    @Override
    public void displayMenu() {
        System.out.println("--- ADMIN DASHBOARD ---");
        System.out.println("Total tickets: ");
        System.out.println("Total Revenue: ");
        System.out.println(" "); 
    }
}