package ru.stqa.pft.homework2v2.homework2v2Part2;

public class CalculateDistance {

  public double x;
  public double y;

  public CalculateDistance(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(CalculateDistance p1, CalculateDistance p2) {
    double distance = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    return distance;
  }

}

