package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProfilePage {
  WebDriver driver;

  public ProfilePage(WebDriver driver) {
    this.driver = driver;
  }

  private By profileMenuItem = By.xpath(".//a[text() = 'Профиль']");
  private By logoutButton = By.xpath(".//button[text() = 'Выход']");


  @Step("Ожидание загрузки страницы Личного кабинета")
  public void waitUntilPageOpen() {
    new WebDriverWait(driver, 5)
      .until(visibilityOfElementLocated(profileMenuItem));
  }

  @Step("Нажатие кнопки Выход")
  public void clickLogOutButton() {
    driver.findElement(logoutButton).click();
  }
}
