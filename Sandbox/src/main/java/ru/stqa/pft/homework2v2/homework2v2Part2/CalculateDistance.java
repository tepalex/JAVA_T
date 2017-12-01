package ru.stqa.pft.homework2v2.homework2v2Part2;

public class CalculateDistance {

  public double x;
  public double y;

  public CalculateDistance(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(CalculateDistance p1) {
    double distance = Math.sqrt((this.x - p1.x) * (this.x - p1.x) + (this.y - p1.y) * (this.y - p1.y));
    return distance;
  }
}

