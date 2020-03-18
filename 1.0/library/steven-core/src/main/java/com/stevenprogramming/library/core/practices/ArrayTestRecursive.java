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
						nodeParent= new Parent( String.valueOf ( vector[cont][0] ) );
					} else {
						nodeParent= new Parent( String.valueOf ( vector[cont][1] ) );
					}
				}

				childInt = getChild(parent, vector, cont);
				Node child = getNode(childInt, vector, init + 1);
				System.out.printf("%nAddint %d to parent: %d, contador: %d V[%d][%d] ", childInt, parent, cont, vector[cont][0], vector[cont][1] );
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

		Node node = getNode(1, v2, 0);
		System.out.println(node);
	}

	static class Node{
		void add(Node c){}

	}

	static class Parent extends Node{
		String name;
		List<Node> children = new ArrayList<>();
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
			//	sb.append(children);
			}
			return "\n\nName " + name + " Size children " +children.size() + sb.toString();
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
