package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project1.Location;

public class LocationTest {


   @Test
   public void testDistance() {
      Location l1 = new Location(0,0);
      Location l2 = new Location(3,4);
      
      assertEquals(5, l1.distance(l1, l2), 0.0001);
   }

   @Test
   public void testToString() {
      Location l1 = new Location(12,34);
      assertEquals(l1.toString(), "(12, 34)");
   }

   @Test
   public void testToStringNoParentheses() {
      Location l1 = new Location(12,34);
      assertEquals(l1.toStringNoParentheses(), "12,34");
   }

   @Test
   public void testRandomLocation() {
      for(int i = 0; i < 100; i++)
      {
         Location l1 = Location.randomLocation();
         
         System.out.println(l1);
      }
   }

}
