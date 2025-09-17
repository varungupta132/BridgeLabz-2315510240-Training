package aadi;

import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount(double amount) {
        return amount * 0.9;
    }

    public String getDiscountDetails() {
        return "10% discount for veg items";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 20;
    }

    public double applyDiscount(double amount) {
        return amount * 0.85;
    }

    public String getDiscountDetails() {
        return "15% discount for non-veg items";
    }
}

public class online_food_delivery {
    public static void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            double total = item.calculateTotalPrice();
            if (item instanceof Discountable) {
                total = ((Discountable) item).applyDiscount(total);
            }
            System.out.println(item.getItemDetails() + ", Final Price: " + total);
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Tikka", 200, 2));
        order.add(new NonVegItem("Chicken Biryani", 250, 1));
        order.add(new VegItem("Veg Burger", 100, 3));
        processOrder(order);
    }
}
