// Reflecting the directory structure where the file lives
package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
         // Very simple - just return some plain text
         PrintWriter writer = response.getWriter();
         writer.print("<HTML>");
         writer.print("<H2>");
         writer.print("Hello World");
         writer.print("</H2>");
         writer.print(" <IMG SRC=\"http://www.cirrusinsight.com/wp-content/uploads/2013/03/cloud3.gif\">");
         writer.print("</HTML>");
     }
}
