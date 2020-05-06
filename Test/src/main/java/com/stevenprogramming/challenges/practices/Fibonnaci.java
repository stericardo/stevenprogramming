package com.stevenprogramming.challenges.practices;

public class Fibonnaci {

	public long fib(long number){
		if(number == 0)
			return 0;
		else if (number == 1)
			return 1;
		long last = 1;
		long first = 0;
		long sum = 1;
		//System.out.print(first + " " + last);
		for(int cont=1; cont < number; cont++){
				sum = first + last;
				first = last;
				last = sum;
				//System.out.print(" "+ sum);
		}
		//System.out.println("");
		return sum;

	}

	public long fibRecursive(long n){
		if( n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibRecursive(n-1) + fibRecursive (n-2);

	}

	public long fibRecursive2(long n){
			if( n == 0)
				return 0;
			if(n == 1)
				return 1;
			return fibRecursive(n-1) + fib (n-2);

	}

	public static void main(String[] args){
		long fibNumber = 40;
		Fibonnaci f = new Fibonnaci();
		long init = System.currentTimeMillis();
		System.out.println("Steven Fibonacci: " + f.fib(fibNumber));
		System.out.println("Time: " + (System.currentTimeMillis() - init ) );
		init = System.currentTimeMillis();
		System.out.println("Recursive " + f.fibRecursive(fibNumber));
		System.out.println("Time: " + (System.currentTimeMillis() - init ) );

		init = System.currentTimeMillis();
		System.out.println("Recursive " + f.fibRecursive2(fibNumber));
		System.out.println("Time: " + (System.currentTimeMillis() - init ) );
	}

	public static void main2(String args[])
	{
	 int n1=0,n2=1,n3,i,count=10;
	 System.out.print(n1+" "+n2);//printing 0 and 1

	 for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
	 {
	  n3=n1+n2;
	  System.out.print(" "+n3);
	  n1=n2;
	  n2=n3;
	 }

	}

}