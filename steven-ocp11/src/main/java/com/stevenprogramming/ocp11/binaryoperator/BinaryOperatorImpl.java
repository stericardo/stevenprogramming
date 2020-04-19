package com.stevenprogramming.ocp11.binaryoperator;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class BinaryOperatorImpl {
  
  public static void main(String[] args) {
    
    IntBinaryOperator k;
    
    DoubleBinaryOperator doubleBinaryOperator = (x, y) -> x + y;
   
    //BinaryOperator<T> extends BiFunction<T,T,T>
    BinaryOperator<Double> binaryOperator = (x,y) -> x * y;
    
    
    //double applyAsDouble(double left, double right)
    System.out.println(doubleBinaryOperator.applyAsDouble(2.4, 2.1)); 
    
    System.out.println(binaryOperator.apply(1.2, 2.9));
            
  }

}
