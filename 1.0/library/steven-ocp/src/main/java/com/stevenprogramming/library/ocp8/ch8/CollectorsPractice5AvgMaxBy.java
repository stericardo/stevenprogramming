package com.stevenprogramming.library.ocp8.ch8;

import static com.stevenprogramming.library.ocp8.ch8.StreamPractice.dogs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author steven mendez
 */
public class CollectorsPractice5AvgMaxBy {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(StreamPractice.dogs);
        Map<String, Integer> dogByWeight7 = dogs.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.summingInt(Dog::getWeight)));
        System.out.println("\n\n\n Grouping Summing::: " + dogByWeight7);

        Map<String, Double> dogByWeight8 = dogs.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.averagingDouble(Dog::getWeight)));
        System.out.println("\n\n\n Grouping Averaging::: " + dogByWeight8);

        String dogByWeight9 = dogs.stream().map(Dog::getName).collect(Collectors.joining(","));
        System.out.println("\n\n\n joining::: " + dogByWeight9);

        Stream<String> dogByWeight10 = dogs.stream().map(Dog::getName);
        System.out.println("\n\n\n joining::: " + dogByWeight10);

        Optional<Dog> oldest = dogs.stream().collect(Collectors.maxBy((d1, d2) -> d1.getWeight() - d2.getWeight()));
        oldest.ifPresent(d -> System.out.println("\n\n\n More Weight Dog::: " + d));
    }

}
