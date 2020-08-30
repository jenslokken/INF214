package DiningPhilosophers;

import DiningPhilosophers.DiningPhilosophers;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DiningPhilosophers[] diningPhilosophers = new DiningPhilosophers[5];
        Chopstick[] chopsticks = new Chopstick[5];

        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick(i);
        }
        for (int i = 0; i < 5; i++) {
            diningPhilosophers[i] = new DiningPhilosophers(chopsticks[i], chopsticks[(i + 1) % 5]);
            diningPhilosophers[i].start();
        }
        for (int i = 0; i < 5; i++) {
            diningPhilosophers[i].join();
        }
    }
}
