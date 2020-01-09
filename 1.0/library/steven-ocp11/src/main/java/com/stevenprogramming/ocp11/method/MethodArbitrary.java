package com.stevenprogramming.ocp11.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference to an instance method of an arbitrary object of a particular type
 */
public class MethodArbitrary {
    String name;
    static final Internal internal = new Internal();

    MethodArbitrary(String name){
        this.name = name;
    }

    public void printValue(MethodArbitrary methodArbitrary){
        System.out.println("WAY 3 >>> Printing Object Arbitrary without Inner class .... "+ methodArbitrary.name);
    }

    public static void printValueStatic(MethodArbitrary methodArbitrary){
        System.out.println("WAY 3 >>> Static Printing Object Arbitrary without Inner class .... "+ methodArbitrary.name);
    }

    public List<Integer> getValues(){
        return Arrays.asList(1,2,3);
    }

    public List<MethodArbitrary> getMethodArbitraryArraysObjects(){
        return Arrays.asList(new MethodArbitrary("Uno - Array"),new MethodArbitrary("Dos - Array"),new MethodArbitrary("Tres - Array"));
    }

    public List<MethodArbitrary> getMethodArbitraryListObjects(){
        List<MethodArbitrary> listMethodArbitraries = new ArrayList<>();
        listMethodArbitraries.add(new MethodArbitrary("Uno - List "));
        listMethodArbitraries.add(new MethodArbitrary("dos - List "));
        listMethodArbitraries.add(new MethodArbitrary("tres - List "));
        return listMethodArbitraries;
    }

    public void printValue(Integer values){
        System.out.println("WAY 3 >>> Printing Arbitrary without Innerclass .... "+ values);
    }

    static class Internal{
        public void printValue(Integer values){
            System.out.println("WAY 3 >>> Printing Arbitrary .... "+ values);
        }
    }

}
