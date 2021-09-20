//package com.example.sharesdemotask.utls;
//
//import com.example.sharesdemotask.SharesDemoTaskApplication;
//import com.example.sharesdemotask.models.Quote;
//
//import java.util.concurrent.BlockingQueue;
//
//public class QuoteQueueProcessingThread implements Runnable {
//
//    private BlockingQueue<Quote> appQueue;
//
//    public QuoteQueueProcessingThread(BlockingQueue<Quote> appQueue) {
//        this.appQueue = appQueue;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("STARTING QueueProcessingThread number " + Thread.currentThread().getName() + "!!!");
//
//        while (!SharesDemoTaskApplication.exit) {
//            Quote quote = appQueue.poll();
//            if (quote != null) {
//                System.out.println("Thread QueueProcessingThread" + Thread.currentThread().getName() + " processing quote: " + quote);
//
//
//
//
//            }
//
//
//        }
//
//
//    }
//}
