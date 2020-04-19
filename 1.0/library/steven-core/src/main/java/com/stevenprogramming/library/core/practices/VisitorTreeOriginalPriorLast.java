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


public class VisitorTreeOriginalPriorLast {

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


	public static boolean isZeroParent(int parent, int[][] vector, int cont){
		return parent == vector[cont][0];
	}

	public static int[] getChild(int parent, int[][] vector, int cont){
		int[] values = new int[2];
		if( isZeroParent(parent, vector, cont) ){
			values[0] = vector[cont][1];
			values[1] = 1;
			return values;
		} else {
			values[0] = vector[cont][0];
			values[1] = 0;
			return values;
		}
	}

	public static boolean isParent(int[][] vector, int value, int parent, int init){
		int cont =0;
		if (init>3){
			cont = init-2;
		} else {
			cont = init;
		}
		cont = 1;
		for(; cont < vector.length; cont++){
			if( (init-1) == cont || (vector[cont][0] == value && vector[cont][1] == parent) || (vector[cont][0] == parent && vector[cont][1] == value) ){
				continue;
			} 
			if (vector[cont][0] == value || vector[cont][1]  == value ){
				return true;
			}
		}
		return false;
	}
	
	public static int lookup (int value, int[][] vector, int pos, int result, int c){
		for(int cont=c-1; cont > 0; cont--){
			if(vector[cont][pos] == value){
				return cont;
			}
			
		}
		return result +1;
	}

	public static int getNextInit(int c, int[][] vector, int value, int pos){
		boolean found = false;
		int result = c;
		int cont = c-1;
		
		while ( cont>0 && (vector[cont][pos] == value) ){
				found = true;
				--cont;
			}
		if(found){
			++cont;
			return cont;
		}
		return lookup(value, vector, pos, result, c);
		
	}
	
	static class NodeParent {
		private int parent = -1;
		private int child = -1;
		private NodeParent prev= null;
		public NodeParent(int p, int c, NodeParent node){
			this.parent = p;
			this.child = c;
			prev = node;
		}
		
		public NodeParent getPrev(){
			return prev;
		}
		
		public int getParent(){
			return parent;
		}
		
		public int getChild(){
			return child;
		}
		
	}
	
	static NodeParent lastPrevNode = null;
	
	public static void printParent(NodeParent node){
		if(node == null){
				return ;
		}
		NodeParent temp = node;
		while(temp != null){
			temp = temp.getPrev();
		}
	}
	
	public static boolean validNode(int p, int c, NodeParent node){
		if(node == null){
				return true;
		}
		NodeParent temp = node;
		
		while(temp != null){
			if((temp.getParent() == p && temp.getChild() == c) ||  (temp.getParent() == c && temp.getChild() == p)  ) {
				return false;
			}
			
			temp = temp.getPrev();
		}
		return true;
	}

	public static Tree createTree(Tree nodeParent, int parent, int[][] vector, int init, int depth, int[] v1, int[] v2, NodeParent prevNode ){
		boolean found = false;
		Tree newParent= null;
		for(int cont = init; cont < vector.length; cont++){
			
			if (vector[cont][0] == parent || vector[cont][1]  == parent ){
				found = true;
				int[] childValue = getChild(parent, vector, cont);
				
				if (validNode (parent, childValue[0], lastPrevNode)){
					
					NodeParent nodeParentCustom = null;
					if(isParent(vector, childValue[0], parent, cont+1)){
							if( parent ==1 && cont == 0){
								lastPrevNode = new NodeParent(parent, childValue[0], prevNode);
							} else {
								nodeParentCustom = new NodeParent(parent, childValue[0], lastPrevNode);
								lastPrevNode = nodeParentCustom;
							}
								newParent= createNode( true, v1[childValue[0]-1], v2[childValue[0]-1], depth + 1 );
						} else{
							newParent= nodeParent;
							nodeParentCustom = new NodeParent(parent, childValue[0], lastPrevNode);
							lastPrevNode = nodeParentCustom;
						}
						
						newParent = createTree(newParent, childValue[0], vector, getNextInit(cont, vector, childValue[0], childValue[1]), depth + 1, v1, v2, nodeParentCustom);
						if( newParent != null) {
							((TreeNode)nodeParent).addChild( newParent );						
						}
				}
			}
			if(parent == 1 && (cont+1) == vector.length){
					printParent(lastPrevNode);
			}
		}

		if (found){
			return nodeParent;
		} else {
			Tree child = createNode( false, v1[parent-1], v2[parent-1], depth);
			return child;
		}

	}

    public static Tree solve() {
		getAmount();
        Scanner scanner = new Scanner(System.in);
        int n = getAmount(); 
        
        String line = getValuesV(); 
        int[] v1 = getArrayFromString(line, n);
        line = getColorsV(); 
        int[] v2 = getArrayFromString(line, n);
		int[][] v4 =  getVectorV4(n);
		Tree parent = createNode( true, v1[0], v2[0], 0);
		long startTime = System.currentTimeMillis();
		Tree root = createTree(parent, 1, v4, 0, 0, v1, v2, null);
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		
        return root;
    }

    public static int getAmount(){
		Container v = new Container();
		try{
			Stream<String> stream = Files.lines(Paths.get("amount6.txt"));
			stream.forEach(x -> v.v = Integer.parseInt (x) );
		}catch(Exception e){
		}
		return v.v;
	}

	public static String getValuesV(){
		Container v = new Container();
		try{
			Stream<String> stream = Files.lines(Paths.get("values6.txt"));
			stream.forEach(x -> v.va = x );
		}catch(Exception e){
		}
		return v.va;
	}

	public static String getColorsV(){
		Container v = new Container();
		try{
			Stream<String> stream = Files.lines(Paths.get("colors6.txt"));
			stream.forEach(x -> v.c = x );
		}catch(Exception e){
		}
		return v.c;
	}

	public static int[][] getVectorV4(int amount){
		Container v = new Container();
		try{

			v.v4 = new int[amount][2];
			Stream<String> stream = Files.lines(Paths.get("vector6.txt"));
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
