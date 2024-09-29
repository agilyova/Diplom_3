import api.User;
import helpers.ApiHelper;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import static constants.Routes.FORGOT_PASSWORD_ROUTE;
import static constants.Routes.REGISTRATION_ROUTE;

@DisplayName("Вход в аккаунт")
public class LoginTest extends BaseTest {
  WebDriver driver;
  User user;
  String accessToken;

  @Before
  public void setUp() {
    driver = getBaseDriver();
    user = new User();
    accessToken = ApiHelper.createUser(user);
  }

  @DisplayName("Вход с главной страницы по кнопке Войти в аккаунт")
  @Test
  public void loginFromMainPageSuccessLogin() {
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    //SetUp
    driver.get(baseUrl);

    //Test
    mainPage.clickLoginButton();

    loginPage.login(user.getEmail(), user.getPassword());

    mainPage.waitUntilPageOpen();
    mainPage.checkSuccessLogin();
  }

  @DisplayName("Вход из хедера по кнопке Личный кабинет")
  @Test
  public void loginFromHeaderPageSuccessLogin() {
    HeaderPage header = new HeaderPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    //SetUp
    driver.get(baseUrl);

    //Test
    header.clickProfileButton();
    loginPage.login(user.getEmail(), user.getPassword());

    mainPage.waitUntilPageOpen();
    mainPage.checkSuccessLogin();
  }

  @DisplayName("Вход со страницы регистрации")
  @Test
  public void loginFromRegisterPageSuccessLogin() {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    //SetUp
    driver.get(baseUrl + REGISTRATION_ROUTE);

    //Test
    registrationPage.clickLoginLink();

    loginPage.waitUntilPageOpen();
    loginPage.login(user.getEmail(), user.getPassword());

    mainPage.waitUntilPageOpen();
    mainPage.checkSuccessLogin();
  }

  @DisplayName("Вход со страницы восстановления пароля")
  @Test
  public void loginFromForgotPasswordPageSuccessLogin() {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    driver.get(baseUrl + FORGOT_PASSWORD_ROUTE);
    forgotPasswordPage.clickLoginLink();
    loginPage.login(user.getEmail(), user.getPassword());

    mainPage.waitUntilPageOpen();
    mainPage.checkSuccessLogin();
  }

  @After
  public void tearDown() {
    ApiHelper.deleteUser(accessToken);
    driver.quit();
  }
}
