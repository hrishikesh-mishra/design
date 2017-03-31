package com.hrishikeshmishra.design.producerconsume.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hrishikesh.mishra
 */
public class ProducerConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> sharedQueue = new LinkedList<>();
        int queueCapacity = 3;
        Thread producerThread = new Thread(new Producer(sharedQueue, queueCapacity), "Producer-Thread");
        Thread consumerThread = new Thread(new Consumer(sharedQueue), "Consumer-Thread");

        producerThread.start();
        consumerThread.start();


        producerThread.join();
        consumerThread.join();
    }
}
