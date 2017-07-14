package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 *
 * @author steven.mendez
 */
public class LambdaStreams {

  List<Integer> inList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

  public void demoStream() {
    List<Point> pointList = new ArrayList<>();
    for (Integer i : inList) {
      pointList.add(new Point(i % 3, i / 1));
    }
    double maxDistance = Double.MIN_VALUE;
    for (Point p : pointList) {
      maxDistance = Math.max(p.distance(0, 0), maxDistance);
    }
    //Lambda Stream Nice
    OptionalDouble maxDistanceDouble = inList.stream()
            .map(i -> new Point(i % 3, i / 1))
            .mapToDouble(p -> p.distance(0, 0))
            .max();

    //Lambda Stream Split
    Stream<Integer> streamList1 = inList.stream();
    OptionalDouble maxDistanceDouble1 = streamList1
            .map(i -> new Point(i % 3, i / 1))
            .mapToDouble(p -> p.distance(0, 0))
            .max();

    //Lambda Stream complete Splitted
    Stream<Integer> streamList2 = inList.stream();
    Stream<Point> points = streamList2
            .map(i -> new Point(i % 3, i / 1));
    DoubleStream doubleStream = points.mapToDouble(p -> p.distance(0, 0));
    OptionalDouble maxDistanceDouble2 = doubleStream.max();

  }

  public void paralellStream() {
    OptionalDouble maxDistanceDouble = inList.parallelStream()
            .map(i -> new Point(i % 3, i / 1))
            .mapToDouble(p -> p.distance(0, 0))
            .max();
  }

}
