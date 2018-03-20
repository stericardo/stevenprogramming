package com.stevenprogramming.library.aem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steven.mendez
 * @since Oct 19 2017
 * @version 1.0
 * 
 * Exercise 21
 * 
 */
public class TestPolygon {

    List<ValuesCollection> valuesIntersect = new ArrayList<>();

    public static void main(String[] args) {
        //Input:
        //polygonSource = {[0,0], [1,0], [2,0], [0,1], [0,2], [2,2]}
        Integer[][] polygonSourceValues = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {0, 2}, {2, 2}};
        //polygonsTarget = {[ [3,2], [2,2], [2,3], [3,3] ], [ [0,1], [1,0], [0,0] ]        }
        Integer[][] polygonsTargetValues = {{3, 2}, {2, 2}, {2, 3}, {3, 3}, {0, 1}, {1, 0}, {0, 0}};
        //Output:
        //Polygon intersects at[2,2] and[0 ,0] 
        TestPolygon t = new TestPolygon();
        int cont = 0;
        for (Integer[] polygonSourceValue : polygonSourceValues) {
            for (Integer[] polygonsTargetValue : polygonsTargetValues) {
                if (polygonSourceValue[0] == polygonsTargetValue[0] && polygonSourceValue[1] == polygonsTargetValue[1] &&
                        polygonSourceValue[0] == polygonSourceValue[1]) {
                    t.valuesIntersect.add(new ValuesCollection(polygonSourceValue[0], polygonSourceValue[1]));
                    ++cont;
                }
            }
        }

    }

}
