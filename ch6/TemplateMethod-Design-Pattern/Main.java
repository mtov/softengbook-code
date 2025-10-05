/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Template Method Design Pattern
*
*/

/**
* Class that implements a Template Method (calcNetSalary)
* Note that this class is abstract.
*/
abstract class Employee {

   protected double salary;

   public Employee(double salary) {
     this.salary = salary;
   }

   abstract double calcRetirementDeductions();
   abstract double calcHealthPlanDeductions();
   abstract double calcOtherDeductions();

   /**
   * Template Method: defines the skeleton of an algorithm
   * It is still a "template" because the called methods are abstract.
   */
   public double calculateNetSalary() { 
     double pension = calcRetirementDeductions();
     double health = calcHealthPlanDeductions();
     double other = calcOtherDeductions();
     return salary - pension - health - other;
   }
}

/** 
* Subclass that implements the abstract methods called by the Template Method
* It will inherit the template method (calculateNetSalary)
* But it has to implement the abstract methods called by it.
*/
class PublicEmployee extends Employee {

  public PublicEmployee(double salary) {
     super(salary);
  }

  // implements abstract method
  double calcRetirementDeductions() { 
     return salary * 0.1;   // just an example
  }

  // implements abstract method
  double calcHealthPlanDeductions() {
     return 100.0;
  }

  // implements abstract method 
  double calcOtherDeductions() {
    return 20.0;
  }

}

class Main {

  public static void main(String[] args) {   
    PublicEmployee employee = new PublicEmployee(1000);
    double netSalary = employee.calculateNetSalary();
    System.out.println("Net Salary: " + netSalary);  
  }

}
