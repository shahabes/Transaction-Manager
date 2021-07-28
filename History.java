package es.shahab.transaction;

import java.util.ArrayList;
import java.util.List;

public class History {
    private static final List<TransactionMemento> transactionHistory = new ArrayList<>();

    public static void push(TransactionMemento transactionMemento){
        transactionHistory.add(transactionMemento);
    }

    public static TransactionMemento pop(){
        var lastIndex = transactionHistory.size() - 1;
        TransactionMemento item = transactionHistory.get(lastIndex);
        transactionHistory.remove(item);
        return item;
    }

}
