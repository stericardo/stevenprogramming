package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Steven Mendez
 */
public class PointListExample {

  public void runNormal() {
    List<Point> pointList = Arrays.asList( new Point(1, 2),  new Point(2, 3));
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
}
