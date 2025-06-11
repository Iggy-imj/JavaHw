package ait.bank.service;

import ait.bank.model.Account;

import java.util.concurrent.locks.Lock;

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
        Account first = accFrom.getAccNumber() < accTo.getAccNumber() ? accFrom : accTo;
        Account second = accFrom.getAccNumber() < accTo.getAccNumber() ? accTo : accFrom;

        Lock firstLock = first.getLock();
        Lock secondLock = second.getLock();

        firstLock.lock();
        try {
            secondLock.lock();
            try {
                if (accFrom.getBalance() >= sum) {
                    accFrom.credit(sum);
                    accTo.debit(sum);
                }
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }
}
