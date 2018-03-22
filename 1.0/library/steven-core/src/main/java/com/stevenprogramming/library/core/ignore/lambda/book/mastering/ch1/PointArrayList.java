package com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author steven.mendez
 * @since Jul 28 2017
 * @version 1.0
 */
public class PointArrayList extends ArrayList<Point> {

  public void forEach(PointAction t) {
    for (Point p : this) {
      t.doForPoint(p);
    }
  }

}
