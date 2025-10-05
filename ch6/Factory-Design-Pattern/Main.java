/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Factory Design Pattern
*
*/

/**
* Interface and class for the objects to be used in the example.
*/

interface Channel {}

class TCPChannel implements Channel {}

class UDPChannel implements Channel {}


/**
* The ChannelFactory class implements a static factory method.
* That is, a method that centralizes the creation of objects that
* implement the Channel interface.
*
* If tomorrow we want the system to use UDPChannel, it's enough
* to change the implementation of create()
*/

class ChannelFactory {

  public static Channel create() { // static factory method
    System.out.println("At this moment, we are working with TCPChannel");
    return new TCPChannel();
  }

}

public class Main { 

  void f() {
    Channel c = ChannelFactory.create();  
  }

  void g() {
    Channel c = ChannelFactory.create();
  }

  void h() {
    Channel c = ChannelFactory.create();
  }

  public static void main(String [] args) {
     Main m = new Main();
     m.f();
     m.g();
     m.h(); 
  }

}
