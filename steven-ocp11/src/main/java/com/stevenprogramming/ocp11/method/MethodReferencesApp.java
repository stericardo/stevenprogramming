package com.stevenprogramming.ocp11.method;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferencesApp {

    public static void main( String[] args){
        /**
         *  Reference to a static method
         */

        Function<String, String> function = MethodImpl::getValue;
        System.out.println(function.apply("WAY 1 >>> Steven"));

        /**
         * Reference to an instance method of an existing object
         * (args) -> object.instanceMethodName(args)
         */
        MethodImpl methodImpl = new MethodImpl();
        Function<String, String> functionReference = methodImpl::getValues;
        System.out.println(functionReference.apply("WAY 2 >>> StevenRef "));
        MethodArbitrary methodArbitrary = new MethodArbitrary("Simulator");
        Supplier<List<Integer>> supplierListInteger = methodArbitrary::getValues;

        /**
         * Reference to an instance method of an arbitrary object of a particular type
         * invokes a method onto the current object
         */
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda", "George" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Consumer<Integer> consumeList = MethodArbitrary.internal::printValue;
        supplierListInteger.get().forEach(consumeList);

        Consumer<Integer> consumeListReference = methodArbitrary::printValue;
        supplierListInteger.get().forEach(consumeListReference);

        Supplier<List<MethodArbitrary>> supplierObjectsArray = methodArbitrary::getMethodArbitraryArraysObjects;
        Consumer<MethodArbitrary> consumeMethodArbitraryObjects = methodArbitrary::printValue;
        List<MethodArbitrary> methodArbitrariesObjects = supplierObjectsArray.get();
        //methodArbitrariesObjects.add(methodArbitrary); Not Supported because of underlying Array
        methodArbitrariesObjects.forEach(consumeMethodArbitraryObjects);

        Supplier<List<MethodArbitrary>> supplierObjectsList = methodArbitrary::getMethodArbitraryListObjects;
        List<MethodArbitrary> methodArbitrariesObjectsList = supplierObjectsList.get();
        methodArbitrariesObjectsList.add(methodArbitrary);
        Consumer<MethodArbitrary> consumeMethodArbitraryObjectsStatic = MethodArbitrary::printValueStatic;
        methodArbitrariesObjectsList.forEach(consumeMethodArbitraryObjectsStatic);




    }
}
