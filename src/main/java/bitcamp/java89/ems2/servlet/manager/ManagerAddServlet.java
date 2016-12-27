package bitcamp.java89.ems2.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.ManagerDao;
import bitcamp.java89.ems2.dao.MemberDao;
import bitcamp.java89.ems2.domain.Manager;
import bitcamp.java89.ems2.domain.Member;
import bitcamp.java89.ems2.util.MultipartUtil;

@WebServlet("/manager/add")
public class ManagerAddServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    try {
      Map<String, String> dataMap = MultipartUtil.parse(request);
      Manager manager = new Manager();
      manager.setEmail(dataMap.get("email"));
      manager.setPassword(dataMap.get("password"));
      manager.setName(dataMap.get("name"));
      manager.setTel(dataMap.get("tel"));
      manager.setPosition(dataMap.get("posi"));
      manager.setFax(dataMap.get("fax"));
      manager.setPath(dataMap.get("path"));
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
  
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("<title>매니저관리-등록</title>");
      out.println("</head>");
      out.println("<body>");
      RequestDispatcher rd = request.getRequestDispatcher("/header");
      rd.include(request, response);
      out.println("<h1>등록 결과</h1>");
      
      ManagerDao managerDao = (ManagerDao)this.getServletContext().getAttribute("managerDao");
      
        if (managerDao.exist(manager.getEmail())) {
          throw new Exception("같은 사용자 아이디가 존재합니다. 등록을 취소합니다.");
        }
        MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao");
        
        if (!memberDao.exist(manager.getEmail())) { // 강사나 매니저로 등록된것이 없다면.
          memberDao.insert(manager);
        } else { // 강사나 매니저로 이미 등록된 사용자라면 기존의 회원 번호를 사용한다.
          Member member = memberDao.getOne(manager.getEmail());
          manager.setMemberNo(member.getMemberNo());
        }
        
        managerDao.insert(manager);
        out.println("<p>등록하였습니다.</p>");
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        out.println("</body>");
        out.println("</html>");
      
    } catch (Exception e) {
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
      return;
    }
    
    
  }
}
