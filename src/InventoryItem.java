import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryItem extends AbstractItem{

    private String itemID;
    private int quantity;

    public InventoryItem(String category, double price, String itemID, int quantity) {
        super(category, price);
        this.itemID = itemID;
        this.quantity = quantity;

    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }







}
