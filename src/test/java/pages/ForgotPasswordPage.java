package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
  WebDriver driver;

  private By loginLink = By.xpath(".//a[contains(@class, 'Auth_link')]");


  public ForgotPasswordPage(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Нажатие ссылки Войти")
  public void clickLoginLink() {
    driver.findElement(loginLink).click();
  }
}
