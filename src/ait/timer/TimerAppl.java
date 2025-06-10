package ait.timer;

import ait.timer.task.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerAppl {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
//        thread.setDaemon(true);
        thread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\nEnter time interval, or press q for exit\n");
            String str = br.readLine();
            if ("q".equalsIgnoreCase(str)) {
//                thread.stop();
                thread.interrupt();
                break;
            } else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println("\nMain thread finished\n");
    }
}
