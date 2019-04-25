package com.company;

import java.util.ArrayList;

public class Main {

    // Mændge af iterationer, bruges til BEGGE for loops
    private static final int iterationer = 1000000;

    // De farver der kan vælges
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };


    public static void main(String[] args) {

        // Lister som de oprettede objekter ligges i
        ArrayList<Shape> tri = new ArrayList<>();
        ArrayList<Shape> triFly = new ArrayList<>();

        long startTime = System.nanoTime();

        //flyweight
        for (int i = 0; i < iterationer ; i++) {

            //Tester om farven allerede er oprettet, hvis den er genbruges farve objektet.
            Triangle triangle = (Triangle)TriangleFactory.getTriangle(getRandomColor());
            triangle.setA(getRandomInt());
            triangle.setB(getRandomInt());
            triangle.setC(getRandomInt());

            //Printer objekt ID på farveobjektet
            // >>> de er ens med flyweight <<<
            //System.out.println(System.identityHashCode(triangle.getColor()));

            triFly.add(triangle);

            //Spam om id på de respektive trekanter
            //System.out.println("Triangle ID:" + System.identityHashCode(triangle));       ID
            //triangle.tell();                                                              ATTRIBUTTER
        }

        long endTime = System.nanoTime();

        long flyWeight = endTime - startTime;

        long startTimeNorm = System.nanoTime();

        for (int i = 0; i < iterationer ; i++) {

            //"normal" oprettelse
            Triangle triangle2 = new Triangle(getRandomColor());
            triangle2.setA(getRandomInt());
            triangle2.setB(getRandomInt());
            triangle2.setC(getRandomInt());

            tri.add(triangle2);

            //Printer objekt ID på farveobjektet
            // >>> de er forskellige med "normalt" <<<
            //System.out.println(System.identityHashCode(triangle2.getColor()));

            //spam om trekanterne
            //System.out.println("Triangle 2 ID:" + System.identityHashCode(triangle2));
            //triangle2.tell();

        }

        long endTimeNorm = System.nanoTime();

        long normalt = endTimeNorm - startTimeNorm;




        System.out.println();
        System.out.println("Farver i hashmap : " + TriangleFactory.getTriangleMap().size());
        System.out.println();
        System.out.println("Trekanter oprettet \"normalt\": \t\t\t" + tri.size());
        System.out.println("Trekanter oprettet med flyweight : \t\t" + triFly.size());
        System.out.println();
        System.out.println("Tid for normalt: \t\t\t" + normalt);
        System.out.println("Tid for flyweight: \t\t\t" + flyWeight);


    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomInt() {
        return (int)(Math.random()*100 );
    }

}
