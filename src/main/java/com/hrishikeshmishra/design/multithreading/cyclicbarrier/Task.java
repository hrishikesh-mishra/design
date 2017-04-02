package com.hrishikeshmishra.design.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hrishikesh.mishra
 */
public class Task implements Runnable {

    private final CyclicBarrier cyclicBarrier;
    private final String name;

    public Task(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting Task : " + name);

            Thread.sleep(ThreadLocalRandom.current().nextInt(10, 10000));

            System.out.println(name + " is waiting on \"Barrier\".");

            cyclicBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(name + " came out from \"Barrier\".");

    }
}
