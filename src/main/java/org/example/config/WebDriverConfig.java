package org.example.config;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {


  private static WebDriver driver;
  public static void configure() {
    Configuration.browser = "chrome";
    Configuration.holdBrowserOpen = false;
    open();
    getWebDriver().manage().window().maximize();
  }

  public static void tearDown(){
   getWebDriver().close();
   getWebDriver().quit();
  }
}
