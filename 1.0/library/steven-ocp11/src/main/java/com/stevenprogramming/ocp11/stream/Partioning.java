package com.stevenprogramming.ocp11.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partioning {

  public static void main(String[] args) {
    Stream<Dog> dogStream = UtilStream.dogs.stream();
    Map<Boolean, List<Dog>> dogByWeight4 = dogStream.collect(Collectors.partitioningBy(d -> d.getWeight() > 50)); // Second paramter default toList
    UtilStream.printMap(dogByWeight4, "Particioning + Basic");

    // The same result as before
    dogStream = UtilStream.dogs.stream();
    dogByWeight4 = dogStream.collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.toList())); // Second parameter Unnecesary toList default
    UtilStream.printMap(dogByWeight4, "Particioning + Basic + toList ");

    dogStream = UtilStream.dogs.stream();
    Map<Boolean, Long> dogByWeight5 = dogStream.collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.counting()));
    UtilStream.printMap(dogByWeight5, "Particioning + Counting ");

    dogStream = UtilStream.dogs.stream();
    Map<Boolean, List<String>> dogByWeight6 = dogStream
            .collect(Collectors.partitioningBy(d -> d.getWeight() > 50,
                    Collectors.mapping(Dog::getName, Collectors.toList())));
    UtilStream.printMap(dogByWeight6, "Particioning + mapping + toList ");
  }
}
