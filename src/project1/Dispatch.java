package project1;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.*;
import java.io.*;

public class Dispatch {
   private ArrayList<Driver> drivers;
   private ArrayList<Passenger> passengers;
   private float rate;
   private final int TIME_CONST = 50;
   private FileHandler handler;
   private XMLFormatter formatter;
   
   public Dispatch(ArrayList<Driver> drivers)
   {
      this.drivers = drivers;
      LogRecord record = new LogRecord(Level.INFO, "Created Dispatch object");
      try
      {
         
         this.formatter = new XMLFormatter();

         handler = new FileHandler("dispatchlog.xml");
         handler.setFormatter(formatter);
         handler.publish(record);
         handler.flush();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
   }
   
   public Driver findDriver(Trip t, Passenger passenger)
   {
      //TODO: implement method
      PriorityQueue<Driver> results = new PriorityQueue(new DriverComparator(passenger));
      for(Driver d : drivers)
      {
         if(d.available())
         {
            results.add(d);
         }
      }
      
      while(results.peek() != null)
      {
         if(results.peek().available())
         {
            return results.poll();
         }
         results.poll();
      }
      return null;
   }
   
   public void runTrip(Driver driver, Passenger passenger, Trip trip)
   {
      //some sort of timer...
      driver.setAvailable(false);
      try
      {
         Thread.sleep(TIME_CONST * (long)Location.distance(trip.start(), trip.end()));
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      
      driver.setLocation(trip.end());
      driver.setAvailable(true);
      passenger.setLocation(trip.end());
   }

   
   public boolean charge(Driver d, float fare, Passenger p)
   {
      if(fare <= p.balance())
      {
         p.deduct(fare);
         d.credit(fare);
         return true;
      }
      else
      {
         System.out.println("Insufficient funds. Transaction cancelled");
         return false;
      }
   }
   

   
   public void setPassengers(ArrayList<Passenger> passengers)
   {
      this.passengers = passengers;
   }
   

}
