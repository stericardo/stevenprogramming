package com.stevenprogramming.ocp11.predicate;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class PredicateImpl {

  public static void main(String[] args) {
    IntPredicate ipred = i -> i < 25;

    //boolean test(int value);
    ipred.test(20);

    Predicate<Integer> lesserthan = i -> (i < 18);

    // Calling Predicate method 
    System.out.println(lesserthan.test(10));

  }

}
