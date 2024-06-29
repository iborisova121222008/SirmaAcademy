import java.util.List;
import java.util.UUID;

public class Order {
    private String orderID;
    private List<InventoryItem> items;
    private List<Integer> quantities;
    private double totalCost;
    private Payment paymentMethod;

    public Order(List<InventoryItem> items, List<Integer> quantities) {
        this.orderID = UUID.randomUUID().toString();
        this.items = items;
        this.quantities = quantities;
        this.totalCost = calculateTotal();
    }

    public String getOrderID() {
        return orderID;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public boolean processPayment(PaymentProcessor paymentProcessor) {
        if (paymentMethod != null && paymentProcessor.processPayment(paymentMethod, totalCost)) {
            updateInventoryQuantities();
            return true;
        }
        return false;
    }

    private void updateInventoryQuantities() {
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = items.get(i);
            int newQuantity = item.getQuantity() - quantities.get(i);
            item.setQuantity(newQuantity);
        }
    }
}
