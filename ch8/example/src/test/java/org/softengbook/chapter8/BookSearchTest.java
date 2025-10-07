package org.softengbook.chapter8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

public class BookSearchTest {

  private BookService service;

  @BeforeEach
  public void init() {
    service = mock(BookService.class);
    when(service.search(anyInt())).
                thenReturn(BookConst.NULLBOOK);
    when(service.search(1234)).thenReturn(BookConst.SOFTENG);
    when(service.search(5678)).thenReturn(BookConst.HP);
  }      

  @Test
  public void testGetBook() {
    BookSearch bs = new BookSearch(service);
    String title = bs.getBook(1234).getTitle();
    assertEquals("Soft Eng: A Modern Approach", title);
  }

  @Test
  public void testGetAnotherBook() {
    BookSearch bs = new BookSearch(service);
    String title = bs.getBook(5678).getTitle();
    assertEquals("Harry Potter", title);
  }

  @Test
  public void testGetNullBook() {
    BookSearch bs = new BookSearch(service);
    String title = bs.getBook(635263).getTitle();
    assertEquals("NULL", title);
  }
}