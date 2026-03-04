
//Guys use lang to og camel case sa naming

import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

    }

}

abstract class User {

    private String id;
    private String name;
    private String email;

    User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract void displayMenu();

}

class Customer extends User {

    public Customer(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayMenu() {
        System.out.println("--- Customer Menu ---");
        System.out.println("1. View Movies");
        System.out.println("2. Book a Ticket");
        System.out.println("3. My History");
    }

    // public void makeBooking();

}