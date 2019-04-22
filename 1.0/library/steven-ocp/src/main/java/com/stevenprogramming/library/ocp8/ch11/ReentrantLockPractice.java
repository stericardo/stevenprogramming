package com.stevenprogramming.library.ocp8.ch11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.catalina.Manager;

public class ReentrantLockPractice {


    private int sheepCount = 0;
    private Lock lock = new ReentrantLock();

    private void incrementAndReport(int v){
        try{
            lock.lock();lock.lock();
            System.out.println(" " + (++sheepCount) + " v=" + v);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(30);
            ReentrantLockPractice reentrantLockPractice = new ReentrantLockPractice();
            for(int cont = 0; cont < 60 ; cont++){
                System.out.println("Running " + (cont + 1));
                int y = cont;
                service.submit(() -> reentrantLockPractice.incrementAndReport(y));
            }
        }finally {
            if(service != null){
                service.shutdown();
            }
        }

    }

}
