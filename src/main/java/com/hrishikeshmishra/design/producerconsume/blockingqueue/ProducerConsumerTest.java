package com.hrishikeshmishra.design.producerconsume.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author hrishikesh.mishra
 */
public class ProducerConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);
        Thread producer1 = new Thread(new Producer(blockingQueue), "Producer-1");

        Thread consumer1 = new Thread(new Consumer(blockingQueue), "Consumer-1");

        producer1.start();

        consumer1.start();

        producer1.join();
        consumer1.join();

    }
}
