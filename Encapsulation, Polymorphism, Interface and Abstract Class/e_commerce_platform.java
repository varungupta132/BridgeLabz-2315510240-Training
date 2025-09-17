package aadi;

import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {

    interface Taxable {
        double calculateTax();
        String getTaxDetails();
    }

    abstract static class Product {
        private int productId;
        private String name;
        private double price;

        public Product(int productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public abstract double calculateDiscount();
    }

    static class Electronics extends Product implements Taxable {
        public Electronics(int productId, String name, double price) {
            super(productId, name, price);
        }
        @Override
        public double calculateDiscount() {
            return getPrice() * 0.1;
        }
        @Override
        public double calculateTax() {
            return getPrice() * 0.18;
        }
        @Override
        public String getTaxDetails() {
            return "Electronics Tax: 18%";
        }
    }

    static class Clothing extends Product implements Taxable {
        public Clothing(int productId, String name, double price) {
            super(productId, name, price);
        }
        @Override
        public double calculateDiscount() {
            return getPrice() * 0.15;
        }
        @Override
        public double calculateTax() {
            return getPrice() * 0.05;
        }
        @Override
        public String getTaxDetails() {
            return "Clothing Tax: 5%";
        }
    }

    static class Groceries extends Product {
        public Groceries(int productId, String name, double price) {
            super(productId, name, price);
        }
        @Override
        public double calculateDiscount() {
            return getPrice() * 0.05;
        }
    }

    public static void printFinalPrices(List<Product> products) {
        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) tax = ((Taxable) p).calculateTax();
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Product: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            if (p instanceof Taxable) {
                System.out.println(((Taxable) p).getTaxDetails());
            }
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "Shirt", 1500));
        products.add(new Groceries(3, "Apples", 200));
        printFinalPrices(products);
    }
}
