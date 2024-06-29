public class GroceryItem extends InventoryItem{
    private String expirationDate;
    public GroceryItem(String category, double price, String itemID, int quantity, String expirationDate) {
        super(category, price, itemID, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    private boolean checkExpiration(String expirationDate) {
        // Simple expiration check logic (placeholder)
        return expirationDate.compareTo("2024-01-01") < 0; // Example expiration logic
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.printf("Expiration Date: %s%n", getExpirationDate());
    }
}
