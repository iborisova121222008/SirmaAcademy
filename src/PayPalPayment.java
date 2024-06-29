public class PayPalPayment implements Payment {
    private String email;
    private String password;
    private double amount;

    public PayPalPayment(String email, String password, double amount) {
        this.email = email;
        this.password = password;
        this.amount = amount;
    }

    public boolean validate() {
        return isValidEmail(email) && amount > 0;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }
}

