package com.stevenprogramming.library.ocp8.ch11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author smendez mendez brenes
 */
public class ArrayDequeDemo2 {
    
    public static void printValues(Deque<Integer> de_que, String method){
        System.out.println("\nCalled:::" + method);
        de_que.stream().forEach(v -> System.out.print(" " + v));
    }
    
    public static void main(String[] args) 
    { 
        Deque<Integer> deque = new ArrayDeque<>(5);
        //boolean add: Inserts the specified element at the end of this deque.
        //This method is equivalent to addLast.
        deque.add(10);
        deque.add(20);
        deque.add(30);
        printValues(deque, "after init");
        /*
        Called:::after init
        10 20 30
        */
        //E getFirst() Retrieves, but does not remove, the first element of this deque.
        Integer valueReturned = deque.getFirst();
        System.out.println("\nReturned First:::" + valueReturned);
        /*
            Returned First:::10
        */
        //E getLast() Retrieves, but does not remove, the last element of this deque.
        valueReturned = deque.getLast();
        System.out.println("\nReturned Last:::" + valueReturned);
        /*
            Returned Last:::30
        */
        // void addLast: Inserts the specified element at the end of this deque.
        // This method is equivalent to add.
        deque.addLast(40);
        printValues(deque, "after add Last");
        
        // E element(): Retrieves, but does not remove, the head of the queue represented by this deque.
        // differs from peek only in that it throws an exception if this deque is empty.
        valueReturned = deque.element();
        System.out.println("\nElement:::" + valueReturned);
        /*
            Element:::10
        */
        
        // E peek(): Retrieves, but does not remove, the head of the queue represented by this deque,
        // or returns null if this deque is empty. This method is equivalent to peekFirst().
        valueReturned = deque.peek();
        System.out.println("\npeek:::" + valueReturned);
        /*
            Element:::10
        */
        
        // E peekFirst():Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
        valueReturned = deque.peekFirst();
        System.out.println("\npeekFirst:::" + valueReturned);
        /*
            Element:::10
        */
        
        // E peekLast():Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty..
        valueReturned = deque.peekLast();
        System.out.println("\npeekLast:::" + valueReturned);
        /*
           peekLast:::40
        */
        
        //boolean offer(E e): Inserts the specified element at the end of this deque.
        boolean offer = deque.offer(50);
        printValues(deque, "after offer");
        /*
            Called:::after offer
            10 20 30 40 50
        */
        
        //boolean offerFirst(E e): Inserts the specified element at the front of this deque.
        boolean offerFirst = deque.offerFirst(5);
        printValues(deque, "after offerFirst");
       /*
            Called:::after offerFirst
            5 10 20 30 40 50
        */
       
       //boolean offerLast(E e): Inserts the specified element at the end of this deque.
        boolean offerLast = deque.offerLast(60);
        printValues(deque, "after offerLast");
       /*
            Called:::after offerLast
            5 10 20 30 40 50 60
        */
       
       //E poll(): Retrieves and removes the head of the queue represented by this deque (in other words, 
       //the first element of this deque), or returns null if this deque is empty.
        Integer poll = deque.poll();
        printValues(deque, "after poll");
       /*
            Called:::after poll
            10 20 30 40 50 60
        */
       
        //E pollFirst(): Retrieves and removes the first element of this deque, or returns null if this deque is empty.
        Integer pollFirst = deque.pollFirst();
        printValues(deque, "after pollFirst");
       /*
            Called:::after pollFirst
            20 30 40 50 60
        */
       
       
        //E pollLast(): Retrieves and removes the last element of this deque, or returns null if this deque is empty.
        Integer pollLast = deque.pollLast();
        printValues(deque, "after pollLast");
       /*
            Called:::after pollLast
            20 30 40 50
        */
       
       //E  pop() Pops an element from the stack represented by this deque.
       Integer pop = deque.pop();
       printValues(deque, "after pop");
       /*
            Called:::after pop
            30 40 50
       */

       //void  push() Pushes an element onto the stack represented by this deque.
       deque.push(20);
       printValues(deque, "after push");
       /*
           Called:::after push
           20 30 40 50
       */

       
        
    }
}
