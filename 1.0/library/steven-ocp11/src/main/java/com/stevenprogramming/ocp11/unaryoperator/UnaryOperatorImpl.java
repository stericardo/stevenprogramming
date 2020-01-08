package com.stevenprogramming.ocp11.unaryoperator;

import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class UnaryOperatorImpl {
  
  public static void main(String[] args) {
    
    //
    DoubleUnaryOperator doubleUnaryOperator =  i -> i + 2.5 ;

    
    
    //UnaryOperator<T> extends Function<T, T>
    UnaryOperator<Integer> xor = a -> a ^ 1; 
        
    
    //double applyAsDouble(double operand);
    System.out.println(doubleUnaryOperator.applyAsDouble(2)); 
    
    //R apply(T t) because inherits of Function
    System.out.println(xor.apply(2)); 
    
            
  }

}
