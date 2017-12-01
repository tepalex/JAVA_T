package ru.stqa.pft.homework2v2.homework2v2Part1;

public class Point {

  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    double distance = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    return distance;
  }

  public static void main(String[] args) {

    Point p1 = new Point(0.0, 0.0);
    Point p2 = new Point(3.0, 4.0);
    System.out.println("The distance between points P1" + "(" + p1.x + "," + p1.y + ") and P2" + "(" + p2.x + "," + p2.y + ") is " + Point.distance(p1, p2));

  }
}
