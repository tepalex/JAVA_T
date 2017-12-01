package ru.stqa.pft.homework2;

public class Point {

  public static void main(String[] args) {

    //Task 1.
    double x1 = 0;
    double y1 = 0;
    double x2 = 3;
    double y2 = 4;

    System.out.println("The distance between points P1" + "(" + x1 + "," + y1 + ") and P2" + "(" + x2 + "," + y2 + ") is " + distance(x1, y1, x2, y2));

    //Task 2.
    Coordinates c = new Coordinates(0, 0, 3, 4);
    System.out.println("The distance between points P1" + "(" + c.x1 + "," + c.y1 + ") and P2" + "(" + c.x2 + "," + c.y2 + ") is " + c.distance());
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }

}


