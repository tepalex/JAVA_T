package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args) {

	  hello("world");
	  hello("user");
	  hello("alex");

	  Square s = new Square(5);
    System.out.println("Square area with the length of the side " + s.side +" is equal " + s.area ());

    Rectangle r = new Rectangle(5,6);

    System.out.println("Rectangle area with the height " + r.height + " and the width " + r.width + " is equal " + r.area ());  }

	  public static void hello(String somebody) {
      System.out.println("Hello " + somebody + "!");
    }

  }
