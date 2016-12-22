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
      
  ## 0.3 포워딩/인클루딩 적용
   - 서블릿에서 오류가 발생하면 오류를 처리하는 서블릿으로 포워딩 시킨다.
   - ErroServlet 클래스 정의
   - 서블릿에 포워드 적용
   - HeaderServlet 과 FooterServlet적용
   - 서블릿에 인클루딩 적용
   
  ## 0.4 ServletRequest의 보관소 기능을 이용하여 예외 정보 공유
   - 서블릿에서 예외가 발생하면 ErrorServlet으로 실행을 위임한다.
  이때 오류 정보를 ServletRequest에 담아서 넘긴다.
   - ErrorServlet은 ServletRequest에 보관된 오류 정보를 꺼내서 출력한다.
   - 모든 서블릿 코드 변경
   - ErrorServlet 코드 변경
   
  ## 0.7 - ServletContext 보관소 기능을 사용하여 DAO 공유하기
            - 기존의 DAO 클래스에서 Singleton 패턴 제거
            - DataSource 클래스에서 Singleton 패턴 제거
            - 다른 서블릿이 사용할 DAO 객체를 준비시키는 서블릿을 만든다.
            - ContextLoaderServlet 클래스 준비

 