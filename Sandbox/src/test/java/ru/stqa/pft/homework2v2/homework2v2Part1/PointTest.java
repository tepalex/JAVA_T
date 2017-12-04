package ru.stqa.pft.homework2v2.homework2v2Part1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance (){
    Point p1 = new Point (0.0, 0.0);
    Point p2 = new Point(3.0,4.0);

    Assert.assertEquals(Point.distance(p1, p2), 5.0);
  }

  @Test
  public void testDistance1 (){
    Point p1 = new Point (1.0, 1.0);
    Point p2 = new Point(4.0,5.0);

    Assert.assertEquals(Point.distance(p1, p2), 5.0);
  }

  @Test
  public void testDistance2 (){
    Point p1 = new Point (-1.0, -1.0);
    Point p2 = new Point(2.0,3.0);

    Assert.assertEquals(Point.distance(p1, p2), 5.0);
  }
}
