package com.stevenprogramming.ocp11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 12 2020
 * @version 1.0
 */
public class Java11NewMethods {

  public static void main(String[] args) {

    ofNullableTest();
    iterateTest();
    iterate9Test();
    dropWhileTest();
    takeWhileTest();

  }
  
    public static void takeWhileTest() {
    
    Stream.iterate(1, n -> n < 20 , n -> n * 2)
            .takeWhile(n -> n < 12 )
           .forEach(x -> System.out.println("\nPrinting take while " + x));
    
    
    Stream.of(1,45,2,5)
            .takeWhile(n -> n < 12 )
           .forEach(x -> System.out.println("\nPrinting take while " + x));
    
    Stream.of(1,2,5, 45)
            .takeWhile(n -> n < 12 )
           .forEach(x -> System.out.println("\nPrinting take while 2 " + x));
    
  }
  
  public static void dropWhileTest() {
    
    Stream.iterate(1, n -> n < 20 , n -> n * 2)
            .dropWhile(n -> n < 12 )
           .forEach(x -> System.out.println("\nPrinting drop while " + x));
    
  }

  public static void iterate9Test() {
    Stream.iterate(1, n -> n < 20 , n -> n * 2)
           .forEach(x -> System.out.println(x));
    
    Stream<Integer> sumResult = Stream.iterate(new int[]{0, 1}, n -> n[0] < 13,  n -> new int[]{n[1], n[0] + n[1]})
            .limit(10)
            .map(n -> n[0]);
    UtilStream.printStreamSpecial(sumResult, "Printing Iterate9");
  }
  
  public static void iterateTest() {
    System.out.println("Dddd");
    int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(10)
            .map(n -> n[0]) // Stream<Integer>
            .mapToInt(n -> n)
            .sum();

    System.out.println("Fibonacci 10 sum : " + sum);
    
    // Result pos[0] of int[] = 0-1-1-2-3-5-8-13-21-34
    Stream<Integer> sumResult = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(10)
            .map(n -> n[0]);
    UtilStream.printStream(sumResult, "Printing Iterate");
    
    Stream<Integer> sumResult2 = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(10)
            .map(n -> n[0])
            .peek(i -> System.out.println(":R" + i + ":R"));
    
    UtilStream.printStreamSpecial(sumResult2, "Printing Iterate 2222 ");
    
    
  }

  public static void ofNullableTest() {

    // Create a stream with null 
    Stream<String> value = Stream.ofNullable(null);
    // Print values 
    System.out.println("Values of Stream:");
    value.forEach(System.out::println);

    List<String> list = new ArrayList<String>();
    list.add("Aman");
    list.add("Suraj");
    list.add("Zufaq");

    // create a stream with ArrayList 
    Stream<List<String>> valueArray = Stream.ofNullable(list);

    // print values 
    System.out.println("Values of Stream:");
    valueArray.forEach(System.out::println);

  }

}
