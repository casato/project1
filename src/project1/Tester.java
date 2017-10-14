package project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {

   @Test
   public void testTripDistance() {
      Trip t = new Trip(4, 3, 0, 0);
      assertEquals(t.distance(), (double)5, 0.0000001);
   }
   
   @Test
   public void testTripToString()
   {
      Trip t = new Trip(0, 0, 3, 4);
      System.out.println(t);
      assertEquals(t.toString(), "Trip from (0, 0) to (3, 4)");
   }

}
