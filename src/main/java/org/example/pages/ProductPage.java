package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import org.openqa.selenium.By;

public class ProductPage {
   private SelenideElement buttonAddToCart = $x("(//div[text()='Dodaj do koszyka'])[2]");
   private SelenideElement startPrice = $x("(//div[@class='dt_price_change']//div)[3]");
   private SelenideElement monthlyPaymentAmount =$x("(.//div[@class='dt_price_change'])[4]");


   public void addToCart(){
      buttonAddToCart.shouldBe(visible, Duration.ofSeconds(5)).click();
   }

   public String getMonthlyPaymentAmountValue(){
      return monthlyPaymentAmount.getText().replace(" zł", "");
   }

   public  String getStartPriceValue() {
      return startPrice.getText().replace(" zł", "");
   }
}
