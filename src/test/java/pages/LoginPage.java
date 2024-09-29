package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
  WebDriver driver;

  private By title = By.xpath(".//h2[text() = 'Вход']");
  private By email = By.xpath(".//label[text() = 'Email']/../input");
  private By password = By.xpath(".//label[text() = 'Пароль']/../input");
  private By loginButton = By.xpath(".//button[text() = 'Войти']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Ожидание загрузки страницы Входа")
  public void waitUntilPageOpen() {
    new WebDriverWait(driver, 5)
      .until(ExpectedConditions.visibilityOfElementLocated(title));
  }

  @Step("Осуществлеие логина")
  public void login(String email, String password) {
    setEmail(email);
    setPassword(password);
    clickLoginButton();
  }

  @Step("Заполнение пооля Email")
  public void setEmail(String email) {
    driver.findElement(this.email).sendKeys(email);
  }

  @Step("Заполнение поля Пароль")
  public void setPassword(String password) {
    driver.findElement(this.password).sendKeys(password);
  }

  @Step("Нажатие кнопки Войти")
  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }
}
