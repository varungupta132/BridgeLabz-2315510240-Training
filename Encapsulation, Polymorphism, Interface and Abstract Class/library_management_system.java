package aadi;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    interface Reservable {
        void reserveItem(String borrowerName);
        boolean checkAvailability();
    }

    abstract static class LibraryItem {
        private String itemId;
        private String title;
        private String author;

        public LibraryItem(String itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public abstract int getLoanDuration();

        public void getItemDetails() {
            System.out.println("ID: " + itemId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Loan Duration: " + getLoanDuration() + " days");
        }
    }

    static class Book extends LibraryItem implements Reservable {
        private boolean available = true;
        private String borrower;

        public Book(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 14;
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (available) {
                borrower = borrowerName;
                available = false;
            }
        }

        @Override
        public boolean checkAvailability() {
            return available;
        }
    }

    static class Magazine extends LibraryItem implements Reservable {
        private boolean available = true;
        private String borrower;

        public Magazine(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 7;
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (available) {
                borrower = borrowerName;
                available = false;
            }
        }

        @Override
        public boolean checkAvailability() {
            return available;
        }
    }

    static class DVD extends LibraryItem implements Reservable {
        private boolean available = true;
        private String borrower;

        public DVD(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 3;
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (available) {
                borrower = borrowerName;
                available = false;
            }
        }

        @Override
        public boolean checkAvailability() {
            return available;
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        Book b = new Book("B101", "Effective Java", "Joshua Bloch");
        Magazine m = new Magazine("M202", "Tech Monthly", "Editorial Team");
        DVD d = new DVD("D303", "Inception", "Christopher Nolan");
        items.add(b);
        items.add(m);
        items.add(d);

        for (LibraryItem item : items) {
            item.getItemDetails();
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("John Doe");
                System.out.println("Available after reservation: " + r.checkAvailability());
            }
            System.out.println("--------------------");
        }
    }
}
