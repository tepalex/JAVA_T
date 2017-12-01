package ru.stqa.pft.homework2;

public class Coordinates {

  public double x1;
  public double y1;
  public double x2;
  public double y2;

public Coordinates(int x1, int y1, int x2, int y2){
  this.x1=x1;
  this.y1=y1;
  this.x2=x2;
  this.y2=y2;
}
public double distance (){
  return Math.sqrt((this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1));
}
}
