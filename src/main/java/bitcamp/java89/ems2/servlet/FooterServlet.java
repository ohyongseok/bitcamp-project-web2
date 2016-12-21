package bitcamp.java89.ems2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;
  
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<div id= 'footer' style='background-color:gray; heght=20px; "
        + "margin-top:20px;'>");
    out.println("<div style='color: white; padding-top:4px; font-family: 돋움체, sans-serif;"
        + " text-align:center;'><span>@2016비트캠프 자바89기</span></div>");
    out.println("</div>");
  }
}
