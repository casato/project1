package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import project1.Dispatch;
import project1.Driver;
import project1.Location;
import project1.Passenger;
import project1.Trip;

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
      assertEquals(t.toString(), "Trip from (0, 0) to (3, 4)");
   }
   

}
