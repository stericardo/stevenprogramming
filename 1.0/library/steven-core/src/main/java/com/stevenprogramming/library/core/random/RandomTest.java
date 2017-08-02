package com.stevenprogramming.library.core.random;

import java.util.Random;

/**
 *
 * @author Steven Mendez
 * @since Aug 02 2017
 * @version 1.0
 */
public class RandomTest {
  
private static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
}
  
  public static void main(String[] args){
    int begin = 0;
    int end = 1000;
    int result = randInt(begin, end);
    System.out.println(result);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.valueOf(result));
    begin = result * 10;
    end = begin * 2;
    stringBuilder.append("_" + String.valueOf(begin));
    stringBuilder.append("_" + String.valueOf(end));
    result = randInt(begin, end);
    System.out.println(result + " begin " + begin + " end " + end);
    stringBuilder.append("_" + String.valueOf(result));
    System.out.println(stringBuilder.toString());
    
  }

}
