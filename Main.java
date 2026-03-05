
//Guys use lang to og camel case sa naming

import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        User currentUser = null;

        System.out.println("=================================================================");
        System.out.println("                    DIRK PERSONAL AWESOME THEATRE              ");
        System.out.println("=================================================================");
        System.out.println("What type of user are you? ");
        System.out.println("1. Customer \t (Book your own tickets)");
        System.out.println("2. Cashier \t (Book for customers)");
        System.out.println("3. Admin \t (View Reports)");
        System.out.println("4. Exit: ");

        System.out.print("Enter Choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                currentUser = new Customer("1000", "Careza");
                break;

            case 3:
                currentUser = new Admin("3000", "Dirk");
                break;

            case 4:
                System.out.println("Shutting Down...");
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
        }

        if (currentUser != null) {
            System.out.println("Login Successful as " + currentUser.getName());
            currentUser.displayMenu();
        }

        sc.close();

    }

}
