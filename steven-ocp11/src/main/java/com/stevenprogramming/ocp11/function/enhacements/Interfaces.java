package com.stevenprogramming.ocp11.function.enhacements;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 16 2020
 * @version 1.0
 */
public class Interfaces implements Vaporizer{
  /**
   Interface methods cannot be at the same time:

Default and abstract (because default means the opposite of abstract)
Default and private (because you cannot override a private method)
Abstract and private (because you cannot override a private method)
   */
  public void boil() {
        System.out.println("Boiling...");
    }

    public static void main(String[] args) {
     
    }

  @Override
  public void method() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

 


  
}


  interface Boiler{
    public void boil();
    default void method(){
      System.out.println();
    }
    
   private void method2(){
      System.out.println();
      method();
    }
    private static void log(String msg){ //1
       System.out.println(msg);
    }
    public static void shutdown(){
        log("shutting down");
        
    }
}
interface Vaporizer extends Boiler{  
  
  public void method();
      
   
   public static void log(String msg){ //1
       System.out.println(msg);
    }
    public default void vaporize(){
        boil();
        
        System.out.println("Vaporized!");
    }
    /*
    static void log(String msg){ //1
       System.out.println(msg);
    }*/
}
