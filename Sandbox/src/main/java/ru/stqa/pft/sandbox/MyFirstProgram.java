package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args) {

	  hello("world");
	  hello("user");
	  hello("alex");

	  Square s = new Square(5);
    System.out.println("Square area with the length of the side " + s.side +" is equal " + area (s));

    Rectangle r = new Rectangle(5,6);

    System.out.println("Rectangle area with the height " + r.height + " and the width " + r.width + " is equal " + area (r));  }

	  public static void hello(String somebody) {
      System.out.println("Hello " + somebody + "!");
    }

    public static double area(Square s){
      return s.side * s.side;
  }

  public static double area(Rectangle r){
      return r.height*r.width;
  }
  }
