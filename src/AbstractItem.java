public abstract class AbstractItem implements Item, Breakable, Categorizable, Perishable, Sellable {
    private String category;
    private double price;

    public AbstractItem(String category, double price) {
        this.category = category;
        this.price = price;
    }

    @Override
    public boolean isBreakable() {
        return false;
    }

    @Override
    public void handleBreakage() {

    }

    @Override
    public void setCategory(String category) {
        this.category = category;

    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public void displayDescription() {
        getItemDetails(); // First, get the item details
        System.out.println("This is a sellable item.");

    }

    @Override
    public double calculateValue() {
        return 0;
    }

    @Override
    public void getItemDetails() {
        System.out.printf("Category: %s, Price: %.2f%n", getCategory(), getPrice());

    }

    @Override
    public boolean isPerishable() {
        return false;
    }

    @Override
    public void handleExpiration() {

    }

    @Override
    public void setPrice(Double price) {

    }

    @Override
    public double getPrice() {
        return this.price;

    }
}
