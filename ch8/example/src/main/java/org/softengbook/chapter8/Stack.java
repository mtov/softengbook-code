package org.softengbook.chapter8;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
  private ArrayList<T> elements = new ArrayList<>();
  private int size = 0;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void push(T elem) {
    elements.add(elem);
    size++;
  }

  public T pop() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException();
    T elem = elements.remove(size - 1);
    size--;
    return elem;
  } 
}
