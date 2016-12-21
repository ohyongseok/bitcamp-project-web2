package bitcamp.java89.ems2.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.impl.ManagerMysqlDao;
import bitcamp.java89.ems2.dao.impl.MemberMysqlDao;
import bitcamp.java89.ems2.dao.impl.StudentMysqlDao;
import bitcamp.java89.ems2.dao.impl.TeacherMysqlDao;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    try {
      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
      
      response.setHeader("Refresh", "1;url=list");
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
  
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>학생관리-삭제</title>");
      out.println("</head>");
      out.println("<body>");
      RequestDispatcher rd = request.getRequestDispatcher("/header");
      rd.include(request, response);
      out.println("<h1>삭제 결과</h1>");
  
        ManagerMysqlDao managerDao = ManagerMysqlDao.getInstance();
      
        if (!managerDao.exist(memberNo)) {
          throw new Exception("사용자를 찾지 못했습니다.");
        }
        
        MemberMysqlDao memberDao = MemberMysqlDao.getInstance();
        StudentMysqlDao studentDao = StudentMysqlDao.getInstance();
        TeacherMysqlDao teacherDao = TeacherMysqlDao.getInstance();
        
        if (managerDao.exist(memberNo) && teacherDao.exist(memberNo)) {
          memberDao.delete(memberNo);
        }
        managerDao.delete(memberNo);
        out.println("<p>삭제하였습니다.</p>");
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        out.println("</body>");
        out.println("</html>");
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
      return;
    }
    
    
  }
}
