/**
* Software Engineering: A Modern Approach
* https://softengbook.org
* Prof. Marco Tulio Valente
*
* Chapter 6 - Design Patterns
*  
* Example of the Builder Design Pattern
*
*/

class Book {
  private String name;
  private String authors;
  private String publisher;
  private String year;

  private Book(String name, String authors, String publisher, String year) {
    this.name = name;
    this.authors = authors;
    this.publisher = publisher;
    this.year = year;
  }

  public String toString() {
    return name + ". " + authors + "," + publisher + "," + year;      
  }

  /**
   * Book.Builder is a static public inner class of Book. 
   * That's why we can call "new Book.Builder()" directly without needing to instantiate an object of type Book first.
   */
  public static class Builder {
    private String name;
    private String authors;
    private String publisher;
    private String year; 

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAuthors(String authors) {
      this.authors = authors;
      return this;
    }

    public Builder setPublisher(String publisher) {
      this.publisher = publisher;
      return this;
    }

    public Builder setYear(String year) {
      this.year = year;
      return this;
    }

    public Book build() {
      return new Book(name, authors, publisher, year); 
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Book esm = new Book.Builder()
                        .setName("Software Engineering: A Modern Approach")
                        .setPublisher("UFMG")
                        .setYear("2024")
                        .build();
    System.out.println("Book 1: " + esm.toString());

    Book gof = new Book.Builder()
                        .setName("Design Patterns")
                        .setAuthors("GoF")
                        .setYear("1995")
                        .build();
    System.out.println("Book 2: " + gof.toString());                        
  }
}
