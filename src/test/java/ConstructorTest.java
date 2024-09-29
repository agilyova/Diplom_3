import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@DisplayName("Навигация по конструктору меню")
public class ConstructorTest extends BaseTest {
  MainPage mainPage;
  WebDriver driver;

  @Before
  public void setUp() {
    driver = getBaseDriver();
    mainPage = new MainPage(driver);
    driver.get(baseUrl);
  }

  @DisplayName("Переход к разделу Булки")
  @Test
  public void clickBunTabShowBunsSection() {
    mainPage.clickBunTab();

    mainPage.checkMenuSectionTitleInTheTopOfMenu(mainPage.getBunTitle());
  }

  @DisplayName("Переход к разделу Соусы")
  @Test
  public void clickSouseTabShowSouseSection() {
    mainPage.clickSouseTab();

    mainPage.checkMenuSectionTitleInTheTopOfMenu(mainPage.getSouseTitle());
  }

  @DisplayName("Переход к разделу Начинки")
  @Test
  public void clickToppingTabShowToppingSection() {
    mainPage.clickToppingTab();

    mainPage.checkMenuSectionTitleInTheTopOfMenu(mainPage.getToppingTitle()) ;
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
