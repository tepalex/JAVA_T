package ru.stqa.pft.homework2v2.homework2v2Part2;

public class Point {

  public static void main(String[] args) {

    CalculateDistance p1 = new CalculateDistance(0.0, 0.0);
    CalculateDistance p2 = new CalculateDistance(3.0, 4.0);
    System.out.println("The distance between points P1" + "(" + p1.x + "," + p1.y + ") and P2" + "(" + p2.x + "," + p2.y + ") is " + p1.distance(p2));

  }
}
