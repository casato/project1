package project1;

import java.util.InputMismatchException;
import java.util.Random;

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
   public Location(int x, int y) throws InputMismatchException
   {
      if(x < 0 || x > MainSim.GRID_LIMIT || y < 0 || y > MainSim.GRID_LIMIT)
      {
         throw new InputMismatchException("Location data must be positive and within grid boundaries");
      }
      this.x = x;
      this.y = y;
   }

   /**
    * Gets the X-coordinate of this Location data
    * @return the X-coordinate
    */
   public int x()
   {
      return x;
   }

   /**
    * Gets the Y-coordinate of this Location data
    * @return the Y-coordinate
    */
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

   /**
    * A modified version of the toString() method that excludes spaces and parentheses for easy export
    * @return A String in the form of "x,y" representing the location data.
    */
   public String toStringNoParentheses()
   {
      return this.x + "," + this.y;
   }

   public static Location randomLocation()
   {
      Random r = new Random();
      float x = r.nextFloat();
      float y = r.nextFloat();
      return new Location((int)(x * MainSim.GRID_LIMIT), (int)(y * MainSim.GRID_LIMIT));
   }

}
