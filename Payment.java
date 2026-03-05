public class Payment {
    private double ticketPrice = 250.00;
    private double totalAmount;
    private String paymentMethod;
    private boolean isDiscounted;

    public Payment(int numberOfTickets, boolean seniorOrPWD) {
        this.totalAmount = numberOfTickets * ticketPrice;
        this.isDiscounted = seniorOrPWD;
        if (isDiscounted) {
            applyDiscount();
        }
    }

    private void applyDiscount() {
        
        this.totalAmount = this.totalAmount * 0.80;
    }

    public void processPayment(int methodChoice, double cashReceived) {
        String[] methods = {"Cash", "Credit Card", "GCash"};
        this.paymentMethod = methods[methodChoice - 1];
        
        System.out.println("Processing " + paymentMethod + " payment of ₱" + totalAmount);
        if (methodChoice == 1 && cashReceived >= totalAmount) {
            System.out.println("Change: ₱" + (cashReceived - totalAmount));
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}