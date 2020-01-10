package com.stevenprogramming.ocp11.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * https://www.codementor.io/@eh3rrera/using-java-8-method-reference-du10866vx
 */
public class MethodConstructorSecondPart {


    public static void main(String[] args) {
        // *******************************************************     PART 1
        // Using an anonymous class
        Function<String, Integer> f =
                new Function<String, Integer>() {
                    public Integer apply(String s) {
                        return new Integer(s);
                    }
                };
        Integer i1 = f.apply("100");

        // Using a lambda expression
        Function<String, Integer> f2 = s -> new Integer(s);
        Integer i2 = f2.apply("100");

        // Using a method reference
        Function<String, Integer> f3 = Integer::new;
        Integer i3 = f3.apply("100");

        System.out.println(i1 + "-" + i2 + "-" + i3);

        // *******************************************************     PART 2
        // Using a lambda expression
        Supplier<List<String>> s = () -> new ArrayList<String>();
        List<String> l = s.get();

        // Using a method reference
        Supplier<List<String>> suplListSupplier = ArrayList::new;
        List<String> listResult = suplListSupplier.get();

        // *******************************************************     PART 3  BiFunction

        // Using a lambda expression
        BiFunction<String, String, Locale> fLocate = (lang, country) -> new Locale(lang, country);
        Locale loc = fLocate.apply("en","UK");

// Using a method reference
        BiFunction<String, String, Locale> fResult = Locale::new;
        Locale locResult = fResult.apply("en","UK");




    }

}
