package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import project1.Dispatch;
import project1.Driver;
import project1.DriverComparator;
import project1.Location;
import project1.Passenger;

public class DriverComparatorTest {


   @Test
   public void testCompare() {
      DriverComparator comp = new DriverComparator(new Passenger(new Location(0,0)));
      Driver driver1 = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (5,4));
      Driver driver2 = new Driver("second", "Driver", "civic", (float)100.00, (float)4.5, new Location (5,4));
      Driver driver3 = new Driver("third", "Driver", "focus", (float)100.00, (float)4.5, new Location (11,0));
      Driver driver4 = new Driver("fourth", "Driver", "odyssey", (float)100.00, (float)3.5, new Location (1,1));
      
      assertEquals(comp.compare(driver1, driver2), 1);
      assertEquals(comp.compare(driver2, driver3), -1);
      assertEquals(comp.compare(driver3, driver4), 1);

   }
      @Test
      public void testCharge()
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
