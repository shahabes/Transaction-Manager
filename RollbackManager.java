package es.shahab.transaction;

public class RollbackManager {
    public static void main(String[] args) {

        double instructions[] = {20, 20.5, 13.5572, 11, 2993, -123, 8537, 884, 9281, 9987, 93847, -2, 9938, 9, 99, 918, 7374, 92492, 1, -20,
                22, 0, 11, 2382};

        var account = new Account();

        try {
            account.deposit(30);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("before transaction start: balance is " + account.getBalance());

        History.push(account.start());

        try {
            for (double instruction : instructions) {
                if (instruction >= 0)
                    account.deposit(instruction);
                else
                    account.withdraw(-instruction);

                System.out.println("during transaction (item is: " + instruction + "): balance is " + account.getBalance());
            }

            History.push(account.end());
            System.out.println("after transaction: balance is " + account.getBalance());

        } catch (Exception e) {
            account.rollBack(History.pop());
            System.out.println("transaction rollback: balance is " + account.getBalance());
        }
    }
}
