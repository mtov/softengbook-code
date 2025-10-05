/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Adapter Design Pattern
*
*/


/**
* Concrete class representing a Samsung projector
*/
class SamsungProjector {

  public void start() { 
    System.out.println("Turning on Samsung projector");
  }

}

/**
* Concrete class representing an LG projector
*/
class LGProjector {

  public void enable(int timer) {
    System.out.println("Turning on LG projector in " + timer + " minutes");
  }

}

/**
* Interface to abstract the project type (Samsung or LG)
*/
interface Projector {
  void turnOn();
}

/**
* Adapter for SamsungProjector to Projector
* An object of this class is a Projector (as it implements this interface),
* but internally it forwards all method calls to the adapted object
* (in this case, a SamsungProjector)
*/
class SamsungProjectorAdapter implements Projector {

   private SamsungProjector projector;

   SamsungProjectorAdapter(SamsungProjector projector) {
     this.projector = projector;
   }

   public void turnOn() {
     projector.start(); // calls adapted object (SamsungProjector)
   }

}

/**
* Similar to the previous class, but now adapting LGProjector to Projector
*/
class LGProjectorAdapter implements Projector {

   private LGProjector projector;

   LGProjectorAdapter(LGProjector projector) {
     this.projector = projector;
   }

   public void turnOn() {
     projector.enable(0); // calls adapted object (LGProjector)
   }

}

class ProjectorControlSystem { // has no knowledge of "concrete" projectors

  void init(Projector projector) {
    projector.turnOn();  // turns on any projector without needing to know if it's Samsung or LG
  }

}

class Main {

  public static void main(String[] args) {
     SamsungProjectorAdapter samsung = new SamsungProjectorAdapter(new SamsungProjector());
     LGProjectorAdapter lg = new LGProjectorAdapter(new LGProjector());
     ProjectorControlSystem pcs = new ProjectorControlSystem();
     pcs.init(samsung); 
     pcs.init(lg);      
  }

}
