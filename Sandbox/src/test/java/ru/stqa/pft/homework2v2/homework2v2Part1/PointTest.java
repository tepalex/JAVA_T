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
}
