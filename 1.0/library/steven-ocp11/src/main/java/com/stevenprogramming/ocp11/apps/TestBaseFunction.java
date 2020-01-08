package com.stevenprogramming.ocp11.apps;

import com.stevenprogramming.ocp11.BaseFunction;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class TestBaseFunction {

  public static void main(String[] args) {
    BaseFunction baseFunction = new BaseFunction();
    baseFunction.consumerInteger.accept(10);
    System.out.println(baseFunction.predicateInteger.test(10));
    Integer integerResultSupplier = baseFunction.supplierInteger.get();
    Integer integerResultFunction = baseFunction.functionInteger.apply(30);
    System.out.println(integerResultSupplier);
    System.out.println(integerResultFunction);

  }
}
