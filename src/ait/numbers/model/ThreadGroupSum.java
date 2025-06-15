package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

public class ThreadGroupSum extends GroupSum {
    public ThreadGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        Thread[] threads = new Thread[numberGroups.length];
        OneGroupSum[] tasks = new OneGroupSum[numberGroups.length];

        for (int i = 0; i < numberGroups.length; i++) {
            tasks[i] = new OneGroupSum(numberGroups[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (int i = 0; i < numberGroups.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int total = 0;
        for (OneGroupSum task : tasks) {
            total += task.getSum();
        }

        return total;
    }
}
