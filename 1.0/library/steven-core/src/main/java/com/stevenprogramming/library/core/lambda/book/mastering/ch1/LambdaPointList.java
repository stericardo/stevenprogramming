package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Steven Mendez
 */
public class LambdaPointList {

  public void runNormal() {
    List<Point> pointList = Arrays.asList(new Point(1, 2), new Point(2, 3));
    Iterator it = pointList.iterator();
    while (it.hasNext()) {
      ((Point) it.next()).translate(1, 1);

    }
    for (Iterator<Point> iterator = pointList.iterator(); iterator.hasNext();) {
      ((Point) iterator.next()).translate(1, 1);
    }
    //After Java 5
    for (Point point : pointList) {
      point.translate(1, 1);
    }
  }

  public void demoArrayListLambda() {
    PointArrayList pointList = new PointArrayList();
    pointList.forEach(new TranslateByOne());

    ArrayList pointList2 = new ArrayList();
    pointList2.forEach(new TranslateByOneConsumer());

    ArrayList pointListInnerClass = new ArrayList();
    pointListInnerClass.forEach(new Consumer<Point>() {
      public void accept(Point p) {
        p.translate(1, 1);
      }
    });

    List<Point> pointListLambda = new ArrayList();
    pointListLambda.forEach(p -> p.translate(1, 1));

    List<String> items = new ArrayList<>();
    items.add("A");
    items.add("B");
    items.add("C");
    items.add("D");
    items.add("E");

    //lambda
    //Output : A,B,C,D,E
    items.forEach(item -> System.out.println(item));

    //Output : C
    items.forEach(item -> {
      if ("C".equals(item)) {
        System.out.println(item);
      }
    });
    //method reference
//Output : A,B,C,D,E
    items.forEach(System.out::println);

//Stream and filter
//Output : B
    items.stream()
            .filter(s -> s.contains("B"))
            .forEach(System.out::println);
  }

  public void mapLamdba() {
    Map<String, Integer> itemsMap = new HashMap<>();
    itemsMap.put("A", 10);
    itemsMap.put("B", 20);
    itemsMap.put("C", 30);
    itemsMap.put("D", 40);
    itemsMap.put("E", 50);
    itemsMap.put("F", 60);

    itemsMap.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

    itemsMap.forEach((k, v) -> {
      System.out.println("Item : " + k + " Count : " + v);
      if ("E".equals(k)) {
        System.out.println("Hello E");
      }
    });

  }
}
