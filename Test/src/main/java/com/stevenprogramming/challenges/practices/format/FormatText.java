package com.stevenprogramming.library.core.practices.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 07 2020
 * @version 1.0
 */
public class FormatText {

  static class Inner {

    private class Inner2 {

      void msg() {
        System.out.println("data is " + (int) Math.pow(2, 4));
      }
    }
  }

  public static void main(String[] args) {
    FormatText.Inner inner = new FormatText.Inner();

    Inner.Inner2 inner2 = inner.new Inner2();

    inner2.msg();

    // Inner2 i2= new inner.new Inner2();
    System.out.printf("%-15s %03d%n", "Stevenmain", 10);

    double n = 1240.35;

    NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
    String val = nf.format(n);

    System.out.println(val);

    NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
    String val2 = nf2.format(n);

    System.out.println(val2);

    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
    String val3 = nf3.format(n);

    System.out.println(val3);

  }

}
