package com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1;

/**
 *
 * @author steven.mendez
 * @since Sep 25 2017
 * @version 1.0
 */
public class Solution {

    public static String printFizzBuzz(int input) {
        if (input % 5 == 0) {
            return "FizzBuzz";
        }
        if (input % 3 == 0) {
            return "Fizz";
        }

        return "";
    }
}
