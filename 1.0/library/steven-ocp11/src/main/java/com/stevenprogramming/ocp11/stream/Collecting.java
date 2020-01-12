package com.stevenprogramming.ocp11.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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
        Set<Dog> dogSet = dogStream.collect(Collectors.toSet());

        //List<Dog> result = UtilStream.dogs.stream().collect(Collectors.joining());

    }
}
