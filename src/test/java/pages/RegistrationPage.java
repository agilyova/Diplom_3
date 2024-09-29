package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
  private WebDriver driver;

  private By title = By.xpath(".//h2[text() = 'Регистрация']");
  private By name = By.xpath(".//label[text() = 'Имя']/../input");
  private By email = By.xpath(".//label[text() = 'Email']/../input");
  private By password = By.xpath(".//label[text() = 'Пароль']/../input");
  private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
  private By loginLink = By.xpath(".//a[contains(@class, 'Auth_link')]");
  private By incorrectPasswordError = By.xpath(".//p[text() = 'Некорректный пароль']");

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Ожидание загрузки страницы Регистрации")
  public void waitUntilPageOpen() {
    new WebDriverWait(driver, 5)
      .until(ExpectedConditions.visibilityOfElementLocated(title));
  }

  @Step("Заполнение поля Имя")
  public void setName(String name) {
    driver.findElement(this.name).sendKeys(name);
  }

  @Step("Заполнение пооля Email")
  public void setEmail(String email) {
    driver.findElement(this.email).sendKeys(email);
  }

  @Step("Заполнение поля Пароль")
  public void setPassword(String password) {
    driver.findElement(this.password).sendKeys(password);
  }

  @Step("Нажатие кнопки Зарегистрироваться")
  public void clickButtonRegister() {
    driver.findElement(registerButton).click();
  }

  @Step("Нажатие ссылки Войти")
  public void clickLoginLink() {
    driver.findElement(loginLink).click();
  }

  @Step("Проверка появления сообщения о некорректном пароле")
  public void checkIncorrectPasswordError() {
    new WebDriverWait(driver, 5)
      .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordError));
  }
}
