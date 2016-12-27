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
   
  ## 0.5 - ServletContext 보관소 기능을 사용하여 DAO 공유하기
    - 기존의 DAO 클래스에서 Singleton 패턴 제거
    - DataSource 클래스에서 Singleton 패턴 제거
    - 다른 서블릿이 사용할 DAO 객체를 준비시키는 서블릿을 만든다.
    - ContextLoaderServlet 클래스 준비

  ## 0.6 - FIlter 컴포넌트를 사용하여  POST 요청 데이터의 문자집합을 자동으로 설정
    - CharacterEncodingFilter 클래스 정의
    - POST 요청 데이터의 문자 집합 지정하는 코드 추가
    - 서블릿 실행
    - 인코딩 필터를 DD 파일(web.xml) 등록
    - 서블릿에 request.CharacterEncodingFilter 설정
  ## 0.7 - Listener 컴포넌트를 이용하여 웹 애플리케이션에서 사용할 도구 준비하기
    - 웹 애플리케이션이 시작되면 서블릿들이 공동으로 사용할 객체를 준비시킨다.
    - ServletConextListener 구현체 준비
    - ContextLoaderListener 클래스 정의 : 이 클래스는 기존의 ContextLoaderServlet의 역할을 대체
    
  ## 0.8 - 쿠키를 이용하여 로그인 아이디 저장하기, 로그인 처리
    - 로그인 폼 생성
     - LoginServlet.java 생성
    - MemberDao와 MemberMysqlDao 클래스에 exist(email, password) 매서드 추가
     - LoginSerlet 클래스에 로그인 처리 코드 추가
     
  ## 0.9 세션을 이용하여 로그인 사용자 정보 저장하고 꺼내기
    - LoginServlet의 doPost() 변경
     - MemeberDao를 이용하여 로그인 사용자 정보를 가져온다.
     - 그리고 HttpSessoion 보관소에 저장한다.   
    - HeaderServlet 변경
     - 로그인 하지 않은 경우 "로그인 링크" 출력
     - 로그인 한 경우 "이름과 로그아웃 링크" 출력
    - LogoutServlet 생성
     - 세션을 무효화 시킨다.
     
  ## 1.0 학생/매니저/강사 등록시 사진 업로드 하기
    - 의존 라이브러리 설정하기
     - build.gradle 파일에 apache-fileupload 설정하기.
     - 'gradle eclipse' 명령을 수행하여 이클립스 설정 파일 갱신
    - 학생사진 업로드
     - student/form.html 변경
      - form.html 태그에 enctype 속성 추가
     -  StudentAddServlet 클래스 변경
      - fileupload 라이브러리의 클래스를 사용하여 멀티 파트 데이터 처리
    - 매니저 사진 업로드
     - mananger/form.html 변경
      - form.html 태그에 enctype 속성 추가
     -  ManangerAddServlet 클래스 변경
      - fileupload 라이브러리의 클래스를 사용하여 멀티 파트 데이터 처리
     - 매니저 사진을 저장할 클래스 생성
      - Photo.java 
     - Teacher 클래스 변경 
    - 매니저 사진 업로드
     - teacher/form.html 변경
      - form.html 태그에 enctype 속성 추가
     - 도메인객체 준비
     - TeacherAddServlet 클래스 변경
      - fileupload 라이브러리의 클래스를 사용하여 멀티 파트 데이터 처리