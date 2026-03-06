public class SalesReport {

    Payment payment;

    private double totalRevenue;
    private int ticketsSold;
    private String reportDate;

    public SalesReport(String reportDate) {
        this.reportDate = reportDate;
        this.totalRevenue = 0.0;
        this.ticketsSold = 0;
    }

    public void recordTransaction(Payment payment) {
        this.totalRevenue += payment.getTotalAmount();
        this.ticketsSold++;
    }

    public void addSale(double price) {
        this.totalRevenue += price;
        this.ticketsSold++;
    }

    public double overallRevenue() {
        return totalRevenue += payment.getTotalAmount();
    }

    public int totalTickets() {
        return ticketsSold;
    }

    public void displayDailyReport() {
        System.out.println("\n=====================================");
        System.out.println("DAILY REPORT (" + reportDate + ")");
        System.out.println("=====================================");
        System.out.println("Total Tickets Sold: " + ticketsSold);
        System.out.println("Total Revenue: PHP" + totalRevenue);
        System.out.println("Status: Balanced");
        System.out.println("=====================================");
    }
}