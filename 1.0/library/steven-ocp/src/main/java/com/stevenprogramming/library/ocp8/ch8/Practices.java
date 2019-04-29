/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.library.ocp8.ch8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    }

}

class Container{
    String value = null;
    Double doubleResult;
}
