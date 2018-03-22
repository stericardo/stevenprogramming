package com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1;

import java.awt.Point;

/**
 *
 * @author Steven Mendez
 */
public class TranslateByOne implements PointAction{

  @Override
  public void doForPoint(Point p) {
    p.translate(1, 1);
  }

  
}
