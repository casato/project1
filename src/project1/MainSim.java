package project1;

import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.XMLFormatter;
import java.io.*;
import java.text.SimpleDateFormat;

public class MainSim {

   private static final String inputFile = "input.ubi";
   private static final String outputFile = "output.ubo";
   private static final String logFile = "dispatchlog.xml";
   private static XMLFormatter formatter;
   private static FileHandler handler;
   private static String dateString;
   private static ArrayList<Passenger> passengers;
   private static ArrayList<Driver> drivers;
   
   public static final int GRID_LIMIT = 300;

   public static void main(String [] args)
   {
      

      //initialize log file
      setUpLogger();

      
      //read in init file
      
      File in = new File(inputFile);
      File out = new File(outputFile);
      importFromFile(in);

      //run program
      for(int i = 0; i < 5; i++)
      {
         Random r = new Random();
         Passenger p = passengers.get(r.nextInt(passengers.size()));
         Trip t = new Trip(p.location(), Location.randomLocation());
         Dispatch d = new Dispatch(drivers);
         p.setDispatch(d);
         p.requestTrip(t);
      }

      //export log
      handler.flush();

      //export final file
      exportStateToFile(out);
   }
   


   public static FileHandler fileHandler()
   {
      return handler;
   }

   public static void setUpLogger()
   {
      dateString = new SimpleDateFormat("yy-MM-dd_HHmmss_").format(new Date());
      formatter = new XMLFormatter();

      try
      {
         handler = new FileHandler(dateString + logFile);
         handler.setFormatter(formatter);

      }
      catch (Exception e)
      {
         System.out.println("Unable to initialize log file: " + logFile);
         e.printStackTrace();
      }

   }

   public static void importFromFile(File f)
   {
      drivers = new ArrayList<Driver>();
      passengers = new ArrayList<Passenger>();
      try {
         Scanner sc = new Scanner(f);
         String line = "";
         while(sc.hasNext() && !line.contains("@driver"))
         {
            line = sc.nextLine();
         }
         line = sc.nextLine();
         while(sc.hasNext() && !line.contains("@passenger"))
         {
            if(!line.equals(""))
            {
               String[] info = line.split(",");
               Driver d = new Driver(info[0], info[1], info[2], Float.parseFloat(info[3]), 
                     Float.parseFloat(info[4]), new Location(Integer.parseInt(info[5]), 
                           Integer.parseInt(info[6])));
               handler.publish(new LogRecord(Level.INFO, "Read in Driver: " + d));

               drivers.add(d);
            }
            line = sc.nextLine();
         }
         line = sc.nextLine();
         while(sc.hasNext())
         {
            if(!line.equals(""))
            {
               
               String[] info = line.split(",");
               Passenger p = new Passenger(info[0], info[1], Float.parseFloat(info[2]), 
                     new Location (Integer.parseInt(info[3]), Integer.parseInt(info[4])));
               handler.publish(new LogRecord(Level.INFO, "Read in Passenger: " + p));
               passengers.add(p);
               
            }
            line = sc.nextLine();
         }
         sc.close();
      }
      catch(Exception e)
      {
         if(e instanceof IOException)
         {
            handler.publish(new LogRecord(Level.WARNING, "Unable to open input file: " + f.getName()));
         }
         else
         {
            handler.publish(new LogRecord(Level.WARNING, "Input file contains syntax errors: " + f.getName() + e));

         }

      }
   }


   public static void exportStateToFile(File f)
   {
      handler.publish(new LogRecord(Level.INFO, "Beginning export to file..."));
      try {
         FileWriter fwrite = new FileWriter(f);
         fwrite.write(printState());
         fwrite.write("@end\n");
         fwrite.close();
         handler.publish(new LogRecord(Level.INFO, "File export complete."));

      }
      catch (IOException e)
      {
         handler.publish(new LogRecord(Level.WARNING, "Unable to open file for writing... File export skipped" + e.toString()));

      }

   }

   public static String printState()
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
