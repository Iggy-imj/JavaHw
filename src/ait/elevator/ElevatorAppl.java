package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK = 10_000;
    private static final int N_RECES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator("V. I. Lenon");
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RECES, CAPACITY, elevator);
        }
        Thread[] threads = new Thread[trucks.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();

        }

        System.out.println("Elevator " + elevator.getName() + " has " + elevator.getCurrentVolume());
    }
}
