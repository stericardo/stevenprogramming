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

	public static Node getNode2(Node nodeParent, int parent, int[][] vector, int init){
		//int cont = init;
		boolean found = false;
		System.out.printf("%nStart parent: " + parent + " Node Parent " +nodeParent);
		Node newParent= null;
		for(int cont = init; cont < vector.length; cont++){
			//System.out.printf("%nParent %d, cont %d ", parent, cont);
			//System.out.printf("%n    BEFORE FOUND Parent %d, cont %d, vector[0][1]=%d, vector[1][0]=%d ",
			//parent, cont, vector[cont][0], vector[cont][1]);
			if (vector[cont][0] == parent || vector[cont][1]  == parent ){
				found = true;
				System.out.printf("%n    **********   ******Parent %d, cont %d, vector[0][1]=%d, vector[1][0]=%d ", parent, cont, vector[cont][0], vector[cont][1]);
				int childValue = getChild(parent, vector, cont);

				if(isParent(vector, childValue,cont+1)){
					newParent= new Parent( String.valueOf( childValue ) );
				} else{
					newParent= nodeParent;
				}
				//Node newParent= new Parent( childValue );
				//Node child = new Child( childValue );
				newParent = getNode2(newParent, childValue, vector, cont+1);
				nodeParent.add( newParent );
				//System.out.println("\n\n\t\t\t ####### Return Node Parent:: " + nodeParent + "\n New " + newParent);
				for (Node c: ((Parent)nodeParent).children){
						//			System.out.print(" *Print ParentParemeter " + parent+ " Node " + c);
				}
			}
		}
		if (found){
			//System.out.println("\n----Returning Parent found " + parent + " Node Parent " + nodeParent );
			return nodeParent;
		} else {
			Node child = new Child( String.valueOf(parent) );
			//nodeParent.add(child);
			//System.out.println("\n---------Returning Child Part Parent "+ parent+ " newParent> " + nodeParent );
			for (Node c: ((Parent)nodeParent).children){
			//		System.out.print(c);
			}
			return child;
		}

	}

	public static Node getNode(int parent, int[][] vector, int init){
		boolean isParent = false;
		Node nodeParent= null;
		int childInt = 0;

		for(int cont=init; cont<vector.length; cont++){
			//System.out.println("Iterating parent: " + parent + " init " + init);
			if(parent == vector[cont][0] || parent == vector[cont][1]){
				//System.out.println("Iterating parent: " + parent +" init iterating:: " + init +" Cont:: " + cont);
				isParent = true;
				if( nodeParent== null) {
					if( isZeroParent(parent, vector, cont) ){
						System.out.printf("%nCreating isZeroParent %d cont %d Vector[%d][%d]",  parent, cont, vector[cont][0], vector[cont][1]);
						nodeParent= new Parent( String.valueOf ( vector[cont][0] ) );
					} else {
						//System.out.printf("%nCreating NOT isZeroParent %d cont %d vector[0][1]=%d, vector[1][0]=%d",  parent, cont, vector[cont][0], vector[cont][1]);
						nodeParent= new Parent( String.valueOf ( vector[cont][1] ) );
					}
				}

				childInt = getChild(parent, vector, cont);
				Node child = getNode(childInt, vector, init + 1);
				//System.out.printf("%nAddint %d to parent: %d, contador: %d vector[0][1]=%d, vector[1][0]=%d ", childInt, parent, cont, vector[cont][0], vector[cont][1] );
				nodeParent.add(child);
			}
		}
		if( nodeParent== null){
			return new Child( String.valueOf ( parent ) );
		} else {
			return nodeParent;
		}
	}
	public static void main(String[] args) {
		int[][] v= {{1,2}, {1,3}, {3,4}, {3,5}};


		int[][] v2= {{1,2}, {1,3}, {1,6}, {4,2}, {2,5}, {7,6}, {6,8}, {8,9}, {8,10}};

		Node nodeParent = new Parent("1");
		Node node = getNode2(nodeParent, 1, v2, 0);
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
			for (Node c: children){
				sb.append(children);
			}
			return "\nNode-toString\t " + name + " Size children " +children.size() + sb.toString();
		}
	}

	static class Child  extends Node {
		String name;
		public Child(String name){
			this.name = name;
		}
		@Override
		public String toString(){
			return "Child Name " + name;
		}
	}

}
