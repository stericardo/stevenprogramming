package com.stevenprogramming.ocp11.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 13 2020
 * @version 1.0
 */
public class ReduceImpl {

  public static void accumulatorCombinator() {
    List<Person> persons
            = Arrays.asList(
                    new Person("Max", 18),
                    new Person("Peter", 23),
                    new Person("Pamela", 23),
                    new Person("David", 12));

    Integer ageSum = persons
            .stream()
            .reduce(0,
                    (sum, p) -> {
                      System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                      return sum += p.age;
                    },
                    (sum1, sum2) -> {
                      System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                      return sum1 + sum2 ;
                    });

    System.out.println(ageSum);
    
    ageSum = persons
            .parallelStream()
            .reduce(0,
                    (sum, p) -> {
                      System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                      return sum += p.age +10 ;
                    },
                    (sum1, sum2) -> {
                      System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                      return sum1 + sum2 ;
                    });

    System.out.println(ageSum);
    

    
    
  }

  public static void main(String[] args) {
    // creating a list of Strings 
    List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
    Optional<String> longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

    // Displaying the longest String 
    longestString.ifPresent(System.out::println);

    String longestStringIdentity = words.stream().reduce("AGeeksforGeeksA", (word1, word2) -> word1.length() > word2.length() ? word1 : word2);
    System.out.println(longestStringIdentity);

    List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
    int sum = array.stream().reduce(0, (element1, element2) -> element1 + element2);
    // Displaying sum of all elements 
    System.out.println("The sum of all elements is " + sum);
    int result = array.stream().reduce(0, Integer::sum);
    System.out.println("The sum of all elements is " + result);

    result = array.stream().reduce(0, Integer::sum);

    accumulatorCombinator();

  }

  static class Person {

    String name;
    int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return name;
    }
  }

}
