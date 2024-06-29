public class PaymentProcessor {
    public boolean processPayment(Payment payment, double amount) {
        if (payment.validate() && payment.getAmount() >= amount) {
            // Simulate payment authorization
            System.out.println("Payment authorized for amount: " + amount);
            return true;
        } else {
            System.out.println("Payment failed. Please check your payment details and try again.");
            return false;
        }
    }
}
