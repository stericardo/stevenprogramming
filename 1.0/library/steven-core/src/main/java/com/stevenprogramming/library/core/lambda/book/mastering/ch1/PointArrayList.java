package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author steven.mendez
 */
public class PointArrayList extends ArrayList<Point> {

  public void forEach(PointAction t) {
    for (Point p : this) {
      t.doForPoint(p);
    }
  }

}
