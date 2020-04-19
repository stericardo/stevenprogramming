package com.stevenprogramming.library.core.practices;


import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;


public class VisitorTreeVersionUnidireccional {
  
	public static int[] getArrayFromString(String line, int capacity){
		int pos = 0;
		int[] result = new int[capacity];
		String[] values = line.split(" ");
		for(String value : values){
			result[pos]= Integer.parseInt(value);
			++pos;
		}
		return result;
	}
	
	public static int[] initArray(int capacity){
		int[] result = new int[capacity];
		for(int cont=0; cont < capacity; cont++){
			result[cont] = 0;
		}
		return result;
	}
	
	public static Tree createNode(boolean parent, int value, int c, int depth){
		Color color = Color.GREEN;
		if(c == 0){
			color = Color.RED;
		}
		if(parent){
			return new TreeNode(value, color, depth);
		}
		return new TreeLeaf(value, color, depth);
	}
	
	public static boolean isParent(int[] v3, int pos){
		System.out.println("IsParent function >>> pos " + pos + " v3 length" + v3.length + " ==1: " + v3[pos]);
		return v3[pos] == 1;
	}
	
	public static boolean foundDirect(int pos, int[][] v4){
		for(int c = 0;c<v4.length; c++){
			if(pos == v4[c][1]){
				System.out.printf("Founded Valor %d ValueSearch: %d COntador %d  %n", v4[c][1] , pos, c);
				return true;
			}
		}
		return false;
	}
	
	public static Tree createTree(int[] v1, int[] v2, int[][] v4, 
		int capacity){
		int temp = 1;
		int depth = 0;
		int[] v3 = fillV3(capacity, v4);
		
		Tree root = null;
		Tree parent =null;
		Tree child = null;
		for(int cont=0; cont< capacity-1; cont++){
			int parentIntNode = v4[cont][0];
			int childIntNode = v4[cont][1];
			
			if(cont == 0){
				parent = createNode(isParent(v3,parentIntNode-1 ), v1[parentIntNode -1 ], v2[parentIntNode -1 ], depth);
				child = createNode(isParent(v3,childIntNode -1 ), v1[childIntNode -1 ], v2[childIntNode -1 ], depth + 1);
				temp = parentIntNode;
				root = parent;
				((TreeNode)parent).addChild(child);
			} else {
				 if ( temp != parentIntNode  ){				
				++depth;
			} 
			
			boolean isParentNode = isParent(v3,childIntNode -1);
			
			if(isParentNode){
						System.out.println("ParentcURRENT" + parentIntNode + " New Parent  " + (childIntNode -1) + " Value " + parent.getValue());
						foundDirect(childIntNode -1, v4);
						child = createNode( isParentNode, v1[childIntNode -1 ], v2[childIntNode -1 ], depth + 1);
						((TreeNode)parent).addChild(child);
						parent = child;
					
				
				
			} else {
				child = createNode( isParentNode, v1[childIntNode -1 ], v2[childIntNode -1 ], depth + 1);
				((TreeNode)parent).addChild(child);
			}
			
		}
			
			
		}
		
		return root;
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
			//System.out.println("v3.length " + v3.length +"Parent " + v3[c] + " Parent " + v4[c][0] + " Node " + v4[c][1]  );
		}
		
		return v3;
	}
	
    public static Tree solve() {
		getAmount();
        Scanner scanner = new Scanner(System.in);
        int n = getAmount(); //Integer.parseInt(scanner.nextLine());
        //int[][] v4 = new int[n][2];
        String line = getValuesV(); //scanner.nextLine();
        int[] v1 = getArrayFromString(line, n);
        line = getColorsV(); //scanner.nextLine();
        
        int[] v2 = getArrayFromString(line, n);
        /*
        for(int cont=0; cont < (n-1); cont++){
			line = scanner.nextLine();
			int[] valuesNode = getArrayFromString(line, 2);
			v4[cont][0] = valuesNode[0];
			v4[cont][1] = valuesNode[1];
		}*/
		
		int[][] v4 =  getVectorV4(n);
        
        return createTree(v1, v2, v4, n);
    }
    
    public static int getAmount(){
		Container v = new Container();
		try{
			Stream<String> stream = Files.lines(Paths.get("amount.txt"));
			stream.forEach(x -> v.v = Integer.parseInt (x) );
		}catch(Exception e){
		}
		return v.v;
	}
	
	public static String getValuesV(){
		Container v = new Container();
		try{
			Stream<String> stream = Files.lines(Paths.get("values.txt"));
			stream.forEach(x -> v.va = x );
		}catch(Exception e){
		}
		return v.va;
	}
	
	public static String getColorsV(){
		Container v = new Container();
		try{
			Stream<String> stream = Files.lines(Paths.get("colors.txt"));
			stream.forEach(x -> v.c = x );
		}catch(Exception e){
		}
		return v.c;
	}
	
	public static int[][] getVectorV4(int amount){
		Container v = new Container();
		try{
			
			v.v4 = new int[amount][2];
			Stream<String> stream = Files.lines(Paths.get("vector.txt"));
			stream.forEach((String x) -> {
			
			String[] vec = x.split(" ");
			v.v4[v.cont][0] = Integer.parseInt(vec[0]);
			v.v4[v.cont][1] = Integer.parseInt(vec[1]);
			++v.cont;
		}
			);
		}catch(Exception e){
		}
		return v.v4;
	}
	


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();


      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
    	
    	
    	
	}
	
	static class Container {
		public int v=0;	
		public String va; 
		public String c; 
		public int[][] v4;
		public int cont =0;
	}
}
