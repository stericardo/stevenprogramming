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
public class MixIntStreamDoubleLong {
  
  public static void main(String[] args) {
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);     
    IntStream intStream = integerStream.mapToInt(i -> i);
    intStream.forEach(System.out::print);
  }

}
