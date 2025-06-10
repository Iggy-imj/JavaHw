package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK = 10_000;
    private static final int N_RECES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator1 = new Elevator("J. Lennon");
        Elevator elevator2 = new Elevator("S. Stallone");

        Truck[] trucks = new Truck[N_TRUCK];

        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RECES, CAPACITY, elevator1, elevator2);
        }

        Thread[] threads = new Thread[trucks.length];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();

        }

        System.out.println("Elevator \"" + elevator1.getName() + "\" has " + elevator1.getCurrentVolume());
        System.out.println("Elevator \"" + elevator2.getName() + "\" has " + elevator2.getCurrentVolume());
        int total = elevator1.getCurrentVolume() + elevator2.getCurrentVolume();
        System.out.println("Total: " + total);
    }
}
