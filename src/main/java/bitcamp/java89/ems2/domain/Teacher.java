package bitcamp.java89.ems2.domain;

public class Teacher extends Member {
  private static final long serialVersionUID = 1L;
  
    protected String homepage;
    protected String facebook;
    protected String twit;
    public String getHomepage() {
      return homepage;
    }
    public void setHomepage(String homepage) {
      this.homepage = homepage;
    }
    public String getFacebook() {
      return facebook;
    }
    public void setFacebook(String facebook) {
      this.facebook = facebook;
    }
    public String getTwit() {
      return twit;
    }
    public void setTwit(String twit) {
      this.twit = twit;
    }
    
    
}
