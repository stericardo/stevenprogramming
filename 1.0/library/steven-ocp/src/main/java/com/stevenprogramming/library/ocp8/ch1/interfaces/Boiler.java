package com.stevenprogramming.library.ocp8.ch1.interfaces;

/**
 *
 * @author smendez
 */
public interface Boiler {

    public void boil();

    public static void shutdown() {
        System.out.println("shutting down");
    }
}
