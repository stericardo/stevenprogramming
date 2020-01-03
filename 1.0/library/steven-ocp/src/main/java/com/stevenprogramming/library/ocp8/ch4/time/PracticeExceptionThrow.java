package com.stevenprogramming.library.ocp8.ch4.time;

import java.util.function.Predicate;

public class PracticeExceptionThrow
{
    Predicate d;
    static class ExceptionA extends RuntimeException{
        ExceptionA(String message){
            super(message);
        }
    }

    static class ExceptionB extends ExceptionA{
        ExceptionB(String message){
            super(message);
        }
    }

    public static void getValueA() throws Exception{
        throw new ExceptionB( " New ExceptionB on getValue A " );
    }

    public static void getValueB() throws Exception{
        try
        {
            getValueA();
        }

        catch(ExceptionB e){     
            System.out.println( "ExceptionB THROWING ..." );
                throw e;            
        }
        catch(ExceptionA e){            
                System.out.println( "Exception A ...." );            
        }
        finally{
            System.out.println( "Finally ...." );   
            throw new Exception( " Exception on finally" );
        }
    }

    public static void main(String[] args){

        try
        {
            getValueB();
        } catch (ExceptionB e){
            System.out.println( "ExceptionB " + e.getMessage() );
        } catch (Exception e){
            System.out.println( "Normal Exception"  + e.getMessage() );
        }

    }

}
