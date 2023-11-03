package com.stevenprogramming.spring.rest.config;

import java.util.Arrays;
// https://leetcode.com/problems/longest-consecutive-sequence/submissions/1090214403/
public class TestTuring {

    public int longestConsecutive(int[] nums) {

        int maxConsecutive = 1;
        int tempConsecutive = 1;
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return 1;
        }

        Arrays.sort(nums);
        int firstNumber = nums[0];
        for(int idx=1; idx < nums.length; idx++){
            if(firstNumber + 1 == nums[idx]){
                ++tempConsecutive;
                firstNumber = nums[idx];
            } else if (firstNumber == nums[idx]) {
                firstNumber = nums[idx];
            } else {
                tempConsecutive = 1;
                firstNumber = nums[idx];
            }
            if(tempConsecutive > maxConsecutive){
                maxConsecutive = tempConsecutive;
            }
        }

        return maxConsecutive;
    }

    /*

       if (nums == null || nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int idx = 1;
    int currentLength = 0;
    int maxLength = 0;
    while(idx<nums.length){
      if(nums[idx-1]==nums[idx]-1){
        currentLength++;
        if(currentLength==1)currentLength++;
        idx++;
      }else{
        maxLength = Math.max(maxLength,currentLength);
        idx++;
        currentLength = 0;
      }
    }
     */

    public static void main(String[] args){
        long startTime = System.nanoTime();
        for(long i=0; i<=6_800_000; i++){
            long x = 0 + 1;
            x = i + 1;
            x = i + 2;
        }
        long endTime = System.nanoTime();

        long duration = ((endTime - startTime) / 1000000);
        System.out.println((endTime - startTime));
        System.out.println(duration);


        TestTuring testTuring = new TestTuring();
   //     int[] intArray= new int[]{100,4,200,1,3,2};
       // Arrays.sort(intArray);
       // Arrays.stream(intArray).forEach(System.out::println);
        //System.out.println(testTuring.longestConsecutive(intArray));
     //   int[] intArray2 = new int[]{0,3,7,2,5,8,4,6,0,1};
       // Arrays.sort(intArray2);
       // Arrays.stream(intArray2).forEach(System.out::println);
      //  System.out.println(testTuring.longestConsecutive(intArray2));

        int[] intArray3 = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
   //     Arrays.sort(intArray3);
       // Arrays.stream(intArray3).forEach(System.out::println);
     //  System.out.println(testTuring.longestConsecutive(intArray3));
        //expected = 7

        int[] intArray4 = new int[]{1,2,0,1};
      //  System.out.println(testTuring.longestConsecutive(intArray4));

    }




}
