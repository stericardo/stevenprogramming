package com.stevenprogramming.spring.rest;

import java.util.Arrays;
import java.util.List;

public class TestExample {

    public static void main(String[] args) {
        int[] dd = new int[]{10,1,48,3};
        //List<Integer> list = (List<Integer>) Arrays.asList(dd);

        Arrays.sort(dd);
        for (int i : dd) {
            System.out.println(i);
        }

        /*
         public static int suitableLocations(List<Integer> center, long d) {
        if(center == null || center.size() == 0){
            return 0;
        }
        Map<Integer, Integer> prefixSumTest = new HashMap<>();
        int accumulator = 0;
        int suitableLocations =0;

        for(int idx=center.get(0); idx < center.get(center.size() - 1); idx ++){
            prefixSumTest.put(idx, accumulator);
            accumulator +=2;
        }

        for(int idx=center.get(0); idx < center.get(center.size() - 1); idx ++){

            for(int idCenter=0; idCenter < center.size() - 1; idCenter ++){
                int distanceCenter = prefixSumTest.get(center.get(idCenter));
                int warehouse = prefixSumTest.get(idx);
                if(distanceCenter - warehouse <= d){
                    ++suitableLocations;
                }
            }
        }

        return suitableLocations;

    }
         */
    }
}
