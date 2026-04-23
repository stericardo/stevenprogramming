package com.stevenprogramming.cracking.arraysandstrings;

import java.util.ArrayList;

public class Generic<T> {

    private T value;
    public Generic(T value) {
        this.value = value;
    }
    public T getValue(){
        return value;
    }

    public static void main(String[] args) {
        G.s();
    }

    static class G {
        public static void s()
        {
            ArrayList<Generic> jj = new ArrayList<>();
            Generic<?> DD = new Generic<>("DD");
            Generic<?> DD2 = new Generic<>(4);
            jj.add(DD);
            jj.add(DD2);
            String f = (String) jj.get(0).getValue();
            int f2 = (Integer) jj.get(1).getValue();
            System.out.println(f + " " + f2);
        }
    }
}
