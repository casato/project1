package project1;

public class Driver implements Comparable {
   private String firstName;
   private String lastName;
   private String carTitle;
   
   private boolean isAvailable;
   
   private float balance;
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
    * Gets the location of this Driver
    * @return the location object of this driver.
    */
   public Location location()
   {
      return location;
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
   
   public float getFare(Trip t)
   {
      return payRate * (float)t.distance();
   }
   
   public double rating()
   {
      return rating;         
   }

   @Override
   /**
    * Compares to another Driver by rating
    * @param arg0 the other Driver to compare to
    * @pre this method assumes the object being passed to it is a Driver
    * @return an int <0 if arg0<this or >0 if arg0>this or 0 if they are equal
    */
   public int compareTo(Object arg0) {
      Driver dr = (Driver) arg0;
      double result = dr.rating() - this.rating();
      if(result < 0) return -1;
      else if(result > 0) return 1;
      else return 0;
      
      }
   
   public void credit(float amount)
   {
      this.balance += amount;
   }
   
   public float balance()
   {
      return this.balance;
   }
      
   
   
   

}
