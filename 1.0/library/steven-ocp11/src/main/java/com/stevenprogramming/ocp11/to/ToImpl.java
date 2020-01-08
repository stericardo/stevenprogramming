package com.stevenprogramming.ocp11.to;

import java.util.function.IntToDoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class ToImpl {
  
  public static void main(String[] args) {
    
    //double applyAsDouble
    ToDoubleFunction<Integer> l = i -> i * 2.4;
    ToDoubleBiFunction<Integer, Double> toDoubleBiFunction = (x,y) -> x + y ;
    IntToDoubleFunction intToDoubleFunction = i -> i + 2.5;
    ObjDoubleConsumer<Integer> objDoubleConsumer = (x,y) -> System.out.print(x * y);
    
    
    // double applyAsDouble(T value)
    l.applyAsDouble(3);
    
    //double applyAsDouble(T t, U u);
    toDoubleBiFunction.applyAsDouble(3, 3.5);
    
    //double applyAsDouble(int value)
    intToDoubleFunction.applyAsDouble(23);
    
    //void accept(T t, double value)
    objDoubleConsumer.accept(4, 2.2);
    
    
  }

}
