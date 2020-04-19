package com.stevenprogramming.ocp11.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartioningAndGrouping {

  public static void main(String[] args) {
    Stream<Dog> dogStream = UtilStream.dogs.stream();

    Map<Boolean, Map<String, List<Dog>>> dogByWeight666 = dogStream.collect(Collectors.partitioningBy(d -> d.getWeight() > 50,
            Collectors.groupingBy(Dog::getName)));
    UtilStream.printMap(dogByWeight666, "Particioning + Grouping");

    dogStream = UtilStream.dogs.stream();
    Map<String, Map<Boolean, List<Dog>>> dogByWeight777 = dogStream.collect(Collectors.groupingBy(Dog::getName,
            Collectors.partitioningBy(d -> d.getWeight() > 50)));
    UtilStream.printMap(dogByWeight777, "Grouping + Particioning");

  }
}
