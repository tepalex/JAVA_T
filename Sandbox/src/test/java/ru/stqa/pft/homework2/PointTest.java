package ru.stqa.pft.homework2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance (){
    Point p0 = new Point (0.0, 0.0);
    Point p1 = new Point(3.0,4.0);

    Assert.assertEquals(p0.distance(p1), 5.0);
  }

  @Test
  public void testDistance1 (){
    Point p0 = new Point (1.0, 1.0);
    Point p1 = new Point(4.0,5.0);

    Assert.assertEquals(p0.distance(p1), 5.0);
  }

  @Test
  public void testDistance2 (){
    Point p0 = new Point (-1.0, -1.0);
    Point p1 = new Point(2.0,3.0);

    Assert.assertEquals(p0.distance(p1), 5.0);
  }
}
