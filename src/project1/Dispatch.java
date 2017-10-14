package project1;

import java.util.ArrayList;

public class Dispatch {
   private ArrayList<Driver> drivers;
   private ArrayList<Passenger> passengers;
   private float rate;
   
   public Dispatch(ArrayList<Driver> drivers, ArrayList<Passenger> passengers, float rate)
   {
      this.drivers = drivers;
      this.passengers = passengers;
      this.rate = rate;
   }
   
   public Driver findDriver(Trip t, Passenger passenger)
   {
      //TODO: implement method
      
      return null;
   }
   
   public float getFare(Trip trip)
   {
      return (float)(trip.distance() * rate);
   }
   
   public void charge(Driver d, float fare, Passenger p)
   {
      //TODO IMPLEMENT
   }
   

}
