package es.shahab.transaction;

public class Account {
    private double balance;

    public void deposit(double value) throws Exception {
        if (value > 0)
            balance += value;
        else
            throw new Exception();
    }

    public void withdraw(double value) throws Exception {
        if (value > 0)
            balance -= value;
        else
            throw new Exception();
    }

    public double getBalance(){
        return balance;
    }

    public TransactionMemento start(){
        return new TransactionMemento(this.balance);
    }
    
    public TransactionMemento end(){
        return this.start();
    }

    public void rollBack(TransactionMemento transactionMemento){
        this.balance = transactionMemento.getBalance();
    }
}
