package com.stevenprogramming.ocp11.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {

    public static void main( String[] args){
        Stream<Dog> dogStream =  UtilStream.dogs.stream();

        /**
         *   public static <T, K> Collector<T, ?, Map<K, List<T>>>
         *     groupingBy(Function<? super T, ? extends K> classifier)
         */
        dogStream =  UtilStream.dogs.stream();
        Function<Dog, Integer> dogIntegerFunction = dog -> dog.getWeight();
        Map<Integer, List<Dog>> dogGrouped = dogStream.collect(Collectors.groupingBy(dogIntegerFunction));
        UtilStream.printMap(dogGrouped, "Simple groupingBy");
        // or Reference Method
        dogStream =  UtilStream.dogs.stream();
        Function<Dog, Integer> dogIntegerFunction2 =  Dog::getWeight;
        dogGrouped = dogStream.collect(Collectors.groupingBy(dogIntegerFunction2)); // second parameter default is groupingBy(classifier, toList())
        UtilStream.printMap(dogGrouped, "Simple groupingBy");

        dogStream =  UtilStream.dogs.stream();
        dogGrouped = dogStream.collect(Collectors.groupingBy(dogIntegerFunction2, Collectors.toList())); // Second Parameter Unnecesary since default is toList
        UtilStream.printMap(dogGrouped, "Simple groupingBy");

        dogStream =  UtilStream.dogs.stream();
        Map<Integer, Long> dogCounting = dogStream.collect(Collectors.groupingBy(Dog::getWeight, Collectors.counting()));
        UtilStream.printMap(dogCounting, "groupedBy + Counting");


        dogStream =  UtilStream.dogs.stream();
        Map<Integer, List<String>> dogGroupedString = dogStream.collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName, Collectors.toList())));
        UtilStream.printMap(dogGroupedString, "groupedBy + mapping List");

        dogStream =  UtilStream.dogs.stream();
        Map<Integer, Set<String>> dogGroupedStringSet = dogStream.collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName, Collectors.toSet())));
        UtilStream.printMap(dogGroupedStringSet, "groupedBy + mapping Set");

        dogStream =  UtilStream.dogs.stream();
        Map<Integer, Map<String, List<Dog>>> dogGroupedMapMap = dogStream.collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName, Collectors.toList())));
        UtilStream.printMap(dogGroupedMapMap, "groupedBy + groupedBy - List");

        dogStream =  UtilStream.dogs.stream();
        Map<Integer, Map<String, Set<Dog>>> dogGroupedMapMapSet = dogStream.collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName, Collectors.toSet())));
        UtilStream.printMap(dogGroupedMapMapSet, "groupedBy + groupedBy - Set");

        //collectingAndThen
        dogStream =  UtilStream.dogs.stream();
        Set<Dog> dogResultSet = dogStream.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::<Dog> unmodifiableSet));
        UtilStream.printStreamln(dogResultSet.stream(), "collectingAndThen");

    }
}
