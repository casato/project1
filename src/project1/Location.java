package project1;

public class Location {

   private int x, y;
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
   
   @Override
   public String toString()
   {
      return "(" + this.x + ", " + this.y + ")";
   }
   
}
