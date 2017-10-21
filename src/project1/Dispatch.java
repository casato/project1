package project1;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.*;
import java.io.*;

/**
 * Represents a Dispatch center for our rideshare service. This will handle financial transactions and find appropriate drivers for a passenger's request.
 * @author clay
 *
 */
public class Dispatch {
   private ArrayList<Driver> drivers;
   private ArrayList<Passenger> passengers;
   private float rate;
   private final int TIME_CONST = 10;
   private FileHandler handler;
   private XMLFormatter formatter;
   
   /**
    * Creates an instance of Dispatch
    * @param drivers ArrayList of Driver objects that are under the jurisdiction of this Dispatch.
    */
   public Dispatch(ArrayList<Driver> drivers)
   {
      this.drivers = drivers;
      
   }
   
   /**
    * Finds a Driver for a passenger who requests one.
    * @param t The Trip object that the passenger is requesting
    * @param passenger The passenger that is requesting the ride
    * @return a Driver object that was chosen with priority given to availability, distance, and rating, in that order.
    */
   public Driver findDriver(Trip t, Passenger passenger)
   {
      if(MainSim.fileHandler() != null)
         MainSim.fileHandler().publish(new LogRecord(Level.INFO, "Finding a Driver..."));
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
            if(MainSim.fileHandler() != null)
               MainSim.fileHandler().publish(new LogRecord(Level.INFO, "Found a driver: " + results.peek().toString()));
            return results.poll();
         }
         results.poll();
      }
      return null;
   }
   
   /**
    * Simulates a successful trip provided by our rideshare service. 
    * @param driver The Driver for this trip
    * @param passenger The Passenger for this trip
    * @param trip The Trip data for this trip
    */
   public void runTrip(Driver driver, Passenger passenger, Trip trip)
   {
      if(MainSim.fileHandler() != null)
      {
         MainSim.fileHandler().publish(new LogRecord(Level.INFO, "Trip initiated for " + passenger + " with Driver: " + driver + " Fare: " + driver.getFare(trip, passenger)));
      }
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
      if(MainSim.fileHandler() != null)
      {
         MainSim.fileHandler().publish(new LogRecord(Level.INFO, "Locations updated. Trip complete. New Location: " + trip.end()));
      }
   }

   /**
    * Performs a financial transaction as part of a trip in our rideshare service
    * @param d The Driver, who will be credited
    * @param fare The fare for this particular trip
    * @param p The Passenger, who will be debited for this trip
    * @return a boolean whether or not this transaction was successful (if the passenger has enough money)
    */
   public boolean charge(Driver d, float fare, Passenger p)
   {
      if(fare <= p.balance())
      {
         p.deduct(fare);
         d.credit(fare);
         if(MainSim.fileHandler() != null)
         {
            MainSim.fileHandler().publish(new LogRecord(Level.INFO, "Transaction complete: Passenger successfully charged. Driver successfully credited"));
         }
         return true;
      }
      else
      {
         if(MainSim.fileHandler() != null)
         {
            MainSim.fileHandler().publish(new LogRecord(Level.INFO, "Transaction cancelled. Insufficient funds."));
         }
         return false;
      }
   }
   

   /**
    * Sets the ArrayList of passengers under the jurisdiction of this Dispatch center.
    * @param passengers the list of passengers
    */
   public void setPassengers(ArrayList<Passenger> passengers)
   {
      this.passengers = passengers;
   }
   

}
