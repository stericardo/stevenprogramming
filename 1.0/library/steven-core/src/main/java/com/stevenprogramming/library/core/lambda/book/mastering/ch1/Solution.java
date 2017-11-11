package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

/**
 *
 * @author steven.mendez
 * @since Sep 25 2017
 * @version 1.0
 */
public class Solution {

    public static String PrintFizzBuzz(int input) {
        if (input % 5 == 0) {
            return "FizzBuzz";
        }
        if (input % 3 == 0) {
            return "Fizz";
        }

        return "";
    }
}
