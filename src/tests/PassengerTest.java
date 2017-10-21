package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import project1.*;

public class PassengerTest {

   @Test
   public void testRequestTrip() {
      Passenger p1 = new Passenger("Jesse", "McCree", (float)130.00, new Location(0,0));
      Trip t1 = new Trip(p1.location(), new Location(100, 100));
      Dispatch dispatch = new Dispatch(new ArrayList<Driver>());
      p1.setDispatch(dispatch);
      p1.requestTrip(t1);
      assertEquals(p1.location(), new Location(0,0));
      
      
   }

   @Test
   public void testToString() {
      fail("Not yet implemented"); // TODO
   }

}
