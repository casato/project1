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
   
   @Test
   public void testTransactions()
   {
      Driver driver = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (5,4));
      ArrayList<Driver> drivers = new ArrayList<Driver>();
      drivers.add(driver);
      Dispatch dispatch = new Dispatch(drivers);
      Passenger passenger = new Passenger("Susan", "Pass", (float)200.00, dispatch, new Location(2, 4));
      assertTrue(dispatch.charge(driver, 150, passenger));
      assertEquals(passenger.balance(), 50, 0.0000001);
      assertEquals(driver.balance(), 250, 0.00000001);
      assertFalse(dispatch.charge(driver, 300, passenger));
      assertEquals(passenger.balance(), 50, 0.0000001);
      assertEquals(driver.balance(), 250, 0.00000001);
      
   }

}
