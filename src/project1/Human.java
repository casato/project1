package project1;

/**
 * Represents a Human in this simulation.
 * @author clay
 *
 */
public abstract class Human {
   
   protected String firstName;
   protected String lastName;
   protected float balance;
   protected Location location;

   /**
    * Sets the Location of this
    * @param newLocation the Location data to be set
    */
   public void setLocation(Location newLocation)
   {
      this.location = newLocation;
   }
   
   /**
    * Deducts this Human's balance by the amount specified
    * @param amount the amount to deduct the balance by
    */
   public void deduct(float amount)
   {
         this.balance -= amount;
   }
   
   /**
    * Gets the location of this Human
    * @return the location object of this Human.
    */
   public Location location()
   {
      return location;
   }
   
   /**
    * Gets the balance of this.
    * @return the monetary balance of this
    */
   public float balance()
   {
      return balance;
   }
   
   /**
    * Adds to the balance of this.
    * @param amount the amount to be funded
    */
   public void credit(float amount)
   {
      this.balance += amount;
   }

}
