package com.hrishikeshmishra.design.producerconsumebasic;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hrishikesh.mishra
 */
public class Producer implements Runnable {
    private final Queue<Integer> queue;
    private final int capacity;
    private final Random random;

    public Producer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                produce(i);
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(int data) throws InterruptedException {

        if (isQueueFull()) {  //@TODO Check here for loop
            synchronized (queue) {
                log("Queue is full %s is waiting , size\n", Thread.currentThread().getName(), queue.size());
                queue.wait();
            }
        }

        synchronized (queue) {
            queue.add(data);
            queue.notifyAll();
        }
    }

    private void log(String format, String threadName, int queueSize) {
        System.out.printf(getClass().getSimpleName() + " ERROR : " + format, threadName, queueSize);
    }

    private boolean isQueueFull() {
        return (queue.size() == capacity);
    }


}

