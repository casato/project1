package project1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dispatch {
   private ArrayList<Driver> drivers;
   private ArrayList<Passenger> passengers;
   private float rate;
   
   public Dispatch(ArrayList<Driver> drivers)
   {
      this.drivers = drivers;
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
      
      return null;
   }
   
   public float getFare(Trip trip)
   {
      return (float)(trip.distance() * rate);
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
   

}
