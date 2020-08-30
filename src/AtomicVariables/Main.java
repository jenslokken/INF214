package AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       /* class Counter {
            private int count = 0;

            public synchronized void increment() { ++count; }

            public synchronized int getCount() { return count; }
        }
        */

        final AtomicInteger counter = new AtomicInteger();


        class CountingThread extends Thread {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.incrementAndGet();
                }
            }
        }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
