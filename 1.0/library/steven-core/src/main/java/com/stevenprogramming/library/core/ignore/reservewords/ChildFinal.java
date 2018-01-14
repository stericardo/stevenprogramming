package com.stevenprogramming.library.core.ignore.reservewords;

/**
 *
 * @author steven
 */
public class ChildFinal extends FinalExample {

  public ChildFinal(String value) {
    super(value);
  }

  @Override
  public void method2() throws Exception {

  }

  @Override
  public void method3() throws NullPointerException {

  }

  @Override
  public void method4() throws NullPointerException {
    super.method4();
  }

  @Override
  public void method5() {
  }

  public void changeOBjectFinal(final FinalExample finalExample) {
    //finalExample = new FinalExample(""); Error on compilation
    final String psswd = finalExample.value;
    final int v;
    //psswd = ""; NOt allowed
    v = 2;
  }

}
