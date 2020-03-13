package com.stevenprogramming.performance;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class will serve a main 
 *
 * @author Steven Ricardo Mendez Brenes
 * @version 1.0
 *
 */
@SpringBootApplication
public class DemoApplication {

  public static void printStringConcat(int i){
    System.out.println("v" + i);
  }
  
  public static void printStringBuilder(int i){
    StringBuilder sb = new StringBuilder("v");
    sb.append(i);
    System.out.println(sb.toString());
  }
  
  public static void main(String[] args) {
    List values = getValues();
    values.forEach( v -> System.out.println(((Object[])v)[0] + " " + ((Object[])v)[1]) );
    
  }
  
  public static List getValues(){
    List list = new ArrayList();
    String[]  valueString = new String[2]; 
    valueString[0] = "Steven"; 
    valueString[1] = "Mendez";
    list.add(valueString);
    valueString = new String[2]; 
    valueString[0] = "ST"; 
    valueString[1] = "BRE";
    list.add(valueString);
    return list;
  }
  /*
	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
    for ( int i = 0; i < 100000; i++){
      printStringBuilder(i);
    }
    
    for ( int i = 0; i < 100000; i++){
      printStringConcat(i);
    }
    
	}*/

}
