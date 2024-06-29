public class FragileItem extends InventoryItem{

    private double weight;
    public FragileItem(String category, double price, String itemID, int quantity) {
        super(category, price, itemID, quantity);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double calculateValue() {
        // For fragile items, let's say value increases by $5 per kilogram
        return getPrice() + (5 * weight);
    }

    @Override
    public boolean isBreakable() {
        return true; // Fragile items are always breakable
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.printf("Weight: %.2f kg%n", getWeight());
    }
}
