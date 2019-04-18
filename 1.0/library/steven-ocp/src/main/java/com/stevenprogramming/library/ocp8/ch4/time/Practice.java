package com.stevenprogramming.library.ocp8.ch4.time;

public class Practice
{
    static class ExceptionA extends RuntimeException{

    }

    static class ExceptionB extends ExceptionA{
        ExceptionB(String message){

        }
    }

    public static void getValueA() throws Exception{
        throw new ExceptionB( "Hola" );
    }

    public static void getValueB() throws Exception{
        try
        {
            getValueA();
        }

        catch(Exception e){
            if (e instanceof ExceptionB){
                throw e;
            }
        }
    }

    public static void main(String[] args){

        try
        {
            getValueB();
        } catch (ExceptionB e){
            System.out.println( "ExceptionB" );
        } catch (Exception e){
            System.out.println( "Normal Exception" );
        }

    }

}
