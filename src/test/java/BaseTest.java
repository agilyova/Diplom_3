import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
  String baseUrl = "https://stellarburgers.nomoreparties.site";

  private String baseDriver = "Chrome";
  Browser browser = Browser.YANDEX;

  WebDriver getBaseDriver() {
    if (baseDriver.equals("Firefox")) {
      WebDriver driver = new FirefoxDriver(new FirefoxOptions().addArguments("--start-maximized"));
      driver.manage().window().setSize(new Dimension(1920, 1080));
      return driver;
    } else {
      return new ChromeDriver(new ChromeOptions().addArguments("--window-size=1920,1080"));
    }
  }

  WebDriver getWebDriver() {
    switch (browser) {
      case CHROME:
        return new ChromeDriver(new ChromeOptions().addArguments("--window-size=1920,1080"));
      case YANDEX:
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\bin\\yandexdriver.exe");
        return new ChromeDriver(options);
      default:
        throw new IllegalArgumentException("Unsupported browser " + browser);
    }
  }
}