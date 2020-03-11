package com.stevenprogramming.ocp11.stream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 19 2020
 * @version 1.0
 */
public class FilteringImpl {
    
  public static void main(String... args) {
   
    int value = 0;

        List<Integer> list = IntStream.of(2, 4, 6, 8, 10, 12)
                                      .boxed()
                                      .collect(Collectors.filtering(i -> i % 4 == 0,
                                              Collectors.toList()));
        System.out.println(list);
        
       
       Supplier<Integer> valueS = ()-> value; //1
       
        

    }

}
