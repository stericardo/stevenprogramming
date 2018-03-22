package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

import org.junit.*;

import com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1.Solution;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testMethod() {
        Solution solution = new Solution();

        assertEquals(solution.printFizzBuzz(15), "FizzBuzz");
    }
}
