package com.stevenprogramming.library.core.practices.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 07 2020
 * @version 1.0
 */
public class Prime {

  public static void main(String[] args) {

    int temp;
    boolean isPrime = true;

    int num = 4;
    for (int i = 2; i <= num / 2; i++) {
      temp = num % i;
      if (temp == 0) {
        isPrime = false;
        break;
      }
    }
    //If isPrime is true then the number is prime else not
    if (isPrime) {
      System.out.println(num + " is a Prime Number");
    } else {
      System.out.println(num + " is not a Prime Number");
    }

  }

}
