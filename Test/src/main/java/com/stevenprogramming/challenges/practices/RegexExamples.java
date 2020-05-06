package com.stevenprogramming.challenges.practices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
    //https://devqa.io/extract-numbers-string-java-regular-expressions/ \\d+
    private static final Pattern p = Pattern.compile("\\d+");
    public static void main(String[] args) {
        Matcher m = p.matcher("string1234more567string890");
        if (m.find()) {
            System.out.println(m.group(0)); // second matched digits
        }
    }
}