package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private int nRaces;
    private int capacity;
    private Elevator elevator1;
    private Elevator elevator2;

    private final static Object monitor1 = new Object();
    private final static Object monitor2 = new Object();

    public Truck(int nRaces, int capacity, Elevator elevator1, Elevator elevator2) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator1 = elevator1;
        this.elevator2 = elevator2;
    }

    @Override
    public void run() {
        int portion = capacity / 2;
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor1) {
                elevator1.add(portion);
            }
            synchronized (monitor2) {
                elevator2.add(portion);
            }
        }
    }
}
