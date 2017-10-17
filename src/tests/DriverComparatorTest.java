package tests;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
