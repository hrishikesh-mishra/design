package com.hrishikeshmishra.design.multithreading.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier:
 * A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
 * A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread
 * in the party arrives, but before any threads are released
 * ;
 * Difference between CyclicBarrier and CountDownLatch :
 * Both are same thing but it has one major difference that we can't you CountDownLatch once count reaches to zero but
 * in CyclicBarrier we use it by calling reset() method.
 *
 * @author hrishikesh.mishra
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CyclicBarrier.html
 */
public class Application {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println("Starting 3 Tasks.\n\n");

        for (int i = 1; i <= 3; i++) {
            executorService.submit(new Task(cyclicBarrier, "TASK-" + i));
        }

    }
}
