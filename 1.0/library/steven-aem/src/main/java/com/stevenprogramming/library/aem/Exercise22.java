package com.stevenprogramming.library.aem;

/**
 *
 * @author steven.mendez
 * @since Oct 19 2017
 * @version 1.0
 */
public class Exercise22 {

    static int resultTimesFound = 0;

    public static boolean foundAddTimes(int denomination, int value) {
        int result = 0;
        for (int cont = 0; cont < denomination; cont++) {
            result += value;
        }
        if (result == denomination) {
            return true;
        }
        return false;
    }

    public static boolean foundAddAllElements(int denomination, int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        if (result == denomination) {
            return true;
        }
        return false;
    }

    public static void timesFound(int denomination) {

        int temp = 0;
        for (int cont = denomination - 1; cont > 0; cont--) {
            temp = cont + (cont - 1);
            if (temp == denomination) {
                resultTimesFound += 1;
                break;
            } else {
                timesFound(cont);
            }
        }
    }

    public static void timesFoundPow(int denomination, int[] values) {
        for (int value : values) {
            if ((value + value) == denomination) {
                resultTimesFound += 1;
            }
        }
    }

    public static void main(String[] args) {
        int denomination = 4;
        int[] values = {1, 2, 3};
        int timesFound = 0;
        if (foundAddAllElements(denomination, values)) {
            timesFound += 1;
        }
        for (int cont = 0; cont < values.length; cont++) {
            if (foundAddTimes(denomination, values[cont])) {
                timesFound += 1;
                continue;
            }

        }
        timesFound(denomination);
        timesFoundPow(denomination, values);
        System.out.println(timesFound + resultTimesFound);

    }

}
