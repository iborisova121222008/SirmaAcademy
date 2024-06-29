public class ElectronicsItem extends InventoryItem{
    private int warrantyPeriod; // warranty period in months

    public ElectronicsItem(String category, double price, String itemID, int quantity, int warrantyPeriod) {
        super(category, price, itemID, quantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateValue() {
        // For electronics, let's say value decreases by 10% for each year of warranty
        return getPrice() * (1 - 0.10 * (warrantyPeriod / 12));
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.printf("Warranty Period: %d months%n", getWarrantyPeriod());
    }
}
