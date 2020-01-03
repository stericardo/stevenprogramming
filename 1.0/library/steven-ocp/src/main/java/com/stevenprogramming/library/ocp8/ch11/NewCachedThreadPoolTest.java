package com.stevenprogramming.library.ocp8.ch11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author steven mendez brenes
 */
public class NewCachedThreadPoolTest {
    public static void main(String... args) throws InterruptedException, ExecutionException{
        //creates cached thread pool
        ExecutorService exService = Executors.newCachedThreadPool();
        // runnable thread start to execute.
         exService.execute(new NewCachedThreadPoolTest().new RunnableThread());
         System.out.println("Waiting");
        //callable thread starts to execute
        Future<Integer> future=exService.submit(new NewCachedThreadPoolTest().new CallableThread());
        exService.submit(new NewCachedThreadPoolTest().new CallableThread());
         System.out.println("Waiting2");
        //gets value of callable thread
        int val=future.get();
        System.out.println("Waiting3");
       // System.out.println(val);
        //checks for thread termination
        boolean isTerminated=exService.isTerminated();
        System.out.println(isTerminated);
        // waits for termination for 30 seconds only
        exService.awaitTermination(10,TimeUnit.MILLISECONDS);
        exService.shutdownNow();
        System.out.println("Waiting4");
    }
    //Callable thread
    class CallableThread implements Callable<Integer> {
        @Override
        public Integer call() {
             
                    try{
                    Thread.sleep(10000);
                    }catch(InterruptedException e){
                    }
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("call:" + cnt);
            }
            return cnt;
        }
    }
    //Runnable thread
    class RunnableThread implements Runnable {
        @Override
        public void run() {
            
                    try{
                    Thread.sleep(3000);
                    }catch(InterruptedException e){
                    }
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("run:" + cnt);
            }
        }
    }
 }
