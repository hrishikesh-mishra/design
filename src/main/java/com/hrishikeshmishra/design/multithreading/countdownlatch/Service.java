package com.hrishikeshmishra.design.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hrishikesh.mishra
 */
public class Service implements Runnable {

    private final CountDownLatch countDownLatch;
    private final String name;

    public Service(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            startService();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startService() throws InterruptedException {
        System.out.println("Starting Service : \"" + name + "\"");
        Thread.sleep(ThreadLocalRandom.current().nextInt(100, 10000));
        System.out.println("Started Service : \"" + name + "\"");

    }
}
