package project1;
import java.lang.Math;


public class Trip {
   private int x1, x2, y1, y2;
   private Driver driver;
   private Passenger passenger;
   private float fare;
   
   public Trip(int x1, int y1, int x2, int y2)
   {
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
   }
   
   public double distance()
   {
      double distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
      return distance;
   }
   
   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder(128);
      sb.append("Trip from (");
      sb.append(x1);
      sb.append(", ");
      sb.append(y1);
      sb.append(") to (");
      sb.append(x2);
      sb.append(", ");
      sb.append(y2);
      sb.append(')');
      return sb.toString();
      
      
   }
}
