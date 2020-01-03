package com.stevenprogramming.library.ocp8.ch11;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author steven mendez
 */
public class ExecutorsPractice {
    
    /**
     * public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
                                      * 
                                      * 
                                      * 
                                      * 
      public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
                                      * 
                                      * 
      public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
       public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory)
       * 
       * 
       * 
       
     *will reuse previously constructed
     * threads if available. If no existing thread is available, a new
     * thread will be created and added to the pool. Threads that have
     * not been used for sixty seconds are terminated and removed from
     * the cache.
        
       public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory)
     
       public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>()); 
        
        * 
        * 
        * 
        public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory)
        
        public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1));
    }
        
        public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
        public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory)
       
    }
    }
     */
    
   public static void fixedRate(){
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
    threadPool.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    try{
                    Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    Map map = new HashMap();
                    map.put("run_id", "aeca30e");
                    map.put("port", 1002);
                    map.put("processId", 3001);
                    System.out.println("scheduleAtFixedRate:    " + new Date());
                }
            }, 5, 10, TimeUnit.SECONDS);
   } 
   
   public static void fixedDelay(){
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
    threadPool.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try{
                    Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    Map map = new HashMap();
                    map.put("run_id", "aeca30e");
                    map.put("port", 1002);
                    map.put("processId", 3001);
                    System.out.println("scheduleWithFixedDelay: " + new Date());

                }
            }, 5, 10, TimeUnit.SECONDS);
   } 
   
    public static void single(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello Arlyn " + threadName);
        });
    }
    
    public static void singleSchedule(){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
             System.out.println("single: " + new Date());
        }
    }, 1, 10, TimeUnit.MILLISECONDS);
                
    }
    
    public static void main(String[] args){
       single();
       String threadName = Thread.currentThread().getName();
       System.out.println("Hello Arlyn " + threadName);
       /*
        scheduleAtFixedRate:    Sun Apr 21 08:42:28 CST 2019
        scheduleWithFixedDelay: Sun Apr 21 08:42:28 CST 2019
       
        scheduleAtFixedRate:    Sun Apr 21 08:42:38 CST 2019
        scheduleWithFixedDelay: Sun Apr 21 08:42:39 CST 2019
       
        scheduleAtFixedRate:    Sun Apr 21 08:42:48 CST 2019
        scheduleWithFixedDelay: Sun Apr 21 08:42:50 CST 2019
        
        scheduleAtFixedRate:    Sun Apr 21 08:42:58 CST 2019
        scheduleWithFixedDelay: Sun Apr 21 08:43:01 CST 2019
       */
       fixedRate(); // does not have a delay with you put sleep for instance
       fixedDelay(); // has a delay with you put sleep for instance
       
       singleSchedule();
    }
    
}
