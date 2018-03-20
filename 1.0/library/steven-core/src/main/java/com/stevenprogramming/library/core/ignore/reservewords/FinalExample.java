package com.stevenprogramming.library.core.ignore.reservewords;

/**
 *
 * @author steven mendez
 * @since 14 Jan 2018
 * @version 1.0
 */
public class FinalExample {

  private final String atribConstante;
  public final String value;

  public FinalExample(String valueTemp) {
    value = valueTemp;
    atribConstante = valueTemp;
  }

  public static void main(String[] args) {

  }

  public final void method() {

  }

  public void method2() throws Exception {

  }

  public void method3() {
  }

  public void method4() throws NumberFormatException {
  }

  public void method5() throws NumberFormatException {
  }

}
