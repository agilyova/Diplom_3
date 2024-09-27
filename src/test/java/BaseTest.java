import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
  String baseUrl = "https://stellarburgers.nomoreparties.site";
  String browserWindowSize = "--window-size=1920,1080";

  Browser browser = Browser.CHROME;
  String pathToYandexDriver = "C:\\Users\\Aleksandra\\WebDriver\\bin\\yandexdriver.exe";

  WebDriver getBaseDriver() {
    switch (browser) {
      case CHROME:
        return new ChromeDriver(new ChromeOptions().addArguments(browserWindowSize));
      case YANDEX:
        ChromeOptions options = new ChromeOptions();
        options.addArguments(browserWindowSize);
        System.setProperty("webdriver.chrome.driver", pathToYandexDriver);
        return new ChromeDriver(options);
      default:
        throw new IllegalArgumentException("Unsupported browser " + browser);
    }
  }
}