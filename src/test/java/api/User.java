package api;

import helpers.DataHelper;

public class User {
  private String email;
  private String password;
  private String name;

  public User() {
    this.email = DataHelper.getEmail();
    this.password = DataHelper.getPassword(6);
    this.name = DataHelper.getName();
  }

  public User(int passwordLength) {
    this.email = DataHelper.getEmail();
    this.password = DataHelper.getPassword(passwordLength);
    this.name = DataHelper.getName();
  }

  public User(String email, String password, String name) {
    this.email = email;
    this.password = password;
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

