package com.hrishikeshmishra.design.producerconsume.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hrishikesh.mishra
 */
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int data = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " - consume : < " + data);
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
            } catch (InterruptedException e) {
                System.out.println("Error : " + e);
            }
        }
    }
}

