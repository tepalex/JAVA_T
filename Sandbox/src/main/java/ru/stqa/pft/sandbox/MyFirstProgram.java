package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args) {

	  hello("world");
	  hello("user");
	  hello("alex");

	  double l = 5;
    System.out.println("Square area with the length of the side " + l +" is equal " + area (l));

    double a = 5;
    double b = 6;

    System.out.println("Rectangle area with the height " + a + " and the width " + b + " is equal " + area ( a, b ));
  }

	  public static void hello(String somebody) {
      System.out.println("Hello " + somebody + "!");
    }

    public static double area(double s){
      return s * s;
  }

  public static double area(double h, double w){
      return h*w;
  }
  }
