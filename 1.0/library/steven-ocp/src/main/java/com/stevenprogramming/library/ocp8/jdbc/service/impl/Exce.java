package com.stevenprogramming.library.ocp8.jdbc.service.impl;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Exce {
	
	private static int[] copyFromRepeated(int[] A) {
		int[] copy = new int[A.length -1 ];
		int cont=0;
		int temp=A[0];
		boolean copied = false;
		for(int i=1; i < A.length; i++) {
			if(temp == A[i] && !copied) {
				copied = true;
				
			}else {
				copy[cont] = temp;
				temp= A[i];
				++cont;
			}
		}
		copy[cont] = A[A.length-1];
		return copy;
	}
	
	private static int computeMax(int[] A) {
		IntStream values = Arrays.stream(A);
        OptionalInt result = values.max();
        int max = 0;
        if(result.isPresent()) {
        	max = result.getAsInt();
        }
       return max;
	}
	
	private static boolean validateSequencial(int[] A) {
		int max = A[0];
		for(int value: A) {
			if(max <= value) {
				max = value;
			}else return false;			
		}
		return true;
	}
	
	private static int[] getCopy(int[] A, int remove) {
		int[] copy = new int[A.length - 1];
		int cont=0;
		for(int value: A) {
			if(value != remove) {
				copy[cont] = value; 
				++cont;
			}
		}
		return copy;
	}
	
	private static int[] getCopyRemoveIndex(int[] A, int indexToremove) {
		int[] copy = new int[A.length - 1];
		int cont=0;
		int contIndex = 0;
		for(int value: A) {
			if(contIndex != indexToremove) {
				copy[cont] = value; 
				++cont;
			}
			++contIndex;
		}
		return copy;
	}
	
	
	public static int solution(int[] A) {
		
		
		int times =0;
		int[] copy ;
		
		if(validateSequencial(A)) {
			copy = copyFromRepeated(A);
			if(validateSequencial(copy)) {
				++times;
			}
			int contIndex = 0;
			for(int value : A) {
				copy = getCopyRemoveIndex(A, contIndex);
				if(validateSequencial(copy)) {
					++times;
				}
				++contIndex;
			}
			
		} else {
			int max = computeMax(A);
			copy = getCopy(A, max);
			
			if(validateSequencial(copy)) {
				++times;
			}
			
			copy = Arrays.copyOf(A, A.length - 1); 
			if(validateSequencial(copy)) {
				++times;
			}
		}
		
		
		
	   return times;
        
    }

    public static void main(String[] args){
    	 int[] values = {3,4,5,4};
    	 System.out.println(solution(values) );
    	 int[] values2 = {1, 2, 3, 3, 5, 6, 7};
    	 System.out.println(solution(values2));

    }

}
