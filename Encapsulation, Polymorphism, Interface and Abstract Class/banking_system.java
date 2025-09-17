package aadi;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    interface Loanable {
        void applyForLoan(double amount);
        String calculateLoanEligibility();
    }

    abstract static class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;

        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) balance -= amount;
        }

        public abstract double calculateInterest();
    }

    static class SavingsAccount extends BankAccount implements Loanable {
        private double loanAmount;

        public SavingsAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        public double calculateInterest() {
            return getBalance() * 0.04;
        }

        @Override
        public void applyForLoan(double amount) {
            loanAmount = amount;
        }

        @Override
        public String calculateLoanEligibility() {
            return getBalance() > 5000 ? "Eligible for loan up to " + loanAmount : "Not eligible for loan";
        }
    }

    static class CurrentAccount extends BankAccount implements Loanable {
        private double loanAmount;

        public CurrentAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        public double calculateInterest() {
            return getBalance() * 0.02;
        }

        @Override
        public void applyForLoan(double amount) {
            loanAmount = amount;
        }

        @Override
        public String calculateLoanEligibility() {
            return getBalance() > 10000 ? "Eligible for loan up to " + loanAmount : "Not eligible for loan";
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        SavingsAccount s1 = new SavingsAccount("SA123", "Aadi Sharma", 8000);
        s1.applyForLoan(20000);
        CurrentAccount c1 = new CurrentAccount("CA456", "Ravi Kumar", 15000);
        c1.applyForLoan(50000);
        accounts.add(s1);
        accounts.add(c1);

        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber());
            System.out.println("Holder: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());
            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.println(loan.calculateLoanEligibility());
            }
            System.out.println("----------------------");
        }
    }
}
