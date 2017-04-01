package com.hrishikeshmishra.design.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hrishikesh.mishra
 */
public class Application {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Service serviceA = new Service(countDownLatch, "A");
        Service serviceB = new Service(countDownLatch, "B");
        Service serviceC = new Service(countDownLatch, "C");

        ExecutorService service = Executors.newFixedThreadPool(3);

        System.out.println("Starting Services.\n\n");

        service.submit(serviceA);
        service.submit(serviceB);
        service.submit(serviceC);

        System.out.println("\n\nWaiting All Services To Start.\n\n");

        countDownLatch.await();

        System.out.println("\n\nAll Services To Started.\n\n");



    }
}
