# bitcamp-project-web2

## 01. Gradle 웹 프로젝트 기본 골격 생성
 - 소스 폴더 생성
 - Mysql JDBC Driver 파일 준비(/libs/xxx.jar)
 - Gradle 설정 파일 준비(build.gradle)
 - GitIgnore 설정 파일 준비(/.gitignore)
 - README.md 파일 변경
 
 ## 0.2 학생 및 매니저 관리 기능 구현
  - 프로젝트 기본 패키지 준비

  - bitcamp.java89.ems2 패키지 생성
      domain 객체 구현

  - bitcamp.java89.ems2.domain 패키지 생성
      Student.java 클래스 정의
      DAO 객체 구현, domain 객체 구현
      MemberDao, StudentDao, ManagerDao, TeacherDao 인터페이스 생성
      MemberMysqlDao, StudentMysqlDao, ManagerMysqlDao, TeacherMysqlDao 클래스 정의 
      ManagerMysqlDao 클래스 구현

  - 서블릿 구현
      StudentListServlet, StudentAddServlet,studentDetailServlet,StudentUpdateServlet,StudentDeleteServlet 클래스 정의  
      ManagerListServlet, ManagerAddServlet, ManagerDetailServlet, ManagerUpdateServlet, ManagerDeleteServlet 클래스 구현
      
  ## 03. 포워딩/인클루딩 적용
   - 서블릿에서 오류가 발생하면 오류를 처리하는 서블릿으로 포워딩 시킨다.
   - ErroServlet 클래스 정의
   - 서블릿에 포워드 적용
   - HeaderServlet 과 FooterServlet적용
   - 서블릿에 인클루딩 적용

 