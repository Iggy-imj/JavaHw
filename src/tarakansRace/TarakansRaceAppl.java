package tarakansRace;

import java.util.Scanner;

public class TarakansRaceAppl {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of tarakans: ");
        int numbersOfTarakans = scanner.nextInt();

        System.out.println("Enter distance (iterations): ");
        int distance = scanner.nextInt();

        Tarakan[] tarakans = new Tarakan[numbersOfTarakans];

        for (int i = 0; i < numbersOfTarakans; i++) {
            tarakans[i] = new Tarakan(i + 1, distance);
        }

        System.out.println("\nRace started!\n");

        for (Tarakan tarakan : tarakans) {
            tarakan.start();
        }

        for (Tarakan tarakan : tarakans) {
            tarakan.join();
        }

        System.out.println("\nRace finished.");

    }
}
