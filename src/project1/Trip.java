package project1;
import java.lang.Math;


public class Trip {
   private Location start, end;
   private Driver driver;
   private Passenger passenger;
   private float fare;
   
   
   Trip(int x1, int y1, int x2, int y2)
   {
      this.start = new Location (x1, y1);
      this.end = new Location (x2, y2);
   }
   
   public double distance()
   {
      double distance = Math.sqrt(Math.pow(end.x() - start.x(),2) + Math.pow(end.y() - start.y(), 2));
      return distance;
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
