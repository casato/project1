package project1;

/**
 * Represents a passenger or customer of our rideshare service. A passenger requests a trip from our service.
 * @author clay
 *
 */
public class Passenger {
   private String firstName;
   private String lastName;
   private float balance;
   private Dispatch dispatch;
   
   /**
    * Creates a new instance of the Passenger class.
    * @param firstName
    * @param lastName
    * @param balance
    * @param dispatch
    */
   public Passenger(String firstName, String lastName, float balance, Dispatch dispatch)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.balance = balance;
      this.dispatch = dispatch;
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
         dispatch.charge(driver, driver.getFare(trip), this);
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
   

}
