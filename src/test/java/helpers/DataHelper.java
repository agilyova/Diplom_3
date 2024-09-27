package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
  public static String getEmail() {
    Faker faker = new Faker(new Locale("en"));
    return faker.internet().emailAddress();
  }

  public static String getPassword(int passwordLength) {
    return new Faker().internet().password(passwordLength, passwordLength + 1);
  }

  public static String getName() {
    return new Faker().name().firstName();
  }
}
