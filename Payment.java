<<<<<<< Updated upstream
=======
public class Payment {
    private final double TICKET_PRICE = 250.00;
    private double totalAmount;
    private String paymentMethod;

    public Payment(int ticketCount, boolean isSeniorOrPWD) {
        this.totalAmount = ticketCount * TICKET_PRICE;
        if (isSeniorOrPWD) {
            applyDiscount();
        }
    }

    private void applyDiscount() {
        this.totalAmount *= 0.80;
    }

    public void processTransaction(int choice, double amountPaid) {
        String[] methods = { "Cash", "Credit Card", "GCash" };
        this.paymentMethod = methods[choice - 1];

        System.out.println("=====================================");
        System.out.println("PAYMENT PROCESSING");
        System.out.println("Method: " + paymentMethod);
        System.out.println("Total Due: ₱" + totalAmount);

        if (choice == 1) {
            System.out.println("Cash received: ₱" + amountPaid);
            System.out.println("Change: ₱" + (amountPaid - totalAmount));
        }
        System.out.println("Transaction Successful!");
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
>>>>>>> Stashed changes
