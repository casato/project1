package project1;
import java.lang.Math;
import java.util.InputMismatchException;


public class Trip {
   private Location start, end;
   private Driver driver;
   private Passenger passenger;
   private float fare;
   
   
   public Trip(int x1, int y1, int x2, int y2) throws InputMismatchException
   {
      if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0)
      {
         throw new InputMismatchException("Location data must be positive and within grid boundaries");
      }
      this.start = new Location (x1, y1);
      this.end = new Location (x2, y2);
   }
   
   public Location end()
   {
      return this.end;
   }
   
   public Location start()
   {
      return this.start;
   }

   public double distance()
   {
      return Location.distance(start, end);
   }
   
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
