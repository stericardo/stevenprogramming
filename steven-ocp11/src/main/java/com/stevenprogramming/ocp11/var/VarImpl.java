package com.stevenprogramming.ocp11.var;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 14 2020
 * @version 1.0
 */
public class VarImpl {
  //var list = List.of(1, 2.0, "3"); not allowed
  public void getD() {

    var i = 45;
    var list = List.of(1, 2.0, "3");
    var list2 = new ArrayList<String>();
  }
}
