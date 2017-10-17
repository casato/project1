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
   
   @Override
   public String toString()
   {
      return firstName + lastName;
   }
   
   public void requestTrip(Trip trip)
   {
      Driver driver = dispatch.findDriver(trip, this);
      if(driver != null)
      {
         dispatch.charge(driver, driver.getFare(trip, this), this);
      }
      else
      {
         //trip was cancelled.
         System.out.println("Trip was cancelled. No available drivers.");
      }
   }
   
   public void deduct(float amount)
   {
         this.balance -= amount;
   }
   
   public Location location()
   {
      return location;
   }
   
   public float balance()
   {
      return balance;
   }
   

}
