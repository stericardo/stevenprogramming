package com.stevenprogramming.library.core.lambda.book.mastering.ch1.part2;

import java.awt.Point;
import java.util.Comparator;

/**
 *
 * @author steven.mendez
 * @since Jul 28 2017
 * @version 1.0
 * 
 * Location 450 of book.
 * 
 */
public class OrderXCoordinate {

  Comparator<Point> byx = new Comparator<Point>(){
    @Override
    public int compare(Point t, Point t1) {
      return Double.compare(t.getX(), t1.getX());
    }
  };
  
   Comparator<Point> byx2 = (t, t1) -> Double.compare(t.getX(), t1.getX());
  
}
