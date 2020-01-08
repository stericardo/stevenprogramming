package com.stevenprogramming.ocp11.consumer;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class ConsumerImpl {

  
  public static void main(String[] args) {
    DoubleConsumer dcons = i -> System.out.println( i * 2.5 ); 
    IntConsumer icons = i -> System.out.println( i + 150 );
    
    //void accept(double value)
    dcons.accept(3);
    
    //void accept(int value)
    icons.accept(23);
    
  }
}
