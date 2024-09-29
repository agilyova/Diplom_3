import api.User;
import helpers.ApiHelper;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.Map;

import static constants.Routes.PROFILE_ROUTE;

@DisplayName("Навигация по сайту")
public class NavigationTest extends BaseTest {
  WebDriver driver;
  User user;
  Map<String, String> authTokens;

  @Before
  public void setUp() {
    driver = getBaseDriver();
    driver.get(baseUrl);
    user = new User();
    authTokens = ApiHelper.createUserAndGetAccessAndRefreshToken(user);
    ApiHelper.loginUser(driver, authTokens);
  }

  @DisplayName("Переход в личный кабинет по клику на «Личный кабинет».")
  @Test
  public void openProfilePageTestOpenProfilePage() {
    HeaderPage header = new HeaderPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);

    header.clickProfileButton();
    profilePage.waitUntilPageOpen();
  }

  @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
  @Test
  public void openConstructorFromProfilePageByConstructorButtonOpenMainPage() {
    HeaderPage headerPage = new HeaderPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    MainPage mainPage = new MainPage(driver);

    driver.get(baseUrl + PROFILE_ROUTE);
    profilePage.waitUntilPageOpen();
    headerPage.clickConstructorButton();

    mainPage.waitUntilPageOpen();
  }

  @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers.")
  @Test
  public void openConstructorFromProfilePageByLogoButtonOpenMainPage() {
    HeaderPage headerPage = new HeaderPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    MainPage mainPage = new MainPage(driver);

    driver.get(baseUrl + PROFILE_ROUTE);
    profilePage.waitUntilPageOpen();
    headerPage.clickLogo();

    mainPage.waitUntilPageOpen();
  }

    @After
  public void tearDown() {
    ApiHelper.deleteUser(authTokens.get("accessToken"));
    driver.quit();
    }
  }

