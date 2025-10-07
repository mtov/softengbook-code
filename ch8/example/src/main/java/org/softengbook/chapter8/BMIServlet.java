package org.softengbook.chapter8;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class BMIModel {
  public double calculateBMI(String w1, String h1) 
                throws NumberFormatException {
    double w = Double.parseDouble(w1);
    double h = Double.parseDouble(h1);
    double bmi = w / (h * h);
    return Math.floor (bmi * 10) / 10;  // trunc to one decimal place
  }
}

public class BMIServlet extends HttpServlet {

  BMIModel model = new BMIModel();

  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res) {
    try {
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      String weight = req.getParameter("weight");
      String height = req.getParameter("height");
      double bmi = model.calculateBMI(weight, height);
      out.println("BMI: " + bmi);
    } catch (NumberFormatException e) {
      System.out.println("Invalid input: weight and height must be numbers.");
    } catch (IOException e) {
      System.out.println("An error occurred while processing the request.");
    }
  }
}