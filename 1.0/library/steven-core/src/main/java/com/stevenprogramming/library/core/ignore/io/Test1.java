package com.stevenprogramming.library.core.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *
 * @author steven.mendez
 * @since Nov 10 2017
 * @version 1.0
 */
public class Test1 {

    public static String swapEven(String value) {
        char[] charArray = value.toCharArray();
        char temp = charArray[0];
        charArray[0] = charArray[2];
        charArray[2] = temp;
        return String.valueOf(charArray);
    }

    public static String swapOdd(String value) {
        char[] charArray = value.toCharArray();
        char temp = charArray[1];
        charArray[1] = charArray[3];
        charArray[3] = temp;
        return String.valueOf(charArray);
    }

    /**
     * Complete the function below. DO NOT MODIFY anything outside this method.
     */
    static String[] twins(String[] a, String[] b) {
        String[] arrayTwins  = new String[a.length];
        int cont = 0;
        for (String currentAPosition : a) {
            currentAPosition = swapEven(currentAPosition);
            currentAPosition = swapOdd(currentAPosition);
            if (currentAPosition.equals(b[cont])) {
               arrayTwins[cont] = "Yes";
            }else{
                arrayTwins[cont] = "No";
            }
             ++cont;
        }
        return arrayTwins;
    }

}
