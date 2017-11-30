package ru.stqa.pft.homework2;

public class Point {

  public static void main(String[] args) {

    //Task 1.
    int x1 = 0;
    int y1 = 0;
    int x2 = 3;
    int y2 = 4;

    System.out.println("The distance between points P1" + "(" + x1 + "," + y1 + ") and P2" + "(" + x2 + "," + y2 + ") is " + distance(x1, y1, x2, y2));

    //Task 2.
    Coordinates c = new Coordinates(0, 0, 3, 4);
    System.out.println("The distance between points P1" + "(" + c.x1 + "," + c.y1 + ") and P2" + "(" + c.x2 + "," + c.y2 + ") is " + c.distance());
  }

  public static double distance(int x1, int y1, int x2, int y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }

}


