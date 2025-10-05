/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Singleton Design Pattern
*
*/

/**
* The Logger class is a Singleton.
* Therefore, by design, there can be at most one instance (object)
* of this class.
*/

class Logger {

  private Logger() {} // prevents clients from calling new Logger()

  private static Logger instance; // unique instance

  public static Logger getInstance() {
    if (instance == null) // 1st time calling getInstance
      instance = new Logger();
    return instance;
  }

  public void println(String msg) {
    // records msg in the console, but it could be in a file
    System.out.println(msg);      
  }

}

class Main {

  void test() {
    // Logger = new Logger(); => would result in a compilation error
  }

  void f() {
    Logger log = Logger.getInstance();  
    log.println("Executing f " + log);
  }

  void g() {
    Logger log = Logger.getInstance();  
    log.println("Executing g " + log);
  }

  void h() {
    Logger log = Logger.getInstance();  
    log.println("Executing h " + log);
  }

  public static void main(String[] args) {
    Main m = new Main();
     m.f();
     m.g();
     m.h(); 
     System.out.println("\nThe 3 calls executed on the same object, with ID: " + Logger.getInstance());
  }

}
