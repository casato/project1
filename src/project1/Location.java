package project1;

/**
 * Location class encapsulates location data for a 2d grid. It is represented by an x and y coordinate.
 * @author clay
 *
 */
public class Location {

   private int x, y;
   
   /**
    * creates an instance of a Location
    * @param x the location's x coordinate
    * @param y the location's y coordinate
    */
   public Location(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
   public int x()
   {
      return x;
   }
   
   public int y()
   {
      return y;
   }
   
   /**
    * Calculates the distance between two Locations ("as the crow flies").
    * @return
    */
   public static double distance(Location start, Location end)
   {
      double distance = Math.sqrt(Math.pow(end.x() - start.x(),2) + Math.pow(end.y() - start.y(), 2));
      return distance;
   }
  

   @Override
   /**
    * Generates a string to represent the location data in the form of "(x, y)"
    * @return a String in the form of "(x, y)" representing the location data
    */
   public String toString()
   {
      return "(" + this.x + ", " + this.y + ")";
   }
   
}
