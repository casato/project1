package project1;

import java.util.*;
import java.io.*;

public class MainSim {
   
   private static final String inputFile = "input";
   private static final String outputFile = "output";
   

   public static void main(String [] args)
   {
      //read in init file
      
      //run program
      
      //export log
      
      //export final file
   }
   
   private static ArrayList<Passenger> getPassFromFile(File f)
   {
      return null;
   }
   
   private static ArrayList<Driver> getDriverFromFile(File f)
   {
      return null;
   }
   
   public static void exportStateToFile(File f, ArrayList<Driver> drivers, ArrayList<Passenger> passengers)
   {
      try {
         FileWriter fwrite = new FileWriter(f);
         fwrite.write(printState(drivers, passengers));
         fwrite.close();
      }
      catch (IOException e)
      {
         System.out.println("Unable to open file for writing... File export skipped");
         e.printStackTrace();
      }
      
   }
   
   public static String printState(ArrayList <Driver> drivers, ArrayList<Passenger> passengers)
   {
      StringBuilder sb =  new StringBuilder();
      //Print drivers
      sb.append("@driver\n");
      for(Driver d : drivers)
      {
         sb.append(d);
         sb.append('\n');
      }
      
      //print passengers
      
      sb.append("@passenger\n");
      for(Passenger p : passengers)
      {
         sb.append(p);
         sb.append('\n');
      }
      return sb.toString();
   }
}
