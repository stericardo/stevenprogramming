package com.stevenprogramming.ocp11.supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class SupplierImpl {
  
  
  
  public static void main(String[] args) {
    DoubleSupplier dsup = () -> Math.random();
    IntSupplier isup = () -> 10;
    LongSupplier lsup = () -> 10;
    BooleanSupplier bsup = () -> true;
    
    //double getAsDouble()
    System.out.println(dsup.getAsDouble());
    //int getAsInt()
    System.out.println(isup.getAsInt());
    //long getAsLong()
    System.out.println(lsup.getAsLong());
    //boolean getAsBoolean()
    System.out.println(bsup.getAsBoolean());    
    
    
  }

}
