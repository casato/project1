package project1;

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
   public Passenger(String firstName, String lastName, float balance, Dispatch dispatch, Location location)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.balance = balance;
      this.dispatch = dispatch;
      this.location = location;
   }
   
   @Deprecated
   /**
    * Use for testing purposes only...
    * @param location the starting location of this Passenger
    */
   public Passenger(Location location)
   {
      this.location = location;
   }
   

   
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
         System.out.println("Trip was cancelled. No available drivers.");
      }
   }
   
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
