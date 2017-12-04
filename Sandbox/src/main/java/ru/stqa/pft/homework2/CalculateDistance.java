package ru.stqa.pft.homework2;

public class CalculateDistance {

  public static void main(String[] args) {
    Point p0 = new Point (0.0, 0.0);
    Point p1 = new Point (3.0, 4.0);

    System.out.println("The distance between points P1" + "(" + p0.x + "," + p0.y + ") and P2" + "(" + p1.x + "," + p1.y + ") is " + p0.distance(p1));
  }
}
