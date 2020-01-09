package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import java.io.*;

public class MyModAppDemo{
	
	public static void main(String[] args){
		if( SimpleMathFuncs.isFactor( 2, 10 ) ){
			System.out.println("January 2020  --- 2 is Factor of 10");
		}
		System.out.println("January 2020 Changed Simple Factor common to both 35 and 105 is " + SimpleMathFuncs.lcf ( 35, 105 ) );
		System.out.println("Simple Factor common to both 35 and 105 is " + SimpleMathFuncs.gcf ( 35, 105 ) );
		InputStream h;
	}
}
