package com.company;

public class Triangle implements Shape {

    private String color;
    private int a, b, c;

    public Triangle(String color, int a, int b, int c) {
        this.color = color;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(String color) {
        this.color = color;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void tell(){
        System.out.println("Triangle - color:" + color + " a:" + a + " b:" + b + " c:" + c);
    }
}
