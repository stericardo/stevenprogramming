package com.stevenprogramming.library.ocp8.ch8;

import static com.stevenprogramming.library.ocp8.ch8.StreamPractice.dogs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author steven
 */
public class CollectorsPractice2Counting {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(StreamPractice.dogs);
        Map<Integer, Long> dogByWeight2 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.counting()));
        System.out.println("\n" + dogByWeight2);
        // result {130=3, 20=1, 70=2, 40=1}
        Long longResult = dogs.stream().collect(Collectors.counting());
        System.out.println("\n" + longResult);
        // 7, counting elements
        Integer intgerResult = dogs.stream().collect(Collectors.summingInt(Dog::getWeight));
        System.out.println("\n" + intgerResult);
        //590,  sum all weight values
    }
}
