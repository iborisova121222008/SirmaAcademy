import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private List<InventoryItem> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void listItems() {
        if (inventory.isEmpty()) {
            System.out.println("Not items available");
        } else {
            for (InventoryItem item : inventory) {
                item.displayDescription();
            }
        }
    }


    public void addItem() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        inventory.add(new InventoryItem(category, price, itemID, quantity));
        System.out.println("Item added.");
    }

    public void categorize() {
        System.out.println("Enter category to categorize:");
        String category = scanner.nextLine();
        boolean isFound = false;

        for (InventoryItem item : inventory) {
            if (item.getCategory().equals(category)) {
                item.displayDescription();
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("No items in this category");
        }

    }

    public void order(PaymentProcessor paymentProcessor) {
        List<InventoryItem> orderItems = new ArrayList<>();
        List<Integer> orderQuantities = new ArrayList<>();

        while (true) {
            System.out.print("Enter item ID to order: ");
            String itemID = scanner.nextLine();
            if (itemID.isEmpty()) {
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            InventoryItem inventoryItem = findInventoryItemByID();
            if (inventoryItem != null && inventoryItem.getQuantity() >= quantity) {
                orderItems.add(inventoryItem);
                orderQuantities.add(quantity);

            } else {
                System.out.println("Item not found or insufficient quantity.");
            }
        }

        if (!orderItems.isEmpty()) {
            Order order = new Order(orderItems, orderQuantities);
            double total = order.getTotalCost();
            System.out.printf("Order Total: %.2f%n", total);
            System.out.print("Enter payment amount: ");
            double paymentAmount = scanner.nextDouble();
            scanner.nextLine();

            Payment payment = new CreditCardPayment("1234567890123456", "John Doe", "12/24", "123", paymentAmount);
            order.setPaymentMethod(payment);

            if (order.processPayment(paymentProcessor)) {
                System.out.println("Order placed and inventory updated.");
            } else {
                System.out.println("Payment failed. Order not placed.");
            }
        }

    }

    public void saveInventory() throws IOException {
        System.out.print("Enter filename to save inventory: ");
        String filePath = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (InventoryItem item : inventory) {
                writer.write(item.getCategory() + "," + item.getPrice() + "," + item.getItemID() + "," + item.getQuantity());
                writer.newLine();
            }
            System.out.println("Inventory saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void loadInventory() throws IOException {
        System.out.println("Enter filepath:");
        String filePath = scanner.nextLine();
        List<InventoryItem> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String category = parts[0];
                double price = Double.parseDouble(parts[1]);
                String itemID = parts[2];
                int quantity = Integer.parseInt(parts[3]);
                inventory.add(new InventoryItem(category, price, itemID, quantity));
            }
        }
    }



    public InventoryItem findInventoryItemByID() {
        System.out.print("Enter item ID to find by: ");
        String itemID = scanner.nextLine();
        return inventory.stream()
                .filter(item -> item.getItemID().equals(itemID))
                .findFirst()
                .orElse(null);


    }


    public void removeItemByID() {
        System.out.print("Enter item ID to remove: ");
        String itemID = scanner.nextLine();
        inventory.removeIf(item -> item.getItemID().equals(itemID));
        System.out.println("Item removed if it existed.");
    }
}

