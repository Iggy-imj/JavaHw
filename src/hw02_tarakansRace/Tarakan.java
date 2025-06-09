package hw02_tarakansRace;

public class Tarakan extends Thread {
    private int id;
    private int distance;
    private static boolean winnerFound = false;
    public static int winnerId = 0;

    public Tarakan(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public void run() {
        for (int i = 0; i <= distance; i++) {
            System.out.println("tarakansRace.Tarakan #" + id + " - step " + i);

            try {
                int sleepTime = 2 + (int) (Math.random() * 4);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("tarakansRace.Tarakan #" + id + " was interrupted.");
                return;
            }
        }
        if (!winnerFound) {
            winnerFound = true;
            winnerId = id;
        }
    }

}
