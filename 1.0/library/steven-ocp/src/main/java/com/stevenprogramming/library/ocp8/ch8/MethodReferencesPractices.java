package com.stevenprogramming.library.ocp8.ch8;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author steven mendez
 */
public class MethodReferencesPractices {
    
    public static void printValues(int value){
        System.out.println(value);
    }
    
    public void printValuesNormal(int value){
        System.out.println("Object " + value);
    }
    
    public static void main(String[] args){
        MethodReferencesPractices methodReferencesPractices = new MethodReferencesPractices();
        int[] values = {1,2,3,4};
        IntStream intStream = Arrays.stream(values, 0, 3);
        // 1 *** Reference to a static method
        intStream.forEach(MethodReferencesPractices::printValues);
        
        // 2 *** Reference to an instance method of an existing object 
        intStream = Arrays.stream(values, 0, 3);
        intStream.forEach(new MethodReferencesPractices()::printValuesNormal);
        //Equivalent to 2 option
        intStream = Arrays.stream(values, 0, 3);
        intStream.forEach(methodReferencesPractices::printValuesNormal);
        
        // 3 *** Reference to an instance method of an arbitrary object of a particular type
        Checker checker1 = new MethodReferencesPractices().new Checker(10);
        int numToCompare = 9;
        PredicateReference p = Checker::isBigger;
        boolean result = p.test(checker1,9);
        if (result) {
            System.out.println(checker1.value + " is bigger than " + numToCompare);
        }else {
            System.out.println(checker1.value + " is smaller  " + numToCompare);
        }
        
        // The next is an error because of private access
        /*
        PredicateReference2 p2 = CheckerApart::isBigger;
        result = p.test(checker1,9);
        if (result) {
            System.out.println(checker1.value + " is bigger than " + numToCompare);
        }else {
            System.out.println(checker1.value + " is smaller  " + numToCompare);
        }
        */
        // Needs to have at least protected or default
        CheckerApart2 checkerApart2 = new CheckerApart2(5);
        PredicateReference3 p2 = CheckerApart2::isBigger;
        result = p2.test(checkerApart2,1);
        if (result) {
            System.out.println(checkerApart2.value + " is bigger than " + 1);
        }else {
            System.out.println(checkerApart2.value + " is smaller  " + 1);
        }
        
        // 4
         // using the "IntSupplier" functional interface
        int num = 10;
        IntSupplier s1 = ObjIntCreation::new;
        ObjIntCreation newObj1 = s1.apply(num);
        System.out.println("new object has a instance value " + newObj1.num);
        // using the "IntObjectSupplier" functional interface
        IntObjectSupplier s2 = ObjIntCreation::new;
        ObjIntCreation newObj = s2.apply(newObj1);
        System.out.println("new object has a instance value " + newObj.num);
        
        
    }
    
    class Checker {
        int value = 0;
        public Checker(int value){
            this.value = value;
        }
        
        private boolean isBigger(int v){
            return value > v;
        }
    }
    @FunctionalInterface
    interface PredicateReference {
        boolean test(Checker m, int n);
    }
    @FunctionalInterface
    interface PredicateReference2 {
        boolean test(CheckerApart m, int n);
    }
    
    @FunctionalInterface
    interface PredicateReference3 {
        boolean test(CheckerApart2 m, int n);
    }
}

class CheckerApart2 {
    
     int value = 0;
        public CheckerApart2(int value){
            this.value = value;
        }
        
        boolean isBigger(int v){
            return value > v;
        }
}

class ObjIntCreation {
    public int num;
    public ObjIntCreation(int num) {
        this.num = num;
    }
    public ObjIntCreation(ObjIntCreation n) {
        this.num = n.num;
    }
}

@FunctionalInterface
 interface IntSupplier {
    ObjIntCreation apply(int n);
}
@FunctionalInterface
 interface IntObjectSupplier {
    ObjIntCreation apply(ObjIntCreation obj);
}