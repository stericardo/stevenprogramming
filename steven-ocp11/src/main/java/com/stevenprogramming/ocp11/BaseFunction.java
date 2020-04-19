package com.stevenprogramming.ocp11;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class BaseFunction {
  
  //Function<T, R>
  //R apply(T t)
  //example functionInteger.apply(10)
  public Function<Integer,Integer> functionInteger = i -> i + 10;
  
  //Supplier<T>
  //T get()
  //example supplierInteger.get()
  public Supplier<Integer> supplierInteger =  () -> 10;
  
  //Predicate<T>
  //boolean test(T t)
  //example predicateInteger.test(10)
  public Predicate<Integer> predicateInteger = i -> (i < 18);
  
  //Consumer<T>
  //void accept(T t);
  //example consumerInteger.accept(10); 
  public Consumer<Integer> consumerInteger = s -> 
          System.out.println("The " + s + " is consumed.");;
  
  
  
}
