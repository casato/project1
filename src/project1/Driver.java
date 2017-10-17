package project1;

public class Driver extends Human{

   private String carTitle;
   
   private boolean isAvailable;
   
   private float payRate;
   private float rating;
   
   private Location location;
   
   private final float BASE_PAY = 3;
   private final float RATING_ADJUSTMENT_FACTOR = 2;
   
   /**
    * Instantiates a Driver object with name and car title.
    * @param firstName The drivers first name
    * @param lastName The driver's last name
    * @param carTitle The driver's car
    * @param rating the driver's average rating
    */
   public Driver(String firstName, String lastName, String carTitle, float balance, float rating, Location location)
   {
      isAvailable = true;
      this.firstName = firstName;
      this.lastName = lastName;
      this.carTitle = carTitle;
      this.balance = balance;
      this.rating = rating;
      this.location = location;
      setPayRate();
   }
   
   public boolean available()
   {
      return isAvailable;
   }
   
   public void changeAvailability(boolean isAvailable)
   {
      this.isAvailable = isAvailable;
   }
   

   
   /**
    * gets the payrate of this driver. Payrate is the amount of currency-per-mile for a given trip.
    * @return the per-mile rate of this driver.
    */
   public float payRate()
   {
      return this.payRate;
   }
   
   private void setPayRate()
   {
      this.payRate = BASE_PAY + rating * RATING_ADJUSTMENT_FACTOR;
   }
   
   /**
    * Sets the availability status of a driver.
    * @param isAvailable a boolean representing if the driver will be available
    */
   public void setAvailable(boolean isAvailable)
   {
      this.isAvailable = isAvailable;
   }
   
   public float getFare(Trip t, Passenger passenger)
   {
      return payRate * ((float)t.distance() + (float)Location.distance(location, passenger.location()));
   }
   
   public double rating()
   {
      return rating;         
   }

   

      
   
   
   

}
