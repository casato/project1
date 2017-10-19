package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import project1.Dispatch;
import project1.Driver;
import project1.Location;
import project1.MainSim;
import project1.Passenger;
import project1.Trip;

public class DispatchTest {

   @Ignore
   public void testDispatch() {
      fail("Not yet implemented"); // TODO
   }

   @Test
   public void testFindDriver() {
      //MainSim.setUpLogger();
      Driver driver1 = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (5,4));
      Driver driver2 = new Driver("second", "Driver", "civic", (float)100.00, (float)4.5, new Location (5,4));
      Driver driver3 = new Driver("third", "Driver", "focus", (float)100.00, (float)4.5, new Location (11,0));
      Driver driver4 = new Driver("fourth", "Driver", "odyssey", (float)100.00, (float)3.5, new Location (1,1));
      
      ArrayList<Driver> drivers = new ArrayList();
      drivers.add(driver1);
      drivers.add(driver2);
      drivers.add(driver3);
      drivers.add(driver4);
      
      Dispatch dispatch = new Dispatch(drivers);
      Trip t = new Trip(0, 0, 3, 4);
      
      
      assertEquals(driver4,dispatch.findDriver(t, new Passenger(new Location(0,0))));
   }
   
   @Test
   public void testCharge()
   {
      //MainSim.setUpLogger();
      Driver driver1 = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (5,4));
      Driver driver2 = new Driver("second", "Driver", "civic", (float)100.00, (float)4.5, new Location (5,4));
      Driver driver3 = new Driver("third", "Driver", "focus", (float)100.00, (float)4.5, new Location (11,0));
      Driver driver4 = new Driver("fourth", "Driver", "odyssey", (float)100.00, (float)3.5, new Location (1,1));
      
      ArrayList<Driver> drivers = new ArrayList();
      drivers.add(driver1);
      drivers.add(driver2);
      drivers.add(driver3);
      drivers.add(driver4);
      
      Dispatch dispatch = new Dispatch(drivers);
      Trip t = new Trip(0, 0, 3, 4);
      Passenger p1 = new Passenger("Jesse", "McCree", (float)130.00, new Location(1,1));
      
      dispatch.charge(driver1, (float)70.00, p1);
      
      assertEquals(driver1.balance(),170,0.00001);
      assertEquals(p1.balance(),60.0, 0.00001);
      
   }
   



}
