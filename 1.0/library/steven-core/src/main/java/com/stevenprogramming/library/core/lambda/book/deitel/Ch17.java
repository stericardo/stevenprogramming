package com.stevenprogramming.library.core.lambda.book.deitel;

/**
 * The first thing that I need to know is about sintax of lambda expresion
 * (listaParámetros) -> {instrucciones}
 * Example:
 * (int x, int y) -> {return x + y;}
 * 
 * You can do as well: 
 * (x, y) -> {return x + y;} the compiler determines the type of parameter
 * 
 * When the expresion only has one instruction we can skip write return word
 * and we can skip enter {}
 * 
 * (x, y) -> x + y
 * 
 * Then for recap we have 3 possible options:
 * (listaParámetros) -> {instrucciones}
 * (int x, int y) -> {return x + y;}
 * (x, y) -> {return x + y;}
 * (x, y) -> x + y
 * 
 * valor -> System.out.printf("%d ", valor)
 * () -> System.out.println("Bienvenido a los lambdas!")
 *
 * @author steven.mendez
 * @since Nov 20 2017
 * @version 1.0
 */
public class Ch17 {

    public void nothing(){
    
    }
    
    public static void main(String[] args){
        Ch17 ch17 = new Ch17();
        ch17.nothing();
    }
    
}
