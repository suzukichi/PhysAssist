package logic;
/*
 * Role.java
 * 
 * Abstract class for user roles.
 * 
 * @author Daniel Sabsay
 * Created Feb 8, 2017
 */

public abstract class Role {
  public String roleName;
  
  public Role(String roleName) {
    this.roleName = roleName;
  }
  
  public abstract void displayPage(Page page);
}
