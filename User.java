
abstract class User {

    private String id;
    private String name;

    User(String id, String name) {
        this.id = id;
        setName(name);
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public abstract void displayMenu();

    // Getter for the name
    public String getName() {
        return name;
    }

}

class Customer extends User {

    public Customer(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayMenu() {
        System.out.println("1. View Movies & Showtimes");
        System.out.println("2. Book Tickets");
        System.out.println("3. View Available Seats");
        System.out.println("4. Back to Main");

    }

}

class Cashier extends User {

    public Cashier(String id, String name) {
        super(id, name);
    }

    public void displayMenu() {
        System.out.println("--- CASHIER SYSTEM ---");
        System.out.println("1. Process Customer Booking");
        System.out.println("2. Quick Book (name + seats)");
        System.out.println("3. View Today's Sales");
        System.out.println("4. Back to Main");
    }

}

class Admin extends User {

    Admin(String id, String name) {
        super(name, id);
    }

    public void displayMenu() {

        System.out.println("--- ADMIN DASHBOARD ---");
        System.out.println("Total tickets: ");
        System.out.println("Total Revenue: ");
        System.out.println(" "); // Avengers: (movie) + number of tickets + total revenue

    }
}