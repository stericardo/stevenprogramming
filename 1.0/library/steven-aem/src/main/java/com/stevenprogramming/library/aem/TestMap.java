package com.stevenprogramming.library.aem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author steven.mendez
 * @since Oct 19 2017
 * @version 1.0
 */
public class TestMap implements Runnable {

    Object j;
    static int s;

    void start() {
        int x = 7;
        twice(x);
        System.out.print(x + " ");
    }

    class A {

        final public int GetResult(int a, int b) {
            return 0;
        }
    }

    class B extends A {

        //public int GetResult(int a, int b) {
        //  return 1;
        // }
    }

    void twice(int x) {
        x = x * 2;
        s = x;
    }

    public static void aMethod() throws Exception {
        try /* Line 5 */ {
            throw new Exception();
            /* Line 7 */
        } finally /* Line 9 */ {
            System.out.print("finally ");
            /* Line 11 */
        }
    }
    
    public static String getValue(){
        return null;
    }

    public static void main(String[] args) {
        String v = getValue();
        if(v.isEmpty()){
        }
        Map<String, String> values = new HashMap<>();
        values.put("h", "h");
        values.put("h", "h");
        values.put("h", "h");
        Object obj = new Object() {
            public int hashCode() {
                return 42;
            }
        };
        System.out.println(obj.hashCode());
        try {
            aMethod();
        } catch (Exception e) /* Line 20 */ {
            System.out.print("exception ");
        }
        System.out.print("finished");
        /* Line 24 */

        TestMap p = new TestMap();
        p.start();
        System.out.println(s);

        int i = 1, j = -1;
        switch (i) {
            case 0 :
                //, 1:
                j = 1;
            case 2:
                j = 2;
            default:
                j = 0;
        }
        System.out.println("j = " + j);
        
         Boolean b1 = new Boolean("false");
        boolean b2;
        b2 = b1.booleanValue();
        if (!b2) {
            b2 = true;
            System.out.print("x ");
        }
        if (b1 && b2) /* Line 13 */ {
            System.out.print("y ");
        }
        System.out.println("z");
        
        String a = "newspaper";
        a = a.substring(5,7);
        char b = a.charAt(1);
        a = a + b;
        System.out.println(a);
        
        try {
            badMethod();  
            System.out.print("A");  
        } catch (RuntimeException ex) /* Line 10 */ { 
            System.out.print("B"); 
        } catch (Exception ex1) { 
            System.out.print("C"); 
        } finally {
            System.out.print("D"); 
        } 
        System.out.print("E"); 
    
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void badMethod() { 
        throw new RuntimeException(); 
    } 
    
    
}

class A { 
    public A(int x){} 
} 

class B extends A {
    public B(int x){super(x);} 
} 
