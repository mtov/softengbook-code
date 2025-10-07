package org.softengbook.chapter8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
  Stack<Integer> stack;

  @BeforeEach
  public void init() {
    stack = new Stack<>();
  }

  @Test
  public void testEmptyStack() {
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testNotEmptyStack() {
    stack.push(10);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void testSizeStack() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    int size = stack.size();
    assertEquals(3, size);
  }

  @Test
  public void testPushPopStack() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    int result = stack.pop();
    result = stack.pop();
    assertEquals(20, result);
  }

  @Test
  public void testEmptyStackException() {
    assertThrows(java.util.EmptyStackException.class, () -> {
      stack.push(10);
      int result = stack.pop();
      result = stack.pop();
    });
  }

}