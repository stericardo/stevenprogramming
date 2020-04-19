package com.stevenprogramming.library.core.practices;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class VisitorTreePerformance {

    public static int[] getArrayFromString(String line, int capacity) {
        int pos = 0;
        int[] result = new int[capacity];
        String[] values = line.split(" ");
        for (String value : values) {
            //mejor dejar en una sola linea asi --> result[pos++] = Integer.parseInt( value );
            result[pos] = Integer.parseInt(value);
            ++pos; //esta line ya no seria necesaria
        }
        return result;
    }

    public static Tree createNode(boolean parent, int value, int c, int depth) {
        Color color = Color.GREEN;
        if (c == 0) {
            color = Color.RED;
        }
        if (parent) {
            return new TreeNode(value, color, depth);
        }

        return new TreeLeaf(value, color, depth);
    }

    public static boolean isZeroParent(int parent, int[][] vector, int cont) {
        return parent == vector[cont][0];
    }

    public static int[] getChild(int parent, int[][] vector, int cont) {
        int[] values = new int[2];
        if (isZeroParent(parent, vector, cont)) {
            values[0] = vector[cont][1];
            values[1] = 1;
            return values;
        } else {
            values[0] = vector[cont][0];
            values[1] = 0;
            return values;
        }
    }

    public static boolean isParent(int[][] vector, int value, int parent, int init) {
        int cont = 0;
        if (init > 3) {
            cont = init - 2;
        } else {
            cont = init;
        }
        cont = 1;
        //Este es l;a parte mas ineficiente; pensare en como implementarlo con array para no tener que recorrer todo array cada vez
        for (; cont < vector.length; cont++) {
            if ((init - 1) == cont || (vector[cont][0] == value && vector[cont][1] == parent) || (vector[cont][0] == parent && vector[cont][1] == value)) {
                continue;
            }
            if (vector[cont][0] == value || vector[cont][1] == value) {
                return true;
            }
        }
        return false;
    }

    public static int lookup(int value, int[][] vector, int pos, int result, int c) {
        //ineficiente; tratare de ver como mejorarlo
        for (int cont = c - 1; cont > 0; cont--) {
            if (vector[cont][pos] == value) {
                return cont;
            }

        }
        return result + 1;
    }

    public static int getNextInit(int c, int[][] vector, int value, int pos) {
        boolean found = false;
        int result = c;
        int cont = c - 1;

        while (cont > 0 && (vector[cont][pos] == value)) {
            found = true;
            --cont;
        }
        if (found) {
            ++cont;
            return cont;
        }
        return lookup(value, vector, pos, result, c);

    }

    static class NodeParent {

        private int parent = -1;

        private int child = -1;

        private NodeParent prev = null;

        public NodeParent(int p, int c, NodeParent node) {
            this.parent = p;
            this.child = c;
            prev = node;
        }

        public NodeParent getPrev() {
            return prev;
        }

        public int getParent() {
            return parent;
        }

        public int getChild() {
            return child;
        }

    }

    static NodeParent lastPrevNode = null;

    public static void printParent(NodeParent node) {
        if (node == null) {
            return;
        }
        NodeParent temp = node;
        while (temp != null) {
            temp = temp.getPrev();
        }
    }

    public static boolean validNode(int p, int c, NodeParent node) {
        if (node == null) {
            return true;
        }
        NodeParent temp = node;

        while (temp != null) {
            if ((temp.getParent() == p && temp.getChild() == c) || (temp.getParent() == c && temp.getChild() == p)) {
                return false;
            }

            temp = temp.getPrev();
        }
        return true;
    }

    static class SortedArrayTree implements Comparable<SortedArrayTree> {

        public int parent = 0;
        public int child = 0;

        public SortedArrayTree(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }

        public int compareTo(SortedArrayTree sort) {
            int result = this.parent - sort.parent;
            if (result < 0) {
                return -1;
            } else if (result == 0) {
                return this.child - sort.child;
            }
            return result;
        }

    }

    public static SortedArrayTree[] getArrayObject(int[][] vector) {
        SortedArrayTree[] o = new SortedArrayTree[vector.length];
        for (int cont = 0; cont < vector.length; cont++) {
            o[cont] = new SortedArrayTree(vector[cont][0], vector[cont][1]);
        }
        return o;
    }

    public static int[][] getVectorSorted(SortedArrayTree[] o) {
        int[][] vectorSorted = new int[o.length][2];
        for (int cont = 0; cont < o.length; cont++) {
            vectorSorted[cont][0] = o[cont].parent;
            vectorSorted[cont][1] = o[cont].child;
        }
        return vectorSorted;
    }

    static class ContainerNode {

        public int key;
        public int kParent;
        public Tree node;

        public ContainerNode(int k, int kP, Tree n) {
            key = k;
            node = n;
            kParent = kP;
        }
    }

    public static ContainerNode getObject(List<ContainerNode> parents, int a, int b) {
        for (ContainerNode parent : parents) {
            if (parent.key == a || parent.key == b) {
                return parent;
            }
        }
        return null;
    }

    public static Tree getChild(boolean parent, ContainerNode lastContainerNode, int a, int b, int depth, int[] v1, int[] v2) {
        Tree child = null;
        if (lastContainerNode.key == b) {
            child = createNode(parent, v1[a], v2[a], depth);
        } else {
            child = createNode(parent, v1[b], v2[b], depth);
        }
        return child;
    }

    public static ContainerNode lookupParent(List<ContainerNode> parents, int key) {
        for (ContainerNode parent : parents) {
            if (parent.key == key) {
                return parent;
            }
        }
        return null;
    }

    public static void printChildren(Tree node) {
    	TreeNode treeNode = (TreeNode) node;
        for (int cont = 0; cont < treeNode.children.size(); cont++) {
            System.out.println("PRINTCHILDREN " +  treeNode.children.get(cont).getValue());
        }
    }

    public static Tree reassignNewParent(List<ContainerNode> parents, Tree child, ContainerNode lastContainerNode,
            int a, int b, int depth, int[] v1, int[] v2) {
        System.out.printf("A%d  B%d  Key %d%n", a, b, lastContainerNode.key);
        for (ContainerNode parent : parents) {
            System.out.printf("START ------- reassign Key %d Parent %d LastContainer Key %d LastContainer KeyParent %d%n", parent.key, parent.kParent,
                    lastContainerNode.key, lastContainerNode.kParent);
        }
        ContainerNode parentFound = lookupParent(parents, lastContainerNode.kParent);
        printChildren(parentFound.node);
        ((TreeNode) parentFound.node).children.remove(child);

        System.out.printf("**********%n");
        printChildren(parentFound.node);
        child = getChild(true, lastContainerNode, a, b, depth, v1, v2);
        //parents.add(new ContainerNode(lastContainerNode.key, lastContainerNode.kParent, child));
        for (ContainerNode parent : parents) {
            System.out.printf("End reassign Key %d Parent %d %n", parent.key, parent.kParent);
        }
        ((TreeNode) parentFound.node).addChild(child);
        System.out.printf("**********%n");
        printChildren(parentFound.node);
        return child;
    }

    public static boolean validateParent(ContainerNode lastContainerNode) {
        Tree node = lastContainerNode.node;
        if (node instanceof TreeNode) {
            return true;
        }
        return false;
    }

    public static Tree createTree(Tree nodeParent, int parent, int[][] vector, int init, int[] v1, int[] v2, NodeParent prevNode) {
        Tree root = null;
        Tree child = null;
        List<ContainerNode> parents = new ArrayList<>();
        int cont = 0;
        int depth = 1;
        while (cont < vector.length) {
            System.out.printf(" Vector vector[%d][%d] = %d %n", cont, 0, vector[cont][0]);
            ++cont;
        }

        cont = 0;
        root = createNode(true, v1[cont], v2[cont], 0);
        parents.add(new ContainerNode(1, 0, root));
        while (vector[cont][0] == 1) {
            child = createNode(false, v1[cont], v2[cont], depth);
            parents.add(new ContainerNode(vector[cont][1], 1, child));
            ((TreeNode) root).addChild(child);
            ++cont;
        }
        int tmp = 0;
        while (cont < vector.length) {
            System.out.printf(" WHILW INIT vector[%d][%d] = %d vector[%d][%d] = %d %n", cont, 0, vector[cont][0], cont, 1, vector[cont][1]);
            depth += 1;
            tmp = vector[cont][0];
            boolean first = true;
            boolean flatParent = true;
            ContainerNode lastContainerNode = null;
            int b = 0;
            while (tmp == vector[cont + 1][0] || tmp == vector[cont][0]) {
                if (first) {
                    first = false;
                    b = vector[cont][1];
                    lastContainerNode = getObject(parents, tmp, b);
                    if (!validateParent(lastContainerNode)) {
                        System.out.println("Reassign FIRST ** ");
                        child = reassignNewParent(parents, child, lastContainerNode, tmp, b, depth, v1, v2);
                        lastContainerNode = getObject(parents, tmp, b);
                        System.out.println("Finish FIRST VALIDATE PARENT " + lastContainerNode.key + " " + lastContainerNode.kParent);
                        System.out.printf("vector[%d][0] value %d value %d cont %d valueNode %d  Container Key %d ParentKey%d %d%n", cont, vector[cont][0],vector[cont][1],  cont ,
                        lastContainerNode.node.getValue(), lastContainerNode.key, lastContainerNode.kParent, b, tmp);
                    } else {
                    	child = getChild(false, lastContainerNode, tmp, b, depth, v1, v2);
                   	 	System.out.printf("vector[%d][0] value %d cont %d valueNode %d  Container Key %d ParentKey%d %n", cont, vector[cont][0], cont ,
                    	lastContainerNode.node.getValue(), lastContainerNode.key, lastContainerNode.kParent);
                    	((TreeNode) lastContainerNode.node).addChild(child);
					}
                } else {
                    if (flatParent) {
                        flatParent = false;
                        System.out.println("Reassign flatParent ");
                        reassignNewParent(parents, child, lastContainerNode, tmp, b, depth, v1, v2);
                        //((TreeNode) lastContainerNode.node).children.remove(child);
                        //child = getChild(true, lastContainerNode, tmp, b, depth, v1, v2);
                        //parents.add(new ContainerNode(lastContainerNode.key, child));
                        //((TreeNode) lastContainerNode.node).addChild(child);
                        //lastContainerNode = parents.get(parents.size());
                    }
                    b = vector[cont][1];
                    lastContainerNode = getObject(parents, tmp, b);
                    child = getChild(false, lastContainerNode, tmp, b, depth, v1, v2);
                    ((TreeNode) lastContainerNode.node).addChild(child);
                }

                ++cont;
            }

        }
		TreeNode t = (TreeNode) root;
        System.out.printf(" Root children count %d", t.children.size());
        return root;

    }

    public static Tree solve() {
        getAmount();
        Scanner scanner = new Scanner(System.in);
        int n = getAmount();

        String line = getValuesV();
        int[] v1 = getArrayFromString(line, n);
        line = getColorsV();
        int[] v2 = getArrayFromString(line, n);
        int[][] v4 = getVectorV4(n);

        SortedArrayTree[] o = getArrayObject(v4);
        Arrays.sort(o);
        v4 = getVectorSorted(o);

        Tree parent = createNode(true, v1[0], v2[0], 0);
        long startTime = System.currentTimeMillis();
        Tree root = createTree(parent, 1, v4, 0, v1, v2, null);
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        return root;
    }
    static String PATHROOT = System.getProperty("user.home") + "\\development\\code\\stevenprogramming\\1.0\\library\\steven-core\\src\\main\\java\\com\\stevenprogramming\\library\\core\\practices";

    public static int getAmount() {
        //Para que existe la clase Conteiner? no se esta usando como tal
        Container v = new Container();

        //mal uso del try/catch con streams
        try {
            Stream<String> stream = Files.lines(Paths.get(PATHROOT, "amount2.txt"));
            stream.forEach(x -> v.v = Integer.parseInt(x));
        } catch (Exception e) {
        }
        return v.v;
    }

    public static String getValuesV() {
        //Para que existe la clase Conteiner? no se esta usando como tal
        Container v = new Container();

        //mal uso del try/catch con streams
        try {
            Stream<String> stream = Files.lines(Paths.get(PATHROOT, "values2.txt"));
            stream.forEach(x -> v.va  = x);
        } catch (Exception e) {
        }
        return v.va;
    }

    public static String getColorsV() {
        //Para que existe la clase Conteiner? no se esta usando como tal
        Container v = new Container();
        //mal uso del try/catch con streams
        try {
            Stream<String> stream = Files.lines(Paths.get(PATHROOT, "colors2.txt"));
            stream.forEach(x -> v.c = x);
        } catch (Exception e) {
        }
        return v.c;
    }

    public static int[][] getVectorV4(int amount) {
        //Para que existe la clase Conteiner? no se esta usando como tal
        Container v = new Container();

        //mal uso del try/catch con streams
        try {

            v.v4 = new int[amount - 1][2];
            Stream<String> stream = Files.lines(Paths.get(PATHROOT, "vector2.txt"));
            stream.forEach((String x) -> {

                String[] vec = x.split(" ");
                v.v4[v.cont][0] = Integer.parseInt(vec[0]);
                v.v4[v.cont][1] = Integer.parseInt(vec[1]);
                ++v.cont;
            });
        } catch (Exception e) {
        }
        return v.v4;
    }

    public static void main(String[] args) {
        Tree root = solve();
        /*
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept( vis1 );
        root.accept( vis2 );
        root.accept( vis3 );

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println( res1 );
        System.out.println( res2 );
        System.out.println( res3 );*/

    }

    static class Container {

        public int v = 0;

        public String va;

        public String c;

        public int[][] v4;

        public int cont = 0;
    }
}
