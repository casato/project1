package project1;

public class Passenger {
   private String firstName;
   private String lastName;
   private float balance;
   private Dispatch dispatch;
   //new comment
   
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
         System.out.println("Trip was cancelled.");
      }
   }
   
   public void deduct(float amount)
   {
      this.balance -= amount;
   }
   

}
