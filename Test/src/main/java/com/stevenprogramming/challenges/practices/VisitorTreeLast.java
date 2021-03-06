package com.stevenprogramming.challenges.practices;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class VisitorTreeLast
{

    public static int[] getValuesFromString( String line, int capacity )
    {
        int pos = 0;
        int[] result = new int[capacity];
        String[] values = line.split( " " );
        for ( String value : values )
        {
            result[pos++] = Integer.parseInt( value );
        }
        return result;
    }

    public static Color[] getColorsFromString( String line, int capacity )
    {
        int pos = 0;
        Color[] result = new Color[capacity];
        String[] values = line.split( " " );
        for ( String value : values )
        {
            result[pos++] = Integer.parseInt( value ) == 0 ? Color.RED : Color.GREEN;
        }
        return result;
    }

    public static void createTree( TreeNode nodeParent, int parent, EdgeIndex index, int[] values, Color[] colors )
    {
        for ( int childIndex : index.getChilds( parent ) )
        {
            if ( childIndex == -1 )
                continue;

            Tree node;
            if ( index.hasChilds( childIndex ) )
            {
                node = new TreeNode( values[childIndex], colors[childIndex], nodeParent.getDepth() + 1 );
                createTree( ( TreeNode ) node, childIndex, index, values, colors );
            }
            else
            {
                node = new TreeLeaf( values[childIndex], colors[childIndex], nodeParent.getDepth() + 1 );
            }

            nodeParent.addChild( node );
        }
    }

    public static Tree solve()
    {
        // Scanner scanner = new Scanner( System.in );
        int n = getAmount();
        int[] values = getValuesFromString( getLine( "values.txt" ), n );
        Color[] colors = getColorsFromString( getLine( "colors.txt" ), n );
        EdgeIndex index = getVectorV4( n );
        TreeNode root = new TreeNode( values[0], colors[0], 0 );
        long startTime = System.currentTimeMillis();
        createTree( root, 0, index, values, colors );
        long endTime = System.currentTimeMillis();
        System.out.println( "That took " + ( endTime - startTime ) + " milliseconds" );

        return root;
    }

    public static int getAmount()
    {
        return Integer.parseInt( getLine( "amount.txt" ) );
    }

    public static String getLine( String source )
    {
        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get( source ) ))
        {
            stream.forEach( sb::append );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static EdgeIndex getVectorV4( int n )
    {

        EdgeIndex index = new EdgeIndex( n );
        try (Stream<String> stream = Files.lines( Paths.get( "vector.txt" ) ))
        {
            stream.forEach( ( String x ) -> {
                String[] vec = x.split( " " );
                int left = Integer.parseInt( vec[0] );
                int right = Integer.parseInt( vec[1] );
                index.set( left - 1, right - 1 );
            } );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        index.sort();

        return index;
    }

    public static void main( String[] args )
    {
        Tree root = solve();

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
