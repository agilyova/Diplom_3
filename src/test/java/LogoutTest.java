import api.User;
import helpers.ApiHelper;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.Map;

import static constants.Routes.PROFILE_ROUTE;

@DisplayName("Выход из аккаунта")
public class LogoutTest extends BaseTest {
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

  @DisplayName("Выход со страницы Личного кабинета")
  @Test
  public void logoutFromProfileOpenLoginPage() {
    ProfilePage profilePage = new ProfilePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    driver.get(baseUrl + PROFILE_ROUTE);
    profilePage.waitUntilPageOpen();
    profilePage.clickLogOutButton();

    loginPage.waitUntilPageOpen();
  }

  @After
  public void tearDown() {
    ApiHelper.deleteUser(authTokens.get("accessToken"));
    driver.quit();
  }
}
