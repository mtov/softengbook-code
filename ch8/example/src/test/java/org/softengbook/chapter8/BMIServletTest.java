package org.softengbook.chapter8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class BMIServletTest {

  HttpServletRequest req;
  HttpServletResponse res;
  StringWriter sw;

  @BeforeEach
  public void init() {
    req = mock(HttpServletRequest.class);
    res = mock(HttpServletResponse.class);
    sw = new StringWriter();
    try { 
      PrintWriter pw = new PrintWriter(sw);
      when(res.getWriter()).thenReturn(pw);
    } catch (IOException e) {
      System.out.println("An error occurred while creating the mock.");
    }
  }

  @Test
  public void testDoGet() {
    when(req.getParameter("weight")).thenReturn("82");
    when(req.getParameter("height")).thenReturn("1.80");
    new BMIServlet().doGet(req,res);
    assertEquals("BMI: 25.3\n", sw.toString());
  }
}