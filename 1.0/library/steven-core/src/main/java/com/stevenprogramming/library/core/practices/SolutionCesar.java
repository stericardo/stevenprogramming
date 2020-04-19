package com.stevenprogramming.library.core.practices;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;




abstract class TreeVis
{

    public abstract int getResult();

    public abstract void visitNode( TreeNode node );

    public abstract void visitLeaf( TreeLeaf leaf );

}

class SumInLeavesVisitor extends TreeVis
{

    private int sum = 0;

    public int getResult()
    {
        return sum;
    }

    public void visitNode( TreeNode node )
    {
        // implement this
    }

    public void visitLeaf( TreeLeaf leaf )
    {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis
{

    long p = 1;

    public int getResult()
    {
        return ( int ) p;
    }

    public void visitNode( TreeNode node )
    {
        if ( node.getColor() == Color.RED )
        {
            p = ( p * node.getValue() ) % 1000000007;
        }
    }

    public void visitLeaf( TreeLeaf leaf )
    {
        if ( leaf.getColor() == Color.RED )
        {
            p = ( p * leaf.getValue() ) % 1000000007;
        }
    }
}

class FancyVisitor extends TreeVis
{

    int sumNonLeafAtEven = 0;

    int sumGreenLeaf = 0;

    public int getResult()
    {
        return Math.abs( sumNonLeafAtEven - sumGreenLeaf );
    }

    public void visitNode( TreeNode node )
    {
        if ( node.getDepth() == 0 || node.getDepth() % 2 == 0 )
        {
            sumNonLeafAtEven += node.getValue();
        }
    }

    public void visitLeaf( TreeLeaf leaf )
    {
        if ( leaf.getColor() == Color.GREEN )
        {
            sumGreenLeaf += leaf.getValue();
        }
    }
}

class Edge
{

    int left;

    int right;
}

class Node extends Tree
{

    List<Integer> childs = new ArrayList<>();

    public Node( int pValue, Color pColor, int pDepth )
    {
        super( pValue, pColor, pDepth );
    }

    @Override
    public void accept( TreeVis pVisitor )
    {
    }

    public boolean isLeaf()
    {
        return this.childs.size() == 0;
    }
}

public class SolutionCesar
{
    static int[] value;

    static int[] color;

    static LinkedList<Edge> queue;

    static Node[] node;

    public static Tree solve() throws FileNotFoundException
    {
        // Read input values
        // Scanner scan = new Scanner( System.in );
        Scanner scan = new Scanner( new FileReader( "/home/cvezga/input06.txt" ) );
        int n = scan.nextInt();
        value = new int[n];
        color = new int[n];
        
        // Read values
        for ( int i = 0; i < n; i++ )
            value[i] = scan.nextInt();
        
        // Read colors
        for ( int i = 0; i < n; i++ )
            color[i] = scan.nextInt();
        
        // Build tree array and root node
        node = new Node[n];
        node[0] = new Node( value[0], getColor( color[0] ), 0 );
        
        // Read edges
        queue = new LinkedList<Edge>();
        for ( int i = 0; i < n - 1; i++ )
        {
            int v1 = scan.nextInt() - 1;
            int v2 = scan.nextInt() - 1;
            Edge edge = new Edge();
            edge.left = v1;
            edge.right = v2;
            if ( ! ( processEdge( edge.left, edge.right ) || processEdge( edge.right, edge.left ) ) )
            {
                queue.add( edge );
            }
        }
        scan.close();

        //Process pending edges 
        processPendingEdgesInQueue();

        // Build tree
        return buildTree( null, node[0] );
    }

    private static Tree buildTree( Tree parent, Node buildNode )
    {
        Tree t;
        if ( buildNode.isLeaf() )
        {
            t = new TreeLeaf( buildNode.getValue(), buildNode.getColor(), buildNode.getDepth() );
        }
        else
        {
            t = new TreeNode( buildNode.getValue(), buildNode.getColor(), buildNode.getDepth() );
        }

        if ( parent != null )
        {
            ( ( TreeNode ) parent ).addChild( t );
        }

        for ( int buildIdx : buildNode.childs )
        {
            buildTree( t, node[buildIdx] );
        }

        return t;
    }

    private static void processPendingEdgesInQueue()
    {
        while ( !queue.isEmpty() )
        {
            Edge edge = queue.removeFirst();
            if ( ! ( processEdge( edge.left, edge.right ) || processEdge( edge.right, edge.left ) ) )
            {
                queue.add( edge );
            }
        }

    }

    private static boolean processEdge( int a, int b )
    {
        // check if parent node exist
        if ( node[a] == null )
            return false;

        Node parent = node[a];
        node[b] = new Node( value[b], getColor( color[b] ), parent.getDepth() + 1 );
        parent.childs.add( b );
        // System.out.println( (a+1)+" -> "+(b+1)+";");

        return true;
    }

    private static Color getColor( int v )
    {
        return v == 0 ? Color.RED : Color.GREEN;
    }

    public static void main( String[] args ) throws FileNotFoundException
    {
        long startTime = System.currentTimeMillis();
        Tree root = solve();
        long endTime = System.currentTimeMillis();
        System.out.println( "That took " + ( endTime - startTime ) + " milliseconds" );


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
        System.out.println( res3 );
    }
}
