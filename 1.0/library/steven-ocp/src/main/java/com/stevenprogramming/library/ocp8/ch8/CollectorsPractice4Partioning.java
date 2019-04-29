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
public class CollectorsPractice4Partioning {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(StreamPractice.dogs);
        
        Map<Boolean, List<Dog>> dogByWeight4 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50));
        System.out.println("\n\n\n Partitioning::: \t\t\t" + dogByWeight4);
        
        // The same result as before
        dogByWeight4 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.toList()));
        System.out.println("\n\n\n Partitioning The same as before::: \t" + dogByWeight4);

        Map<Boolean, Long> dogByWeight5 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.counting()));
        System.out.println("\n\n\n Partitioning 55555 ::: " + dogByWeight5);

        Map<Boolean, List<String>> dogByWeight6 = dogs.stream()
                .collect(Collectors.partitioningBy(d -> d.getWeight() > 50, 
                        Collectors.mapping(Dog::getName, Collectors.toList())));
        System.out.println("\n\n\n Partitioning partitioningBy and Mapping List::: " + dogByWeight6);

        Map<Boolean, Map<String, List<Dog>>> dogByWeight666 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.groupingBy(Dog::getName)));
        System.out.println("\n\n\n Partitioning666 partitioningBy + grouping By::: " + dogByWeight666);
        
        
       Map<String, Map<Boolean, List<Dog>>> dogByWeight777 = dogs.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.partitioningBy(d -> d.getWeight() > 50)));
              System.out.println("\n\n\n dogByWeight777 groupingBy + partitioningBy::: " + dogByWeight777);
        
        
    }

}
