package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import project1.Dispatch;
import project1.Driver;
import project1.Location;
import project1.MainSim;
import project1.Passenger;

public class MainSimTest {

   /*@Test
   public void testPrintState() {
      Driver driver1 = new Driver("Joe", "Driver", "Camry", (float)100.00, (float)3.5, new Location (5,4));
      Driver driver2 = new Driver("second", "Driver", "civic", (float)100.00, (float)4.5, new Location (5,4));
      Driver driver3 = new Driver("third", "Driver", "focus", (float)100.00, (float)4.5, new Location (11,0));
      Driver driver4 = new Driver("fourth", "Driver", "odyssey", (float)100.00, (float)3.5, new Location (1,1));
      ArrayList<Driver> drivers = new ArrayList();
      drivers.add(driver1);
      drivers.add(driver2);
      drivers.add(driver3);
      drivers.add(driver4);
      
      Dispatch dispatch = new Dispatch(drivers);
      
      Passenger p1 = new Passenger("Jesse", "McCree", (float)130.00, new Location(1,1));
      Passenger p2 = new Passenger("Gabriel", "Reyes", (float)277.00, new Location(98,66));
      
      ArrayList<Passenger> passengers = new ArrayList();
      passengers.add(p1);
      passengers.add(p2);
      
      //System.out.print(MainSim.printState());
      
      File f = new File("test-output");   
      MainSim.setUpLogger();
      MainSim.exportStateToFile(f);
      
      
      }*/
   
   @Test
   public void testImportFromFile()
   {
      File f = new File("test-input.ubi");
      MainSim.setUpLogger();
      MainSim.importFromFile(f);
      File fout = new File("test-output.ubo");
      MainSim.exportStateToFile(fout);
      
      System.out.println("diff the two files and they should be the same");
      
   }

}
