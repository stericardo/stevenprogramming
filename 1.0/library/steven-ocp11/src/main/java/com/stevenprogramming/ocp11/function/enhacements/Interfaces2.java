package com.stevenprogramming.ocp11.function.enhacements;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 19 2020
 * @version 1.0
 */
public class Interfaces2 {
  
  public static void main(String[] args) {
     House h = new HomeOffice();  //1
    System.out.println(h.getAddress()); //2 iF WE COMMENT implementation on the HomeOffice does not compile
  }

}

interface House{
  public default String getAddress(){
     return "101 Main Str";
  }
}

interface Office {
  public default String getAddress(){
     return "101 Smart Str";
  }
}

class HomeOffice implements House, Office{
  public String getAddress(){
     return "R No 1, Home";
  }
}
