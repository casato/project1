package project1;

public abstract class Human {
   
   protected String firstName;
   protected String lastName;
   protected float balance;
   protected Location location;

   public void setLocation(Location newLocation)
   {
      this.location = newLocation;
   }
   
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
   
   public float balance()
   {
      return balance;
   }
   
   public void credit(float amount)
   {
      this.balance += amount;
   }

}
