/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Visitor Design Pattern
*
*/

import java.util.ArrayList;
import java.util.List;

/**
* Vehicle is the root of a class hierarchy
* All classes in this hierarchy accept visits from "Visitor" objects
* In other words, Vehicles and their subclasses are open to such visits
* But they don't know exactly what the Visitor will do with their data
*
*/

abstract class Vehicle {
   private String licensePlate;    

  public Vehicle(String licensePlate) {
     this.licensePlate = licensePlate;
  }

  public String getLicensePlate() {
     return licensePlate;  
  }

  abstract public void accept(Visitor v);
}

class Car extends Vehicle {

  public Car(String licensePlate) {
     super(licensePlate);  
  }

  public void accept(Visitor v) {
     v.visit(this);  // the compiler already knows the type of this (= Car)
  }  // however, the call is dynamic, as various classes can implement the Visitor interface
}

class Bus extends Vehicle {

  public Bus(String licensePlate) {
     super(licensePlate);  
  }    

  public void accept(Visitor v) {
    v.visit(this);
  }
}

/**
* The Visitor interface must be implemented by visiting classes
*
*/
interface Visitor {
  void visit(Car c);
  void visit(Bus o);
}  

/**
* PrintVisitor is a visiting class
* It prints the license plate of concrete Vehicles (i.e., Car and Bus) on the screen
*
*/
class PrintVisitor implements Visitor {

   public void visit(Car c) { 
     System.out.println("Visiting a Car with license plate: " + c.getLicensePlate()); 
   } 

   public void visit(Bus o)  { 
     System.out.println("Visiting a Bus with license plate: " + o.getLicensePlate()); 
   } 
}

public class Main {

   public static void main(String[] args) {
      List<Vehicle> list = new ArrayList<Vehicle>();
      list.add(new Car("GHJ-1020"));
      list.add(new Bus("BNM-3456"));
      list.add(new Car("IOP-1234"));
      list.add(new Bus("BVC-7923"));

      // Let's "visit," with a PrintVisitor, each Vehicle in the list
      PrintVisitor visitor = new PrintVisitor();
      for (Vehicle vehicle : list) {
        vehicle.accept(visitor);
      }

      // Benefits of the Visitor pattern:
      // We can implement another Visitor class without having to modify the implementation
      // of the Vehicle class and its subclasses. Then, we can use this Visitor 
      // to visit all the vehicles in our list.
   }    
}

