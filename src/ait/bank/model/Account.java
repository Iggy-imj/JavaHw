package ait.bank.model;

public class Account {
    private int accNumber;
    private int balance;

    public Account(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int sum) {
        balance = balance + sum;
    }

    public void credit(int sum) {
        balance = balance - sum;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Account account)) return false;

        return accNumber == account.accNumber;
    }

    @Override
    public int hashCode() {
        return accNumber;
    }
}
