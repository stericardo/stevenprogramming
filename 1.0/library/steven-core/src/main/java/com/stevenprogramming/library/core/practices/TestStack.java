package com.stevenprogramming.library.core.practices;

public class TestStack {

    public static void main(String[] args) throws Exception {
        Thread.sleep(12000);
        try {
            deep(1);
        } catch (Exception e) {
        }
        Thread.sleep(10000);
    }

    private static void deep(long d) {
        //System.err.println("Printint Value " + d + " Size stack " + Thread.currentThread().getStackTrace().length +
        //" id = " + Thread.currentThread().getId());
        System.err.println(d);
        //Thread.currentThread().dumpStack();
        deep(++d);
    }

}
