package org.example.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class SmartWatchesPage {

  private SelenideElement firstSmartWatch = $x("//div[@data-qa='LST_ProductCard0']//a[1]");
  private ElementsCollection linklist = $$x("//*[contains(@data-qa, 'LST_ProductCard')]");


  public void selectFirstSmartWatches(){
    linklist.get(0).shouldBe(visible, Duration.ofSeconds(5)).click();

  }
}


