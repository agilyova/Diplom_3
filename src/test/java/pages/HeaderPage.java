package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
  WebDriver driver;

  private By profileButton = By.xpath(".//p[text() = 'Личный Кабинет']");
  private By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
  private By logo = By.xpath(".//div[contains(@class, 'header__logo')]");


  public HeaderPage(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Нажатие кнопки Личный кабинет")
  public void clickProfileButton() {
    driver.findElement(profileButton).click();
  }

  @Step("Нажатие кнопки Коструктор")
  public void clickConstructorButton() {
    driver.findElement(constructorButton).click();
  }

  @Step("Нажатие на логотип")
  public void clickLogo() {
    driver.findElement(logo).click();
  }
}
