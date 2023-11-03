package com.stevenprogramming.spring.rest.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

public class TestOcceans {

    public static int swapWholeNumber(int numberSize, String paramterStringValue){
        StringBuilder swappingNumber = new StringBuilder();
        swappingNumber.append(paramterStringValue.charAt(0));

        for(int cont= numberSize -1 ; cont > 0; cont--){
            swappingNumber.append(paramterStringValue.charAt(cont));
        }

        return Integer.parseInt(swappingNumber.toString());
    }

    public static int swapPairNumber(int numberSize, String paramterStringValue, int startIndex){
        StringBuilder swappingNumber = new StringBuilder();
        swappingNumber.append(paramterStringValue.charAt(0));

        for(int cont= 1 ; cont < numberSize ; cont++){
            if(cont == startIndex){
                if(cont+1 < numberSize) {
                    swappingNumber.append(paramterStringValue.charAt(cont + 1));
                    swappingNumber.append(paramterStringValue.charAt(cont));
                    ++cont;
                }
            } else {
                swappingNumber.append(paramterStringValue.charAt(cont));
            }
        }

        return Integer.parseInt(swappingNumber.toString());
    }

    public static int greaterWithSameDigits(int n) {
        String paramterStringValue = String.valueOf(n);
        int numberSize = paramterStringValue.length();

        SortedSet<Integer> values = new TreeSet<>();

        for (int idx = 0; idx < numberSize; idx++) {
            int result = swapWholeNumber(numberSize, paramterStringValue);
            if (result > n) {
                values.add(result);
            }
        }

        for (int idx = 1; idx < numberSize; idx++) {
            int result = swapPairNumber(numberSize, paramterStringValue, idx);
            if (result > n) {
                values.add(result);
            }
        }

        if (values.isEmpty() ) {
            return -1;
        }
        return values.last();
    }

    public static void main(String[] args){

        String json = "{ \"a\": \"A\"}";
        JsonObject jsonObject = new JsonParser().parseString(json).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray();

        System.out.print("HARDCODE BASE CASE 129 = ");
        System.out.println(greaterWithSameDigits(129));

        System.out.print("HARDCODE BASE CASE 2493 = ");
        System.out.println(greaterWithSameDigits(2493));

        System.out.print("24393 = ");
        System.out.println(greaterWithSameDigits(24393));

        System.out.print("54321 = ");
        System.out.println(greaterWithSameDigits(54321));

        System.out.print("543210 = ");
        System.out.println(greaterWithSameDigits(543210));

    }

    /**
     * 129 192
     * 2493 2943
     *
     *
     *
     */



}
