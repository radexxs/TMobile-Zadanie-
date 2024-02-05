package org.example.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

public class SmartWatchesPage {
  private ElementsCollection firstSmartWatch = $$x("//*[contains(@data-qa, 'LST_ProductCard')]");


  public void selectFirstSmartWatches(){
    firstSmartWatch.get(0).shouldBe(visible, Duration.ofSeconds(5)).click();
  }
}


