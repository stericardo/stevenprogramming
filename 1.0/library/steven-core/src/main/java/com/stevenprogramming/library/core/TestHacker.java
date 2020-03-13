/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.library.core;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author smendez
 */
public class TestHacker {
  
  static int value;
  
  static {
    value = new Scanner(System.in).nextInt();
    Scanner s;
    s.nex
  }
  
  
  public static void main(String[] args){
    
    LocalDate localDate = LocalDate.of(2016, 01, 01);
     
    //Getting the day of week for a given date
    java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    System.out.println(localDate + " was a " + dayOfWeek);
    LocalDate firstWorkingDay;
    
    System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US));
  }
  
}
