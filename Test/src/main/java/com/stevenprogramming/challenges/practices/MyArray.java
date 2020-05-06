package com.stevenprogramming.challenges.practices;

import java.util.Arrays;

public class MyArray {


        private int[] arr;
        private int endIdx=-1;
        private int childCount;

    public MyArray() {
        arr = new int[10];
        init(arr);
    }

        private void init( int[] arr ) {
        for( int i=endIdx+1; i<arr.length; i++)
            arr[i] = -1;
    }

        public void add( int value ) {
        endIdx++;
        childCount++;
        if( endIdx >= arr.length ) {
            int[] newArr = new int[ endIdx*2 ];
            init(newArr);
            System.arraycopy( arr, 0, newArr, 0, arr.length );
            arr = newArr;
        }
        arr[endIdx] = value;
    }

        public void sort() {
        Arrays.parallelSort( arr );
    }

        public void remove( int value ) {
        if( value == -1 ) return;
        int idx = Arrays.binarySearch( arr, value );
        if( idx > -1 ) {
            arr[idx] = -1;
            childCount--;
            Arrays.parallelSort( arr );
        }
    }

        public int[] getArray() {
        return this.arr;
    }

        public int getIndex( int value )
        {
            return Arrays.binarySearch( arr, value );
        }

        public boolean hasChilds() {
        return this.childCount > 0;
    }
    }

