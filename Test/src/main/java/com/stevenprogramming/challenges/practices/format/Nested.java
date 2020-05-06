package com.stevenprogramming.library.core.practices.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 07 2020
 * @version 1.0
 */
public class Nested {

  static class Inner {

    private class Inner2 {

      void msg() {
        System.out.println("data is " + (int) Math.pow(2, 4));
      }
    }
  }

  public static void main(String[] args) {
    Nested.Inner inner = new Nested.Inner();
    Inner.Inner2 inner2 = inner.new Inner2();
    inner2.msg();
  }

}
