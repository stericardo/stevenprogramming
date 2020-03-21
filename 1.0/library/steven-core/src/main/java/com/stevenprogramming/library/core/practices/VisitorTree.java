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

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	int result =0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {

    }

    public void visitLeaf(TreeLeaf leaf) {
		result+= leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	long result =1;
    
    public int getResult() {
      	return (int) result;
    }

    public void visitNode(TreeNode node) {

      	if(node.getColor().equals(Color.RED)){

			result = (result * node.getValue()) % 1000000007;
		}
    }

    public void visitLeaf(TreeLeaf leaf) {
      	if(leaf.getColor().equals(Color.RED)){
			result = (result * leaf.getValue()) % 1000000007 ;
		}
	}
}

class FancyVisitor extends TreeVis {
	int result =0;
	int greenSum = 0;
    public int getResult() {
		return Math.abs(result-greenSum);
    }

    public void visitNode(TreeNode node) {
		if(node.getDepth() == 0){
			result+= result + node.getValue();
		} else if(node.getDepth() % 2 == 0){
			result = result + node.getValue();
		}
    }

    public void visitLeaf(TreeLeaf leaf) {

    	if(leaf.getColor().equals(Color.GREEN)){
			greenSum = greenSum + leaf.getValue();
		}
    }
}

public class VisitorTree {

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

	public static boolean isParent(int[][] vector, int value, int init){
		for(int cont = init; cont < vector.length; cont++){
			if (vector[cont][0] == value || vector[cont][1]  == value ){
				return true;
			}
		}
		return false;
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
		return result+1;
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
				if (!validNode (parent, childValue[0], prevNode)){
					continue;
				}
				NodeParent nodeParentCustom = null;
				if(isParent(vector, childValue[0],cont+1)){
					nodeParentCustom = new NodeParent(parent, childValue[0], prevNode);
					newParent= createNode( true, v1[childValue[0]-1], v2[childValue[0]-1], depth + 1 );
				} else{
					newParent= nodeParent;
					nodeParentCustom = prevNode;
				}
				newParent = createTree(newParent, childValue[0], vector, getNextInit(cont, vector, childValue[0], childValue[1]), depth + 1, v1, v2, nodeParentCustom);
				((TreeNode)nodeParent).addChild( newParent );
			}
		}

		if (found){
			return nodeParent;
		} else {
			Tree child = createNode( false, v1[parent-1], v2[parent-1], depth);
			return child;
		}

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

		Tree parent = createNode( true, v1[0], v2[0], 0);

        return createTree(parent, 1, v4, 0, 0, v1, v2, null);
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
      	System.out.println("\n");
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
