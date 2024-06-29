public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;
    private double amount;

    public CreditCardPayment(String cardNumber, String cardHolder, String expirationDate, String cvv, double amount) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.amount = amount;
    }

    @Override
    public boolean validate() {

        //example
        return (cardNumber.length() >= 13 &&
                cardNumber.length() <= 16);

    }
        @Override
        public double getAmount () {
            return amount;
        }
    }
