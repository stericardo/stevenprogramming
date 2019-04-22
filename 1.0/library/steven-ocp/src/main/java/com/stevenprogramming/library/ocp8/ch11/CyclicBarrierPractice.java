package com.stevenprogramming.library.ocp8.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author steven mendez
 */
public class CyclicBarrierPractice {
    List<String> result = new ArrayList<>();
    static String[] dogs1 =  {"boi", "clover", "charis"};
    static String[] dogs2 =  {"aiko", "zooey", "biscuit"};
    final CyclicBarrier cyclicBarrier;
    
    public CyclicBarrierPractice(){
        cyclicBarrier = new CyclicBarrier(3,
        () -> {
            for(int i =0; i < dogs1.length; i++){
                result.add(dogs1[i]);
            }
            for(int i =0; i < dogs2.length; i++){
                result.add(dogs2[i]);
            }
            System.out.println("Init ... " + Thread.currentThread().getName() + " Result " + result);
        });
        Thread thread1 = new Thread(new ProcessDogs(dogs1));
        Thread thread2 = new Thread(new ProcessDogs(dogs2));
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Main thread is done !!!");
    }
    
    public static void main(String... args){
        CyclicBarrierPractice cyclicBarrierPractice = new CyclicBarrierPractice();
        cyclicBarrierPractice.result.forEach(v -> System.out.println(v));
    }
    
    class ProcessDogs implements Runnable{
        String[] dogs;
        
        ProcessDogs(String[] d){
            this.dogs = d;
        }
        
        public void run(){
            for(int i =0; i < dogs.length; i++){
                String dogName = dogs[i];
                String newDogName = dogName.substring(0,1).toUpperCase() + dogName.substring(1);
                dogs[i] = newDogName;
                
            }
            
            try{
                cyclicBarrier.await();
            } catch(InterruptedException | BrokenBarrierException e){
                e.printStackTrace();
            }
             System.out.println(Thread.currentThread().getName() + " id done!!!");
        }
    
    }
            
    
}
