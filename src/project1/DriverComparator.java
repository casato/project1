package project1;

import java.util.Comparator;

public class DriverComparator implements Comparator{
   
   Passenger passenger;
   
   public DriverComparator(Passenger passenger)
   {
      this.passenger = passenger;
   }

   @Override
   /**
    * "Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second."
    * @param arg0 The first argument, assumed to be a Driver
    * @param arg1 The second argument, assumed to be a Driver
    * @prerequisite arg0 and arg1 must be Drivers.
    */
   public int compare(Object arg0, Object arg1) {
      Driver d0 = (Driver)arg0;
      Driver d1 = (Driver)arg1;
      double diff = Location.distance(d0.location(), passenger.location()) - Location.distance(d1.location(), passenger.location());
      if(diff == 0)
      {
         if(d0.rating() < d1.rating())
         {
            return 1;
         }
         else if(d0.rating() > d1.rating())
         {
            return -1;
         }
         else return 0;
      }
      else
      {
         if(diff < 0)
         {
            return -1;
         }
         else //diff should be positive at this point.
         {
            return 1;
         }
      }
   }
   
}
