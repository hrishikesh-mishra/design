package com.hrishikeshmishra.design.producerconsume.waitnotify;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hrishikesh.mishra
 */
public class Consumer implements Runnable {

    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("Consuming Queue Data Data : " + consume());
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer consume() throws InterruptedException {

        Integer value;

        synchronized (queue) {

            /** Used while to support multiple thread running currently and waiting for lock **/
            while (queue.isEmpty()) {
                log("Queue is empty %s is waiting.\n", Thread.currentThread().getName());

                queue.wait(); /**  Releases lock, and reacquires on wakeup **/
            }
            value = queue.remove();
            queue.notifyAll();
        }

        return value;
    }

    private void log(String format, String threadName) {
        System.out.printf(getClass().getSimpleName() + " ERROR : " + format, threadName);
    }

}
