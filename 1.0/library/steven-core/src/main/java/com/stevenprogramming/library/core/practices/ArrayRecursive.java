package com.stevenprogramming.library.core.practices;

public class ArrayRecursive{
	
	public static int[] initArray(int capacity){
		int[] result = new int[capacity];
		for(int cont=0; cont < capacity; cont++){
			result[cont] = 0;
		}
		return result;
	}
	
	public static int[] fillV3(int capacity, int[][] v4){
		int[] v3 = initArray(capacity);
		int temp = 0;
		for(int cont=0; cont < v4.length-1; cont++){
			temp = v4[cont][0];
			
			for(int cont2= cont+1; cont2 < v4.length;  cont2++){
				
				if(temp == v4[cont2][0]){
					v3[temp -1] = 1;
				}
			}
		}
		for(int c=0; c< capacity-1; c ++ ){
			System.out.println("v3.length " + v3.length +"Parent " + v3[c] + " Parent " + v4[c][0] + " Node " + v4[c][1]  );
		}
		
		return v3;
	}
	public static void main(String[] args) {
		int[][] v= {{1,2}, {1,3}, {3,4}, {3,5}};
		int[] result = fillV3(5, v);
		for(int c=0; c< result.length; c++){
			System.out.print(result[c] + " ");
		}
		
		int[][] v2= {{1,2}, {1,3}, {1,6}, {2,4}, {2,5}, {6,7}, {6,8}, {8,9}, {8,10}};
		int[] result2 = fillV3(10, v2);
		for(int c=0; c< result2.length; c++){
			System.out.print(result2[c] + " ");
		}
		
	}
	
}
