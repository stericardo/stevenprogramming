package com.stevenprogramming.library.ocp8.ch8;

import static com.stevenprogramming.library.ocp8.ch8.StreamPractice.dogs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author steven mendez
 */
public class CollectorsPractice1GroupingBy {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(StreamPractice.dogs);
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
