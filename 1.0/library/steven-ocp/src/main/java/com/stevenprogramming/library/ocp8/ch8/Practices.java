/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.library.ocp8.ch8;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author steven mendez
 */
public class Practices {

    public static void main(String[] args) {
        //int[] values =
        List<Integer> ls = Arrays.asList(1, 2, 6, 9, 6, 5, 7);
        int result = ls.stream().reduce(1, (a, b) -> a > b ? a : b);
        System.out.println("1)" + result); 
        // returns 9 as 9 is the mayor
        result = ls.stream().reduce(11, (a, b) -> a > b ? a : b);
        System.out.println("1)" + result); 
        // returns 11 as 11 is the identity and mayor
        
        String[] stringArray = {"Hola", "Todo", "Bien"};
        String resultString = Arrays.stream(stringArray).reduce("Start>", (a,b) -> a.concat(b));
        System.out.println("1)" + resultString); 
        
        final Container container = new Container();
        Arrays.stream(stringArray).reduce((a,b) -> a.concat(b)).ifPresent(v-> { container.value=v;} );
        System.out.println("1)" + container.value); 
        
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        lista.stream().reduce((a,b) -> a+b).ifPresent(v-> {container.doubleResult = v.doubleValue() / lista.size();});
         System.out.println("1)" + container.doubleResult); 
        
         Double doubleResult = lista.stream().mapToInt(v -> v).asDoubleStream().average().getAsDouble();
         System.out.println("1)" + container.doubleResult); 
         
         doubleResult = lista.stream().mapToDouble(v -> v).average().getAsDouble();
         System.out.println("1)" + container.doubleResult); 
         
         double r = lista.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
         System.out.println("1) Again " + r); 
         
         IntStream is1 = IntStream.range(1, 3);
        IntStream is2 = IntStream.rangeClosed(1, 3);
        IntStream is3 = IntStream.concat(is1, is2);
        Object val = is3.boxed().collect(Collectors.groupingBy(k->k)).get(3);
        System.out.println(val);
        
        is1 = IntStream.range(1, 3);
        is2 = IntStream.rangeClosed(1, 3);
        IntStream is4 = IntStream.concat(is1, is2);
        Map<Integer, List<Integer>> listaBoxed = is4.boxed().collect(Collectors.groupingBy(k->k));
        listaBoxed.forEach( (k,v) -> System.out.println(k + " --- " + v));
        
        Stream.of("one", "two", "three", "four")
         .filter(e -> e.length() > 3)
         .peek(e -> System.out.println("Filtered value: " + e))
         .map(String::toUpperCase)
         .peek(e -> System.out.println("Mapped value: " + e))
         .collect(Collectors.toList());
        
        boolean resultBol = Stream.of("one", "two", "three", "four")
                .peek(e -> System.out.println("22 Filtered value: " + e))
         .filter(e -> e.length() < 2 )
          .peek(e -> System.out.println("2233 Filtered value: " + e))
         .anyMatch(v -> v.equals("three"));
        System.out.println(resultBol);
        
        resultBol = Stream.of("one", "two", "three", "four")
                .peek(e -> System.out.println("aa22 Filtered value: " + e))
         .filter(e -> e.length() <= 3 )
          .peek(e -> System.out.println("aa2233 Filtered value: " + e))
         .anyMatch(v -> v.equals("one"));
        System.out.println(resultBol);
        
        
        double doubleResulta = Stream.of(100, 110, 120, 130)
                .peek(e -> System.out.println("value: " + e))
         .filter(e -> e < 120 )
          .peek(e -> System.out.println("value>>>: " + e))
                .mapToDouble(e-> e)
         .sum();
        System.out.println(doubleResulta);
        
        Map m;
        List o;
        NavigableMap l ;
        TreeMap tr;
        //Collections.rotate(lista, result);
        
       
        
    }

}

class Container{
    String value = null;
    Double doubleResult;
}