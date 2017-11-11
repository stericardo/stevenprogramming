package com.stevenprogramming.library.core.lambda.book.mastering.ch1.part2.example2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author steven.mendez
 * @since Aug 09 2017
 * @version 1.0
 */
public class Example2Comparator {

    Optional<Example2Comparator> fooOption = Optional.empty();
    // T is the parameter = Point = p is the parameter
    // R is the return in this case Double  p.getX() body of apply
    // Function<T, R>
    // public R apply(T t)
    Function<Point, Double> keyExtractor = p -> p.getX();
    Comparator<Double> keyComparer = (d1, d2) -> Double.compare(d1, d2);
    Comparator<Point> compareByX = (p1, p2) -> keyComparer.compare(keyExtractor.apply(p1),
            keyExtractor.apply(p2));
    Comparator<Point> compareByX2 = (p1, p2) -> keyExtractor.apply(p1).compareTo(
            keyExtractor.apply(p2));

    public static <T, U extends Comparable<U>>
            Comparator<T> comparing(Function<T, U> keyExtractor) {
        return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    // p = T in comparing 
    // p.distance(0, 0) = body of apply and return doube as generic value that
    // match with U second parameter in interface "U"
    Comparator<Point> byDistance = comparing(p -> p.distance(0, 0));
    static List<Integer> inList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    public static void main(String[] args) {

        List<Integer> counts = Arrays.asList(1, 2, 3);
        Stream<Integer> asStream = counts.stream();
        asStream.forEach(x -> System.out.print(x * 2));
        asStream.forEach(System.out::print);

        // In sorted method p can be whatever and body as well ( p.distance(0, 0))
        // because we are using generics
        // inList.stream()
        //         .map(i -> new Point(i % 3, i / 3))
        //        .sorted(comparing(p -> p.distance(0, 0)))
        //        .forEach(p -> System.out.printf("(%f, %f)", p.getX(), p.getY()));
    }

}
