package com.stevenprogramming.library.core.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

/**
 *
 * @author steven.mendez
 * @since Nov 10 2017
 * @version 1.0
 */
public class Test9 {

    public String doSomething() {
        return "";
    }

    public int doSomethingInt() {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println();
        Object valu = new Object();
        Object valu2 = new Object();
        valu = valu2;
        System.out.println(valu.equals(valu2));
    }
}
