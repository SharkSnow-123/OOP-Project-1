import java.util.ArrayList;

public class SalesReport {
    private double totalRevenue;
    private int totalTicketsSold;
    private String date;

    public SalesReport(String date) {
        this.date = date;
        this.totalRevenue = 0.0;
        this.totalTicketsSold = 0;
    }

    public void addSale(double amount) {
        this.totalRevenue += amount;
        this.totalTicketsSold++;
    }

    public void displaySummary() {
        System.out.println("=====================================");
        System.out.println("TODAY'S SALES - DATE: " + date);
        System.out.println("=====================================");
        System.out.println("Total Tickets: " + totalTicketsSold);
        System.out.println("Total Revenue: ₱" + totalRevenue);
        System.out.println("-------------------------------------");
        
    }
}