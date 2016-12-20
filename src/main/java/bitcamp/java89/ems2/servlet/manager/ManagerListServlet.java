package bitcamp.java89.ems2.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.impl.ManagerMysqlDao;
import bitcamp.java89.ems2.domain.Manager;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ManagerMysqlDao managerDao = ManagerMysqlDao.getInstance();
      ArrayList<Manager> list = managerDao.getList();
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>매니저 관리-목록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>매니저 정보</h1>");
      out.println("<a href='form2.html'>추가</a><br>");
      out.println("<table border ='1'>");
      out.println("<tr>");
      out.println("<th>회원번호</th><th>이름</th><th>전화</th><th>직급</th><th>팩스</th><th>사진파일경로</th>");
      out.println("</tr>");
      
      for (Manager manager : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>"
            + "<td><a href=detail?memberNo=%1$d>%s</a></td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>\n",
                manager.getMemberNo(),
                    manager.getName(),
                    manager.getTel(),
                    manager.getPosition(),
                    manager.getFax(),
                    manager.getPath());
        out.println("</tr>");
        
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

}
