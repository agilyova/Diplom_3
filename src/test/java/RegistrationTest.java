import api.User;
import helpers.ApiHelper;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationPage;

import static constants.Routes.REGISTRATION_ROUTE;

@DisplayName("Регистрация пользователя")
public class RegistrationTest extends BaseTest {
  public static final int INCORRECT_PASSWORD_LENGTH = 5;
  public static final int CORRECT_PASSWORD_LENGTH = 6;
  WebDriver driver;

  @Before
  public void setUp() {
    driver = getBaseDriver();
    driver.get(baseUrl + REGISTRATION_ROUTE);
  }

  @DisplayName("Регистрация с валидными данными")
  @Test
  public void registrationValidDataCreateUser() {
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    User user = new User(CORRECT_PASSWORD_LENGTH);
    String accessToken;

    //Test
    registrationPage.setName(user.getName());
    registrationPage.setEmail(user.getEmail());
    registrationPage.setPassword(user.getPassword());
    registrationPage.clickButtonRegister();

    loginPage.waitUntilPageOpen();
    accessToken = ApiHelper.checkSuccessUserCreation(user);

    //TearDown
    ApiHelper.deleteUser(accessToken);
  }

  @DisplayName("Регистрация с невалидным паролем")
  @Test
  public void registrationNotValidPasswordReturnError() {
    User user = new User(INCORRECT_PASSWORD_LENGTH);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    registrationPage.setName(user.getName());
    registrationPage.setEmail(user.getEmail());
    registrationPage.setPassword(user.getPassword());
    registrationPage.clickButtonRegister();

    registrationPage.checkIncorrectPasswordError();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
