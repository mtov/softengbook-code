/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Proxy Design Pattern
*
*/

/**
* Helper class
*/
class Book {
  String name;
  public Book(String name) {
    this.name = name;
  }
}


/**
* Interface implemented by the base object and the Proxy
*/
interface BookSearchInterface {
  Book getBook(String ISBN); 
}


/**
* Base object class
*/
class BookSearch implements BookSearchInterface {

  public Book getBook(String ISBN) {
    System.out.println("Searching in the base object - ISBN " + ISBN);
    if (ISBN.equals("2")) {
       return new Book("GoF");
    }  
    return null;
  }

}

/** 
* Proxy class
*/
class BookSearchProxy implements BookSearchInterface {

  private BookSearchInterface base;

  BookSearchProxy (BookSearchInterface base) {
    this.base = base;
  }

  public Book getBook(String ISBN) {
    Book book;
    System.out.println("Entering the proxy - ISBN: " + ISBN);

    // The idea here is that the Proxy knows the book with ISBN 1
    // Therefore, it doesn't need to query the base object
    if (ISBN.equals("1")) {
       System.out.println("Book found in the proxy - ISBN: " + ISBN);
       book = new Book("SoftEngBook");
    }   
    else {
      System.out.println("Book not found in the proxy; forwarding the call to the base object - ISBN: " + ISBN);
      book = base.getBook(ISBN);
    }
    System.out.println("Exiting the Proxy");
    return book;
  }

}

class Main {

  public static void main(String[] args) {   
    BookSearch bs = new BookSearch();
    BookSearchProxy pbs;
    pbs = new BookSearchProxy(bs);
    Book b1 = pbs.getBook("1");
    System.out.println("===============");
    Book b2 = pbs.getBook("2");
  }

}
