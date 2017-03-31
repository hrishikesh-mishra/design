package com.hrishikeshmishra.design.producerconsume.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hrishikesh.mishra
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;
    private int counter;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.counter = 1;
    }


    @Override
    public void run() {
        while (true) {

            try {
                blockingQueue.put(counter);
                System.out.println(Thread.currentThread().getName()+ " - produce : > " + counter);
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
            } catch (InterruptedException e) {
                System.out.println();
            }

            counter++;
        }
    }
}
