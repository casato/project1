package project1;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Represents a passenger or customer of our rideshare service. A passenger requests a trip from our service.
 * @author clay
 *
 */
public class Passenger extends Human{

   private Dispatch dispatch;
   
   /**
    * Creates a new instance of the Passenger class.
    * @param firstName
    * @param lastName
    * @param balance
    * @param dispatch
    * @param location
    */
   public Passenger(String firstName, String lastName, float balance, Location location)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.balance = balance;
      this.location = location;
   }
   
   /**
    * Sets the Dispatch that is in charge of servicing this Passenger.
    * @param dispatch the Dispatch object
    */
   public void setDispatch(Dispatch dispatch)
   {
      this.dispatch = dispatch;
   }
   
   @Deprecated
   /**
    * Use for testing purposes only. Use the full Constructor public Passenger(String firstName, String lastName, float balance, Location location)
    * @param location the starting location of this Passenger
    */
   public Passenger(Location location)
   {
      this.location = location;
   }
   

   /**
    * Requests a Trip from the Dispatch. If the Dispatch finds a Driver, it will charge this Passenger. If the Passenger has enough money, the Driver will pick up the passenger.
    * If the Driver search or financial transaction do not complete, this trip is cancelled and the appropriate information is logged.
    * @param trip The Trip data for this trip
    */
   public void requestTrip(Trip trip)
   {

      Driver driver = dispatch.findDriver(trip, this);
      if(driver != null)
      {
         dispatch.charge(driver, driver.getFare(trip, this), this);
         dispatch.runTrip(driver, this, trip);
      }
      else
      {
         //trip was cancelled.
         if(MainSim.fileHandler() != null)
            MainSim.fileHandler().publish(new LogRecord(Level.WARNING, "Trip was cancelled. No Available Drivers."));
      }
   }
   

   /**
    * Represents this Passenger as a String
    * @return a string in the form of "{FirstName},{LastName},{Balance},{Location.x},{Location.y}"
    */
   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append(firstName);
      sb.append(',');
      sb.append(lastName);
      sb.append(',');
      sb.append(balance);
      sb.append(',');
      sb.append(location.toStringNoParentheses());
      sb.append('\n');
      return sb.toString();
   }
   

   

}
