package com.stevenprogramming.ocp11.function.enhacements;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 18 2020
 * @version 1.0
 */
public class DefaultWithabstract {

  public void call() {
    List<Book> books = List.of(
            new Book("Gone with the wind", "Fiction"),
            new Book("Bourne Ultimatum", "Thriller"),
            new Book("The Client", "Thriller")
    );

    Reader r = b -> {
      System.out.println("Reading book " + b.getTitle());
    };
    
    books.forEach(x->r.read(x));

  }

  public static void main(String[] args) throws Exception{
      new DefaultWithabstract().call();
     try(InputStream i =null;){}
      
  }

}

interface Reader{
     void read(Book b);
     default void unread(Book b){ }
}

class Book {

  private String title;
  private String genre;

  public Book(String title, String genre) {
    this.title = title;
    this.genre = genre;
  }
  //accessors not shown

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the genre
   */
  public String getGenre() {
    return genre;
  }

  /**
   * @param genre the genre to set
   */
  public void setGenre(String genre) {
    this.genre = genre;
  }
}
