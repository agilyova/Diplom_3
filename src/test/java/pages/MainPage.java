package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
  private WebDriver driver;

  public static final int MIN_DIF = 0;
  public static final int MAX_DIF = 10;

  private By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");
  private By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
  private By title = By.xpath(".//h1[text() = 'Соберите бургер']");
  private By bunTab = By.xpath(".//span[text() = 'Булки']");
  private By souseTab = By.xpath(".//span[text() = 'Соусы']");
  private By toppingTab = By.xpath(".//span[text() = 'Начинки']");
  private By bunTitle = By.xpath(".//h2[text() = 'Булки']");
  private By souseTitle = By.xpath(".//h2[text() = 'Соусы']");
  private By toppingTitle= By.xpath(".//h2[text() = 'Начинки']");
  private By menuContainer = By.xpath(".//div[contains(@class, 'menuContainer')]");

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getBunTitle() {
    return driver.findElement(bunTitle);
  }

  public WebElement getSouseTitle() {
    return driver.findElement(souseTitle);
  }

  public WebElement getToppingTitle() {
    return driver.findElement(toppingTitle);
  }

  @Step("Ожидание загрузки Главной страницы")
  public void waitUntilPageOpen() {
    new WebDriverWait(driver, 5)
      .until(ExpectedConditions.visibilityOfElementLocated(title));
  }

  @Step("Нажатие кнопки Войти в аккаунт")
  public void clickLoginButton() {
   driver.findElement(loginButton).click();
  }

  @Step("Нажатие на таб Булки")
  public void clickBunTab() {
    driver.findElement(souseTab).click();
    driver.findElement(bunTab).click();
  }

  @Step("Нажатие на таб Соусы")
  public void clickSouseTab() {
    driver.findElement(souseTab).click();
  }

  @Step("Нажатие на таб Начинки")
  public void clickToppingTab() {
    driver.findElement(toppingTab).click();
  }

  @Step("Проверка, что осуществился переход к разделу меню")
  public void checkMenuSectionTitleInTheTopOfMenu(WebElement element) {
    WebElement menuContainerElement = driver.findElement(menuContainer);

    //Проверяем, что по оси Y элемент находится в углу контейнера меню с небольшой возможной погрешностью
    int dif = element.getLocation().y - menuContainerElement.getLocation().y;
    Assert.assertTrue(dif >= MIN_DIF && dif < MAX_DIF);
  }

  @Step("Проверка успешной авторизации")
  public void checkSuccessLogin() {
    driver.findElement(orderButton).isEnabled();
  }
}
