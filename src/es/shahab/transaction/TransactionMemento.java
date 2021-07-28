package es.shahab.transaction;

public class TransactionMemento {
    private double balance;

    public TransactionMemento(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }
}
