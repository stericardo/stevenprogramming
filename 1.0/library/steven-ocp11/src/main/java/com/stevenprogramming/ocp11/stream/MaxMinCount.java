package com.stevenprogramming.ocp11.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 12 2020
 * @version 1.0
 */
public class MaxMinCount {
  
  public static void main(String[] args) {

    // Get Min or Max Number
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9); 
    Integer maxNumber = integerStream
            .max(Comparator.comparing(Integer::valueOf))
            .get();
    
    integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9); 
    Optional<Integer> maxNumberOptional = integerStream.max(Comparator.comparing(Integer::valueOf));
    maxNumber = maxNumberOptional.get();
            

    integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Integer minNumber = integerStream
            .min(Comparator.comparing(Integer::valueOf))
            .get();

    integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    
    System.out.println("maxNumber = " + maxNumber);
    System.out.println("minNumber = " + minNumber);
    System.out.println("minNumber = " + integerStream.count());


  }

}
