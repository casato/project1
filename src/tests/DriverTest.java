package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project1.Driver;
import project1.Location;
import project1.Passenger;
import project1.Trip;

public class DriverTest {



   @Test
   public void testGetFare() {
      Driver driver1 = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (10,0));
      Passenger p1 = new Passenger("Jesse", "McCree", (float)130.00, new Location(0,0));

      assertEquals(driver1.getFare(new Trip(new Location(0,0), new Location(10,0)), p1), 20,0.00001);   }

   @Test
   public void testToString() {
      Driver driver1 = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (5,4));
      String s = "Joe,Driver,Camry,100.0,3.5,5,4\n";
      assertEquals(driver1.toString(), s);
   }

}
