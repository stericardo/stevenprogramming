/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.challenges.practices;

/**
 *
 * @author steven ricardo mendez Brenes
 */
public abstract class Tree
{

    private int value;

    private Color color;

    private int depth;

    public Tree( int value, Color color, int depth )
    {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue()
    {
        return value;
    }

    public Color getColor()
    {
        return color;
    }

    public int getDepth()
    {
        return depth;
    }

    public abstract void accept( TreeVis visitor );

}