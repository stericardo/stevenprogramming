package com.stevenprogramming.library.core.practices;

/**
 *
 * @author steri
 */
public class TreeLeaf extends Tree
{

    public TreeLeaf( int value, Color color, int depth )
    {
        super( value, color, depth );
    }

    public void accept( TreeVis visitor )
    {
        visitor.visitLeaf( this );
    }

    @Override
    public String toString()
    {
        return "L(" + getValue() + "," + getColor() + "," + getDepth() + ")";
    }
}
