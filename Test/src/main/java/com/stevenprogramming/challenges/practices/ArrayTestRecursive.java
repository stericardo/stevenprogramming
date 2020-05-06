package com.stevenprogramming.challenges.practices;

import java.util.*;

public class ArrayTestRecursive{

	public static void initArray(int capacity){

	}

	public static boolean isZeroParent(int parent, int[][] vector, int cont){
		return parent == vector[cont][0];
	}

	public static int getChild(int parent, int[][] vector, int cont){
		if( isZeroParent(parent, vector, cont) ){
			return vector[cont][1];
		} else {
			return vector[cont][0];
		}
	}

	public static boolean isParent(int[][] vector, int value, int init){
		for(int cont = init; cont < vector.length; cont++){
			if (vector[cont][0] == value || vector[cont][1]  == value ){
				return true;
			}
		}
		return false;
	}

	public static Node getNode(Node nodeParent, int parent, int[][] vector, int init){
		boolean found = false;
		Node newParent= null;
		
		for(int cont = init; cont < vector.length; cont++){
			
			if (vector[cont][0] == parent || vector[cont][1]  == parent ){
				found = true;
				int childValue = getChild(parent, vector, cont);

				if(isParent(vector, childValue,cont+1)){
					newParent= new Parent( String.valueOf( childValue ) );
				} else{
					newParent= nodeParent;
				}
				newParent = getNode(newParent, childValue, vector, cont+1);
				nodeParent.add( newParent );
			}
		}
		
		if (found){
			return nodeParent;
		} else {
			Node child = new Child( String.valueOf(parent) );
			return child;
		}

	}

	public static void main(String[] args) {
		int[][] v= {{1,2}, {1,3}, {3,4}, {3,5}};


		int[][] v2= {{1,2}, {1,3}, {1,6}, {4,2}, {2,5}, {7,6}, {6,8}, {8,9}, {8,10}};

		Node nodeParent = new Parent("1");
		Node node = getNode(nodeParent, 1, v2, 0);
		System.out.println(node);
	}

	static class Node{
		void add(Node c){}

	}

	static class Parent extends Node{
		String name;
		public List<Node> children = new ArrayList<>();
		public Parent(String name){
			this.name = name;
		}
		public void add(Node c){
			children.add(c);
		}

		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("\n\t\t\t PRINTING "  + name + " Size: " +children.size() + "\n");
			for (Node c: children){
				//sb.append(children);
			}
			sb.append("\n\t\t\t END END END "+name+" \n");
			return sb.toString();
		}
	}

	static class Child  extends Node {
		String name;
		public Child(String name){
			this.name = name;
		}
		@Override
		public String toString(){
			return " \n>Child Name " + name;
		}
	}

}
