package com.stevenprogramming.ocp11.function.enhacements;

import java.io.IOException;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 18 2020
 * @version 1.0
 */
public class ExceptionTryCatch2 implements AutoCloseable{
    String header = null;
    public ExceptionTryCatch2(String name) throws IOException{
        header = name;
        if("D2".equals(name)) throw new IOException("Unknown");
        System.out.println(header + " Opened");        
    }

    public String read() throws IOException{
        return "";
    }
    
    public void close(){
        System.out.println("Closing device "+header);
        throw new RuntimeException("RTE while closing "+header);
    }
    
    public static void main(String[] args) throws Exception {
        try(ExceptionTryCatch2 d1 = new ExceptionTryCatch2("D1");
            ExceptionTryCatch2 d2 = new ExceptionTryCatch2("D2")){
            throw new Exception("test");
         //catch (SecurityException e){
          //System.out.println(e);
         // e.printStackTrace();
        } finally{
          System.out.println("End");
        }
    }
    
}