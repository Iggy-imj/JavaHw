package ait.bank.service;

import ait.bank.model.Account;

public class Transfer implements Runnable {

    private Account accFrom;
    private Account accTo;
    private int sum;

    public Transfer(Account accFrom, Account accTo, int sum) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.sum = sum;
    }

    @Override
    public void run() {
        Account firstLock;
        Account secondLock;

        if (accFrom.getAccNumber() < accTo.getAccNumber()) {
            firstLock = accFrom;
            secondLock = accTo;
        } else {
            firstLock = accTo;
            secondLock = accFrom;
        }


        synchronized (firstLock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (secondLock) {
                if (accFrom.getBalance() >= sum) {
                    accFrom.credit(sum);
                    accTo.debit(sum);
                }
            }
        }
    }
}
