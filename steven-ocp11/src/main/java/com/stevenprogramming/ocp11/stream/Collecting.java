package com.stevenprogramming.ocp11.stream;

import java.nio.file.Files;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * https://www.baeldung.com/java-8-collectors
 */
public class Collecting {

    public static void main( String[] args){
        Stream<Dog> dogStream =  UtilStream.dogs.stream();
        List<Dog> dogList = dogStream.collect(Collectors.toList());
        
        
        dogStream =  UtilStream.dogs.stream();
        Stream<Dog> dogStreamResult  = dogStream.filter(i -> i.getAge() > 10);
        dogStreamResult.forEach(System.out::println);
        


        dogStream =  UtilStream.dogs.stream();
        Set<Dog> dogSet = dogStream.collect(Collectors.toSet());

        
        dogStream =  UtilStream.dogs.stream();
        Stream<String> longgg= dogStream.map(i -> i.getName()).sorted();
        longgg.forEach(System.out::print);
       // String result222 = dogStream.collect(Collectors.joining());

    }
}
