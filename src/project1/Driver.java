package project1;

/**
 * Represents a Driver, or employee of our rideshare service
 * @author clay
 *
 */
public class Driver extends Human{

   private String carTitle;
   
   private boolean isAvailable;
   
   private float payRate;
   private float rating;
   
   
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
   
   /**
    * Indicates whether or not this driver is ready for a new customer.
    * @return true if the driver is available, false if the driver is unavailable.
    */
   public boolean available()
   {
      return isAvailable;
   }
   
   /**
    * Changes the availability of this Driver.
    * @param isAvailable true if the driver is to be available, false if the driver is to be unavailable.
    */
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
   
   /**
    * Gets the Fare for a particular trip for this Driver.
    * @param t The Trip data
    * @param passenger The Passenger requesting the trip
    * @return a float representing the fare that will be charged for this trip. Fare is calculated with a base per-distance rate and this Driver's rating.
    */
   public float getFare(Trip t, Passenger passenger)
   {
      return payRate * ((float)t.distance() + (float)Location.distance(location, passenger.location()));
   }
   
   /**
    * Gets this Driver's rating
    * @return a double representing the Driver's rating.
    */
   public double rating()
   {
      return rating;         
   }
   

   /**
    * Represents this as a string
    * @return a String in the form of "{FirstName},{LastName},{CarTitle},{Balance},{Rating},{Location.x},{Location.y}"
    */
   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append(firstName);
      sb.append(',');
      sb.append(lastName);
      sb.append(',');
      sb.append(carTitle);
      sb.append(',');
      sb.append(balance);
      sb.append(',');
      sb.append(rating);
      sb.append(',');
      sb.append(location.toStringNoParentheses());
      sb.append('\n');
      return sb.toString();
   }

   

      
   
   
   

}
