package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
  private SelenideElement devicesLink = $x("//button[text()='Urządzenia']");
  private SelenideElement smartWatchesLink = $x("(//span[text()='Bez abonamentu'])[2]");
  private SelenideElement basketIconProductQuantity = $x("//a[@data-ma='menu-basket']//div");
  private SelenideElement buttonAccept = $(By.id("didomi-notice-agree-button"));


  public void navigateToSmartWatches(){
    buttonAccept.shouldBe(visible, Duration.ofSeconds(5)).click();
    devicesLink.shouldBe(visible, Duration.ofSeconds(5)).click();
    smartWatchesLink.shouldBe(visible,Duration.ofSeconds(5)).click();
  }

  public String getBasketIconProductQuantity(){
    return basketIconProductQuantity.shouldBe(visible, Duration.ofSeconds(5)).getText();
  }

}
