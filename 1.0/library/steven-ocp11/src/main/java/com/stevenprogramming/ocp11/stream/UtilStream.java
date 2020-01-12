package com.stevenprogramming.ocp11.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UtilStream {

    public static  <T> void printStreamln(Stream<T> stream,String description) {
        System.out.println("\n\t\t*****************   printStreamln  New Line " + description + " *******************\n");
        stream.forEach(System.out::println);
    }

    public static  <T> void printStream(Stream<T> stream, String description) {
        System.out.println("\n\t\t*****************   printStream  OneLine " + description + " *******************\n");
        stream.forEach(System.out::print);
    }

    public static void printMap(Map<?,?> map, String description){
        System.out.println("\n\t\t*****************   printMap "+ description +" *******************\n");
        map.forEach((k,v) -> {System.out.println("Key: "+k+" Value: "+v);});
    }

    public static List<Dog> dogs = Arrays.asList(new Dog("Steven", 10, 40),
            new Dog("Steven2", 9, 70),
            new Dog("Steven3", 8, 130),
            new Dog("Steven3", 8, 130),
            new Dog("Steven4", 7, 20),
            new Dog("Steven5", 17, 130),
            new Dog("Steven5", 17, 130),
            new Dog("Steven5", 17, 130),
            new Dog("Steven5", 8, 70));

}
