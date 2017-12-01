package com.stevenprogramming.library.core.lambda.book.mastering.ch1;

/**
 *
 * @author steven.mendez
 * @since Sep 25 2017
 * @version 1.0
 */
import com.stevenprogramming.library.core.lambda.book.mastering.ch1.Solution;
import org.junit.*;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testMethod() {
        Solution solution = new Solution();

        assertEquals(solution.printFizzBuzz(15), "FizzBuzz");
    }
}
