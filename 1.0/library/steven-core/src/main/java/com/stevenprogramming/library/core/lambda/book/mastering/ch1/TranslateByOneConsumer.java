package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

import java.awt.Point;
import java.util.function.Consumer;

/**
 *
 * @author Steven Mendez
 */
public class TranslateByOneConsumer implements Consumer<Point>{

  @Override
  public void accept(Point p) {
    p.translate(1, 1);
  }

  
}
