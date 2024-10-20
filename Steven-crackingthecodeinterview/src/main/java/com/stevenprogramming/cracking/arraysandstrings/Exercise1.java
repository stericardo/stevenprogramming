package com.stevenprogramming.cracking.arraysandstrings;

public class Exercise1 {

    public static boolean uniqueChars(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int[] indexes = new int[26];
        for(int idx=0; idx < chars.length; idx++) {
            indexes[chars[idx] - 'a']++;
        }

        for(int idx=0; idx < 26; idx++) {
            if(indexes[idx] > 1){
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }


    public static void main(String[] args) {
        String string = "aSsdfsddsfdss";
        //System.out.println("Unique > " + uniqueChars(string));
        string = "stevn";
        //System.out.println("Unique > " + uniqueChars(string));

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
      //      System.out.println(word + ": " + isUniqueChars(word));
        }

        byte a = 64, b;
        int i;

        i = a << 2;
        b = (byte)(a << 2);
        System.out.println("Original value of a: " + a);
        System.out.println("i and b: " + i + " " + b);

    }
}
