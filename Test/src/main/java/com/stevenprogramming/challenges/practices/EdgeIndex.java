package com.stevenprogramming.challenges.practices;

import java.util.Arrays;

public class EdgeIndex {

    MyArray[] arr;

    public EdgeIndex( int n ) {
        arr = new MyArray[n];
        for( int i=0; i<n; i++)
            arr[i] = new MyArray();
    }

    public void set(int left, int right ) {
        arr[left].add( right );
        arr[right].add( left );
    }

    public void sort() {
        for( MyArray ma : arr ) {
            ma.sort();
        }
    }

    public int[] getChilds( int row ) {

        int[] childs = Arrays.copyOf( arr[row].getArray(), arr[row].getArray().length );
        arr[row] = null;
        for( int c : childs ) {
            if( c<0 ) continue;
            arr[c].remove( row );
        }
        return childs;
    }


    public boolean hasChilds( int row ) {
        return arr[row].hasChilds();
    }
}

