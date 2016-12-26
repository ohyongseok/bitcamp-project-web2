package bitcamp.java89.ems2.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.MemberDao;
import bitcamp.java89.ems2.domain.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    String email = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("email")) {
          email = cookie.getValue();
          break;
        }
      }
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();


    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>로그인</title>");
    out.println("</head>");
    out.println("<body>");


    out.println("<h1>로그인</h1>");
    out.println("<form action='login' method='POST'>");
    RequestDispatcher rd = request.getRequestDispatcher("/header");
    rd.include(request, response);
    out.println("<table border='1'>");
    out.printf("<tr><th>이메일</th><td>"
        + "<input name='email'type='text' placeholder='예)hong@test.com' "
        + " value='%s'></td></tr>\n", email);
    // value는 무조건 있는것. 빈 문자열이 들어가든 문자열이 들어가든. 빈 문자열이면 빈 문자열로 들어가고..(삭제됨)
    out.println("<tr><th>암호</th><td><input name='password' type='password'></td></tr>");
    out.println("<tr><th></th><td><input name='saveEmail' type='checkbox'>이메일 저장</td></tr>");
    out.println("</table>");
    out.println("<button type='submit'>로그인</button>");
    out.println("</form>");
    rd = request.getRequestDispatcher("/footer");
    rd.include(request, response);
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {

      String saveEmail = request.getParameter("saveEmail");
      String password = request.getParameter("password");
      String email = request.getParameter("email");

      if (saveEmail != null) { // saveEmail이 넘어왔다는건 체크했다는 ㄱ뜻.
        // 쿠키를 웹 브라우저에게 보낸다.
        Cookie cookie = new Cookie("email", email);
        cookie.setMaxAge(60 * 60 * 24 * 15);
        response.addCookie(cookie);
      } else { // null 이라면
        // 기존에 보낸 쿠키를 제거하라고 웹 브라우저에게 응답한다.
        Cookie cookie = new Cookie("email", ""); // 체크를 안해도 
        cookie.setMaxAge(0); // 제로이면 제거하라.
        response.addCookie(cookie); // 즉시 찾아서 제거하라.
      }

      MemberDao memberDao =(MemberDao)this.getServletContext().getAttribute("memberDao");

      if (memberDao.exist(email, password)) {
        Member member =  memberDao.getOne(email);
        request.getSession().setAttribute("member", member); // HttpSession에 저장한다.
        response.sendRedirect("../student/list");
        return;       
        // 포워드는 포스트에서 포스트 요청 하는것.
        //인쿨루드도 포스트에서 포스트
      }

      response.setHeader("Refresh", "2;url=login"); // 2초 후 login url로 넘김.
      // 리프레쉬하고 지정된 url로 다시 돌아감.
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();


      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>로그인</title>");
      out.println("</head>");
      out.println("<body>");
      RequestDispatcher rd = request.getRequestDispatcher("/header");
      rd.include(request, response);
      out.println("<h1>로그인 실패</h1>");
      rd = request.getRequestDispatcher("/footer");
      rd.include(request, response);
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e){
      request.setAttribute("error", e); // 서블릿 리퀘스트에 예외정보 담아두고  /error로 보내 예외처리를 따로 함.
      RequestDispatcher rd = request.getRequestDispatcher("/error"); // 에러로 보낼 배달자를 받은
      rd.forward(request, response);
      return;
    }
  }


  // get 요청이 오면 doget 호출 // 서버에 보내는것.
  // 로그인한 이후는 post 요청 // 서버에 보낸걸 받는.
}