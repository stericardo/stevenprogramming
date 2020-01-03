package com.stevenprogramming.library.ocp8.objects;

/**
 *
 * @author steven
 */
public abstract class AbstractTest {
    
    public abstract void get();
    
    public static void getPrint(){
        System.out.println("Hola from print");
    }
    
    public static void main(String[] args) {
        Get abstractTest = () -> System.out.println("Hola");
        abstractTest.get();
        
        Get abstractTest2 = AbstractTest::getPrint;
        abstractTest2.get();
    }
    
    interface Get{
        public abstract void get();
    }
}
