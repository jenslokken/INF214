package DiningPhilosophers;

import java.util.Random;
public class DiningPhilosophers extends Thread{

    private Chopstick first, second;
    private Random random;

    public DiningPhilosophers(Chopstick left, Chopstick right) {
        if (left.getId() < right.getId()) {
            first = left;
            second = right;
            random = new Random();
        }
        else {
            first = right;
            second = left;
        }
    }
    public void run() {
        try {
            while (true) {
                System.out.println("Philosopher " + this + "has thought ");
                Thread.sleep(random.nextInt(1000));
                synchronized(first) { // take first chopstick
                    synchronized(second) { // take second chopstick
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        }
        catch (InterruptedException e) {}
    }
}
