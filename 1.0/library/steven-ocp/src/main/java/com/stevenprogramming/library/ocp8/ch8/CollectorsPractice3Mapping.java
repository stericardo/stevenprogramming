package com.stevenprogramming.library.ocp8.ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/**
 *
 * @author steven mendez
 */
public class CollectorsPractice3Mapping {


    public static void main(String[] args) {
        
        
        IntUnaryOperator k;
        List<Dog> dogs = new ArrayList<>(StreamPractice.dogs);
        Map<Integer, List<String>> dogsProccessed = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName2, Collectors.toList())));
        dogsProccessed.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        System.out.println("\n dogsProccessed :::: " + dogsProccessed);

        dogsProccessed = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName, Collectors.toList())));
        dogsProccessed.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        System.out.println("\n dogsProccessed :::: " + dogsProccessed);

        Map<Integer, Set<String>> dogsProccesseds = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName, Collectors.toSet())));
        dogsProccesseds.forEach((m, n) -> System.out.println("Key>" + m + "@ " + n));
        System.out.println("\n dogsProccessed :::: " + dogsProccesseds);

        Set<String> dogsProccesseds2 = dogs.stream().collect(Collectors.mapping(Dog::getName, Collectors.toSet()));
        System.out.println("\n mapping set :::: " + dogsProccesseds2);

        List<String> dogsProccesseds3 = dogs.stream().collect(Collectors.mapping(Dog::getName, Collectors.toList()));
        System.out.println("\n mapping List :::: " + dogsProccesseds3);

        // Those is to compare Mapping vrs Grouping By
        System.out.println("\n\n Comparing");
        Map<Integer, Map<String, List<Dog>>> dogByWeight33 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName, Collectors.toList())));
        System.out.println("\n dogByWeight333&&&&*** :::: " + dogByWeight33);

        Map<Integer, Map<String, List<Dog>>> dogByWeight3322 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName)));
        System.out.println("\n dogByWeight333&&&&*** :::: " + dogByWeight3322);

        Map<Integer, Map<String, Set<Dog>>> dogByWeight334 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName, Collectors.toSet())));
        System.out.println("\n dogByWeight333&&&&*** :::: " + dogByWeight334);
               

    }




}

