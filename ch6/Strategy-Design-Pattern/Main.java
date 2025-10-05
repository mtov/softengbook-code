/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Strategy Design Pattern
*
*/

import java.util.Arrays;

/**
* The MyList class implements a list that allows changing its sorting strategy.
* In the design patterns vocabulary, "strategy" = algorithm.
*
*/
class MyList {

  private int[] elements;

  private SortStrategy strategy;  // sorting strategy

  public MyList(int[] elements) {
    this.elements = elements;
    strategy = new BubbleSortStrategy(); // default strategy: BubbleSort
  }

  public void setSortStrategy(SortStrategy strategy) {
    this.strategy = strategy;  // allows changing the sorting strategy
  }

  public void sort() {
    strategy.sort(elements);
  }

  public void print() {
    System.out.println(Arrays.toString(elements));
  }
}


/** 
* Classes that implement sorting strategies should inherit
* from SortStrategy and implement the sort method.
*
*/
abstract class SortStrategy {
  abstract void sort(int[] elements);
}


/**
* Class that implements sorting using the Bubble Sort algorithm.
*
*/
class BubbleSortStrategy extends SortStrategy {

  void sort(int[] elements) {  
    int n = elements.length;  
    int temp = 0;  
    for (int i = 0; i < n; i++) {  
      for (int j = 1; j < (n-i); j++) {  
        if (elements[j-1] > elements[j]) {  
           temp = elements[j-1];  
           elements[j-1] = elements[j];  
           elements[j] = temp;  
        }  
      }  
    }  
  }
}

/**
* Class that implements sorting using the Selection Sort algorithm.
*
*/
class SelectionSortStrategy extends SortStrategy {

  void sort(int[] elements) {  
    for (int i = 0; i < elements.length - 1; i++) {  
      int index = i;  
      for (int j = i + 1; j < elements.length; j++) {  
          if (elements[j] < elements[index]) {  
             index = j;
          }  
      }  
      int smallerNumber = elements[index];   
      elements[index] = elements[i];  
      elements[i] = smallerNumber;  
    }  
  }
}


class Main {

  public static void main(String[] args) {
    System.out.println("List #1 was sorted with the default strategy: BubbleSort");
    int[] elems1 = {3,5,2,4,1,6};
    MyList list1 = new MyList(elems1);
    list1.sort(); // sorts the list using the default strategy: Bubble Sort
    list1.print();

    System.out.println("\nList #2 was sorted with another strategy: SelectionSort");
    int[] elems2 = {6,5,4,3,2,1};
    MyList list2 = new MyList(elems2);
    list2.setSortStrategy(new SelectionSortStrategy());
    list2.sort(); // sorts the list using Selection Sort
    list2.print(); 
  }
}
