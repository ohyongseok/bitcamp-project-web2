package bitcamp.java89.ems2.domain;

public class Manager extends Member {
  private static final long serialVersionUID = 1L;
  
  protected String position;
  protected String fax;
  protected String path;
  
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getFax() {
    return fax;
  }
  public void setFax(String fax) {
    this.fax = fax;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }
  
}
