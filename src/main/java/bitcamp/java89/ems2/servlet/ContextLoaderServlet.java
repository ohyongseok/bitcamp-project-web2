package bitcamp.java89.ems2.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import bitcamp.java89.ems2.dao.impl.ManagerMysqlDao;
import bitcamp.java89.ems2.dao.impl.MemberMysqlDao;
import bitcamp.java89.ems2.dao.impl.StudentMysqlDao;
import bitcamp.java89.ems2.dao.impl.TeacherMysqlDao;
import bitcamp.java89.ems2.util.DataSource;

/* 다른 서블릿이 사용할 객체를 준비한다.
 * Dao 객체 준비, 클라이언트가 직접 사용할 일은 없다.
*/

//@WebServlet -> web.xml에 설정하여서 필요 없음
public class ContextLoaderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void init() throws ServletException {
  
  
    try {
      ServletContext sc = this.getServletContext();
      
      DataSource ds = new DataSource();
      
      MemberMysqlDao memberDao = new MemberMysqlDao();
      memberDao.setDataSource(ds);
      sc.setAttribute("memberDao", memberDao);
      
      ManagerMysqlDao managerDao = new ManagerMysqlDao();
      managerDao.setDataSource(ds);
      sc.setAttribute("managerDao", managerDao);
      
      StudentMysqlDao studentDao = new StudentMysqlDao();
      studentDao.setDataSource(ds);
      sc.setAttribute("studentDao", studentDao);
      
      TeacherMysqlDao teacherDao = new TeacherMysqlDao();
      teacherDao.setDataSource(ds);
      sc.setAttribute("teacherDao", teacherDao);
      
      System.out.println("ContextLoaderServlet.init() 실행 완료!");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
