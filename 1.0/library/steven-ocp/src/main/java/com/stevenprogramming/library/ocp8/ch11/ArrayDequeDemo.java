package com.stevenprogramming.library.ocp8.ch11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 *
 * @author steven mendez brenes
 */
public class ArrayDequeDemo {
    
    public static void main(String[] args) 
    { 
        // Intializing an deque 
        Deque<Integer> de_que = new ArrayDeque<Integer>(10); 
   
        // add() method to insert 
        de_que.add(10); 
        de_que.add(20); 
        de_que.add(30); 
        
        de_que.stream().forEach(v -> System.out.print(" " + v));
   
        System.out.println("\nUsing clear() "); 
  
        // clear() method 
        de_que.clear(); 
   
        // addFirst() method to insert at start 
        de_que.addFirst(11); 
        de_que.addFirst(12); 
   
        // addLast() method to insert at end 
        de_que.addLast(14); 
        de_que.addLast(13); 
   
        System.out.println("Above elements are removed now"); 
   
        // Iterator() : 
        System.out.println("Elements of deque using Iterator :"); 
        for(Iterator itr = de_que.iterator(); itr.hasNext();) 
        { 
            System.out.println(itr.next()); 
        } 
   
        // descendingIterator() : to reverse the deque order 
        System.out.println("Elements of deque in reverse order :"); 
        for(Iterator dItr = de_que.descendingIterator();  
                                               dItr.hasNext();) 
        { 
            System.out.println(dItr.next()); 
        } 
   
        // element() method : to get Head element 
        System.out.println("\nHead Element using element(): " + 
                                             de_que.element()); 
   
        // getFirst() method : to get Head element 
        System.out.println("Head Element using getFirst(): " +  
                                               de_que.getFirst()); 
   
        // getLast() method : to get last element 
        System.out.println("Last Element using getLast(): " +  
                                                de_que.getLast()); 
   
        // toArray() method : 
        Object[] arr = de_que.toArray(); 
        System.out.println("\nArray Size : " + arr.length); 
   
        System.out.print("Array elements : "); 
        for(int i=0; i<arr.length ; i++) 
            System.out.print(" " + arr[i]); 
              
        // peek() method : to get head 
        System.out.println("\nHead element : " + de_que.peek()); 
          
        // poll() method : to get head 
        System.out.println("Head element poll : " + de_que.poll()); 
          
        // push() method : 
        de_que.push(20); 
        de_que.push(21); 
        de_que.push(22); 
          
        // remove() method : to get head 
        de_que.stream().forEach(v -> System.out.print(" " + v));
        System.out.println("\nHead element remove : " + de_que.remove()); 
        
        de_que.stream().forEach(v -> System.out.print(" " + v));
          
        System.out.println("\nThe final array is: "+de_que); 
    } 
} 

