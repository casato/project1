package project1;
import java.lang.Math;
import java.util.InputMismatchException;

/**
 * Represents a Trip that is requested by a passenger. A trip has a beginning location and an end Location.
 * @author clay
 *
 */
public class Trip {
   private Location start, end;
   private Driver driver;
   private Passenger passenger;
   private float fare;
   
   /**
    * Instantiates a new Trip object.
    * @param x1 the x-coordinate of the start Location
    * @param y1 the y-coordinate of the start Location
    * @param x2 the x-coordinate of the end Location
    * @param y2 the y-coordinate of the end Location
    * @throws InputMismatchException
    */
   public Trip(int x1, int y1, int x2, int y2) throws InputMismatchException
   {
      if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0)
      {
         throw new InputMismatchException("Location data must be positive and within grid boundaries");
      }
      this.start = new Location (x1, y1);
      this.end = new Location (x2, y2);
   }
   
   /**
    * The Location data of the trip's destination
    * @return Location data for the destination
    */
   public Location end()
   {
      return this.end;
   }
   
   /**
    * The Location data of the trip's origin.
    * @return Location data for the trip's origin.
    */
   public Location start()
   {
      return this.start;
   }

   /**
    * Gets the distance of this trip.
    * @return the distance of this trip in grid unit distance.
    */
   public double distance()
   {
      return Location.distance(start, end);
   }
   
   /**
    * Represents this Trip as a String
    * @return a String in the form of "Trip from (x1, y1) to (x2, y2)" 
    */
   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder(128);
      sb.append("Trip from ");
      sb.append(start);
      sb.append(" to ");
      sb.append(end);
      return sb.toString();
      
      
   }
}
