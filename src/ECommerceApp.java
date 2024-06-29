//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.util.Scanner;
public class ECommerceApp {
    public static void main(String[] args) throws IOException {
        InventoryManager inventoryManager = new InventoryManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-commerce Console Application!");
        displayMenu();
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter command (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    inventoryManager.addItem();
                    break;
                case 2:
                    inventoryManager.listItems();
                    break;
                case 3:
                    inventoryManager.categorize();
                    break;
                case 4:
                    inventoryManager.order(paymentProcessor);
                    break;
                case 5:
                    inventoryManager.saveInventory();
                    break;
                case 6:
                    inventoryManager.loadInventory();
                    break;
                case 7:
                    inventoryManager.findInventoryItemByID();
                    break;
                case 8:
                    inventoryManager.removeItemByID();
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();

    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Item");
        System.out.println("2. List Items");
        System.out.println("3. Categorize Items Remove Item by ID");
        System.out.println("4.  Place Order ");
        System.out.println("5.  Save Inventory ");
        System.out.println("6.  Load Inventory ");
        System.out.println("7. Find Inventory By Id");
        System.out.println("8. Remove Item by ID ");
        System.out.println("9. Exit");
    }
}