package com.stevenprogramming.cracking.arraysandstrings.learn.valeria;

public class ValeriaDay2 {

    public static void main(String[] args) {
        int numero1 = 100;
        String name;
        int numero2 = 200;
        int result1 = numero1 + numero2;
        int result2 = numero2 - numero1;




        if(numero1 < numero2){
            System.out.println( numero2 +  " es mayor a " + numero1);
            System.out.println( numero1 +  " es menor a " + numero2);

            name="la resta de " + numero2 +"-" +numero1 + " es "  + result2;
            System.out.println(name);




        } else {
            System.out.println( numero1 + " es mayor a " + numero2);

        }

    }
}
