package helpers;

import api.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static constants.ApiRoutes.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiHelper {

  private static String BASE_URI = "https://stellarburgers.nomoreparties.site";

  @Step("Создание пользователя")
  public static String createUser(User user) {
    return given()
      .baseUri(BASE_URI)
      .contentType("application/json")
      .body(user)
      .when()
      .post(USER_CREATE_ROUTE)
      .then()
      .statusCode(200)
      .extract()
      .path("accessToken");
  }

  @Step("Создание пользователя")
  public static Map<String,String> createUserAndGetAccessAndRefreshToken(User user) {
    Response response = given()
      .baseUri(BASE_URI)
      .contentType("application/json")
      .body(user)
      .when()
      .post(USER_CREATE_ROUTE);

    response.then().statusCode(200);
    String accessToken = response.then().extract().path("accessToken");
    String refreshToken = response.then().extract().path("refreshToken");
    return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
  }

  @Step("Удаление пользователя")
  public static void deleteUser(String bearerToken) {
    given()
      .baseUri(BASE_URI)
      .contentType("application/json")
      .header("Authorization", bearerToken)
      .when()
      .delete(USER_DELETE_ROUTE);
  }

  @Step("Логин пользователя")
  public static void loginUser(WebDriver driver, Map<String, String> authTokens) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript(
      String.format("window.localStorage.setItem('%s', '%s');", "accessToken", authTokens.get("accessToken")));
    js.executeScript(
      String.format("window.localStorage.setItem('%s', '%s');", "refreshToken", authTokens.get("refreshToken")));
  }

  @Step("Проверка корректного создания пользователя")
  public static String checkSuccessUserCreation(User user) {
   return given()
      .baseUri(BASE_URI)
      .contentType("application/json")
      .body(user)
      .when()
      .post(USER_LOGIN_ROUTE)
      .then()
      .statusCode(200)
      .body("user.email", equalTo(user.getEmail()))
      .body("user.name", equalTo(user.getName()))
      .extract()
      .path("accessToken");
  }
}
