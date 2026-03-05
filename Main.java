
//Guys use lang to og camel case sa naming

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Showtime currentShowtime = new Showtime(); 
        SalesReport dailyReport = new SalesReport("2026-03-05");
        
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=================================================================");
            System.out.println("                    CREZA PERSONAL AWESOME THEATRE               ");
            System.out.println("=================================================================");
            System.out.println("What type of user are you? \n");
            System.out.println("1. Customer \t (Book your own tickets)");
            System.out.println("2. Cashier \t (Book for customers)");
            System.out.println("3. Admin \t (View Reports)");
            System.out.println("4. Exit: ");

            System.out.print("\nEnter Choice: ");
            int choice = sc.nextInt();
            User currentUser = null;

            switch (choice) {
                case 1:
                    currentUser = new Customer("Careza", "C101");
                    break;
                case 2:
                    currentUser = new Cashier("Cyrus", "E101");
                    break;
                case 3:
                    currentUser = new Admin("Dirk", "A001");
                    break;
                case 4:
                    System.out.println("Shutting Down...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

            if (currentUser != null) {

                boolean inSubMenu = true;
                Cinema cinema1 = new Cinema("SM Cinema Cebu", "Room 1", 40);
                Movie avengers = new Movie("Avengers", "Action", 150, 250.0);
                Movie spiderman = new Movie("Spider-Man", "Action", 130, 220.0);
                Showtime avengers7pm = new Showtime(avengers, cinema1, "7:00 PM", 40);
                Showtime spiderman9pm = new Showtime(spiderman, cinema1, "9:30 PM", 40);

                while (inSubMenu) {

                    currentUser.displayMenu();
                    System.out.print("\nEnter Action: ");
                    int action = sc.nextInt();
                        
                    if (action == 4) {
                        inSubMenu = false;
                    } else {
                        if (currentUser instanceof Customer) {
                            if (action == 1) {
                                
                                cinema1.addShowtime(avengers7pm);
                                cinema1.addShowtime(spiderman9pm);
                                cinema1.displayMovies();

                            }

                            else if(action == 2){

                                    
                                cinema1.addShowtime(avengers7pm);
                                cinema1.addShowtime(spiderman9pm);
                                    

                                Showtime[] shows = cinema1.getShowtimes();

                                System.out.print("Select Movie (1 for Avengers, 2 for Spider-Man): ");
                                int movieChoice = sc.nextInt() - 1;

                                    if (movieChoice >= 0 && movieChoice < shows.length) {
                                        Showtime selectedShow = shows[movieChoice];

                                        System.out.print("Would you like to be given a seat now? (1 for Yes/ 0 for No): ");
                                        int response = sc.nextInt();

                                        if (response == 1){
                                            
                                            if (selectedShow.bookSeat()) {
                                                Seat assignedSeat = selectedShow.getBookedSeats()[selectedShow.getBookedCount() - 1];
                                                
                                                System.out.println("\n\t--Seat: #" + assignedSeat.getSeatNumber() + " assigned.");
                                                int nextSeat = Integer.parseInt(assignedSeat.getSeatNumber()) + 1;
                                                System.out.println("\t--Next available slot: Seat #" + nextSeat );    

                                                Booking newBooking = new Booking("BK-" + System.currentTimeMillis(), currentUser.getName());
                                                Ticket t = new Ticket("T-01", selectedShow.getMovie().getTitle(), selectedShow, assignedSeat);
                                                
                                                newBooking.addTicket(t);
                                                newBooking.processCheckout(false); 
                                                newBooking.confirmBooking();

                                                dailyReport.recordTransaction(newBooking.getPayment());
                                            } else {
                                                System.out.println("theater is full.");
                                            }
                                        } else {
                                            System.out.println("cancelled.");
                                        }
                                    } else {
                                        System.out.println("invalid movie.");
                                }  
                            }

                            else if(action == 3){
                                    
                                    Showtime[] shows = cinema1.getShowtimes();

                                    System.out.print("Select Movie (1 for Avengers, 2 for Spider-Man): ");
                                    int movieChoice = sc.nextInt() - 1;

                                    if (movieChoice >= 0 && movieChoice < shows.length) {
                                        Showtime selectedShow = shows[movieChoice];
                                        selectedShow.displaySeats();
                                    } else {
                                        System.out.println("invalid movie.");
                                    }
                                }
                                
                        }
                        if (currentUser instanceof Cashier) {
                            ((Cashier) currentUser).handleMenu(action, dailyReport, currentShowtime, sc);
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
