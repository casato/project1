package project1;

public class Driver {
   private String firstName;
   private String lastName;
   private String carTitle;
   private boolean isAvailable;
   private float balance;
   
   /**
    * Instantiates a Driver object with name and car title.
    * @param firstName The drivers first name
    * @param lastName The driver's last name
    * @param carTitle The driver's car
    */
   public Driver(String firstName, String lastName, String carTitle, float balance)
   {
      isAvailable = true;
      this.firstName = firstName;
      this.lastName = lastName;
      this.carTitle = carTitle;
      this.balance = balance;
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
      //TODO implement this
      return 0;
   }
   
   

}
