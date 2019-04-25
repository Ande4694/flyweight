package com.company;

import java.util.HashMap;

public class TriangleFactory {

    private static HashMap triangleMap = new HashMap();

    //tager et trekant objekt og en farve
    public static Shape getTriangle(String color){

        // tester om farven findes i mappet
        Triangle triangle = (Triangle)triangleMap.get(color);

        //hvis ikke den pågældende farve findes vil der blive retuneret "null"
        if (triangle == null){

            //hvis ikke farven fandtes i mappet oprettes der en ny farve og puttes i mappet
            triangle = new Triangle(color);
            triangleMap.put(color, triangle);
            System.out.println("Creating a triangle with color:" + color);
        }

        return triangle;
    }

    public static HashMap getTriangleMap() {
        return triangleMap;
    }
}
