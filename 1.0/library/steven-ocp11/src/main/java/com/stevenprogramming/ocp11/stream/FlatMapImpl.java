package com.stevenprogramming.ocp11.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 12 2020
 * @version 1.0
 */
public class FlatMapImpl {

  public static void main(String[] args) {

    String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
    Stream<String[]> temp = Arrays.stream(data);
    UtilStream.printStream(temp, "Stream<String>");
    
    temp = Arrays.stream(data);
    Stream<String> result = temp.flatMap( i -> Arrays.stream(i));
    UtilStream.printStream(result, "Stream<String>- FlatMap");
    //Stream<String> stringStream = Stream.of(array);

  }

}
