package com.stevenprogramming.ocp11.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapImpl {
    static double y=10, x;

    public static void main( String[] args){
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "x");
       // map1.put("b", "x");
        BiFunction<String, String, String> f = String::concat;

        map1.merge("b", "y", f);
        map1.merge("c", "y", f);
        System.out.println(map1);
        System.out.println(x + " " +y);
    }
}
