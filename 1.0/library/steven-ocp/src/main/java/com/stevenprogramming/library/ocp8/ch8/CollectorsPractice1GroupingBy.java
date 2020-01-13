package com.stevenprogramming.library.ocp8.ch8;

import static com.stevenprogramming.library.ocp8.ch8.StreamPractice.dogs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author steven mendez
 */
public class CollectorsPractice1GroupingBy {

   public static List<Dog> dogsA = Arrays.asList(new Dog("Steven", 10, 40),
            new Dog("Steven2", 9, 70),
            new Dog("Steven3", 8, 130),
            new Dog("Steven3", 8, 130),
            new Dog("Steven4", 7, 20),
            new Dog("Steven5", 17, 130),
            new Dog("Steven5", 8, 70));
   
  
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(CollectorsPractice1GroupingBy.dogsA);
        Map<Integer, List<Dog>> dogByWeight = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight));
        dogByWeight.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        System.out.println("Collector grouping by Weight: " + dogByWeight + "\n");
        
        Map<Integer, List<Dog>> dogAge = dogs.stream().collect(Collectors.groupingBy(Dog::getAge));
        dogAge.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        System.out.println("Collector grouping by Age: " + dogAge + "\n");
        
        Map<String, List<Dog>> dogName = dogs.stream().collect(Collectors.groupingBy(Dog::getName));
        dogName.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        System.out.println("Collector grouping by Name: " + dogName + "\n");
        
        // The same result like line 17:  Map<Integer, List<Dog>> dogByWeight = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight));
        Map<Integer, List<Dog>> dogByWeight2222 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.toList()));
        dogByWeight2222.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        
        
    }

}
