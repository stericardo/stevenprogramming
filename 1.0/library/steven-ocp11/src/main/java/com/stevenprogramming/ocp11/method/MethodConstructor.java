package com.stevenprogramming.ocp11.method;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Stream;

public class MethodConstructor {
    int num;

    public MethodConstructor(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        /**
         * Reference to a constructor
         */
        MethodConstructorSupplier sa = i -> new MethodConstructor(i);
        MethodConstructor newObja = sa.get(101);
        System.out.println("New object has a instance value " + newObja.num);

        MethodConstructorSupplier s1 = MethodConstructor::new;
        MethodConstructor newObj1 = s1.get(101);
        System.out.println("New object has a instance value " + newObj1.num);

        // Second example
        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        Stream<Bicycle> bicycleStream = bikeBrands.stream().map(Bicycle::new);
        bicycleStream.forEach(System.out::println);

        //Third Example
        Stream<Bicycle> bicycleStreamFunction = bikeBrands.stream().map(str -> new Bicycle(str+"--Function"));
        bicycleStreamFunction.forEach(System.out::println);

    }
}

@FunctionalInterface
interface MethodConstructorSupplier {
    MethodConstructor get(int n);
}

class Bicycle {

    private String brand;
    private Integer frameSize;

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "brand='" + brand + '\'' +
                ", frameSize=" + frameSize +
                '}';
    }

}
