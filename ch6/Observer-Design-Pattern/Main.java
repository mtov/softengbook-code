/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Observer Design Pattern
*
*/


import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
* Subject class (part of the internal implementation of the pattern)
* Every subject must inherit from this class.
* It includes methods to add, remove, and notify the
* observers of this subject.
*
*/
class Subject {

  private List<Observer> observers = new ArrayList<Observer>();

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    Iterator<Observer> it = observers.iterator();
    while (it.hasNext()) {
      Observer obs = it.next();
      obs.update(this); 
    }
  }

}

/**
* Observer interface (also part of the internal implementation of the pattern)
* Every observer must implement this interface.
*/
interface Observer {
  public void update(Subject s);
}

/**
* Temperature is a subject (i.e., objects that can be observed).
*/
class Temperature extends Subject  {
   private double temp;

   public double getTemp() {
     return temp;
   }

   public void setTemp(double temp) {
     this.temp = temp;
     notifyObservers(); // notifies my observers
   }
}

/**
* CelsiusThermometer is an observer (of Temperature).
*/
class CelsiusThermometer implements Observer  {

  public void update(Subject s) { // method called when the values of a temperature change
    double temp = ((Temperature) s).getTemp();
    System.out.println("Temperature in Celsius: " + temp);
  }

}

public class Main {

  public static void  main(String[] args) {
    Temperature t = new Temperature();
    t.addObserver(new CelsiusThermometer());
    t.setTemp(100.0); // changes temperature; hence, observers are notified
  }

}
