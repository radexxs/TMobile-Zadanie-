import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.WebDriverConfig;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.ProductPage;
import org.example.pages.SmartWatchesPage;
import org.junit.Assert;

public class MyStepdefs {


  HomePage homePage = new HomePage();
  SmartWatchesPage smartWatchesPage = new SmartWatchesPage();
  ProductPage productPage = new ProductPage();
  CartPage cartPage = new CartPage();
  String promisedStartPrice;
  String promisedMonthlyPaymentAmount;
  String cartStartPrice;
  String cartMonthlyPaymentAmount;

  @Given("Użytkownik otwiera przeglądarkę i przechodzi na stronę T-Mobile")
  public void użytkownikOtwieraPrzeglądarkęIPrzechodziNaStronęTMobile() {
    WebDriverConfig.configure();
    open("https://www.t-mobile.pl/");
  }

  @When("Użytkownik wybiera sekcję Urządzenia i wybiera te bez abonamentu")
  public void użytkownikWybieraSekcjęUrządzenia() {
    homePage.navigateToSmartWatches();
  }

  @And("Użytkownik kliknie w pierwszy produkt z listy")
  public void użytkownikKliknieWPierwszyProduktZListy() {
    smartWatchesPage.selectFirstSmartWatches();
    promisedStartPrice = productPage.getStartPriceValue();
    promisedMonthlyPaymentAmount = productPage.getMonthlyPaymentAmountValue();
  }


  @And("Użytkownik dodaje pierwszy z listy produkt do koszyka")
  public void użytkownikDodajeProduktDoKoszyka() {
    productPage.addToCart();
  }

  @Then("Strona Twój koszyk zostaje wyświetlona z odpowiednimi kwotami")
  public void stronaTwójKoszykZostajeWyświetlonaZOdpowiednimiKwotami() {
    cartStartPrice = cartPage.getStartPriceValue();
    cartMonthlyPaymentAmount = cartPage.getMonthlyPaymentAmountValue();
    Assert.assertEquals(promisedStartPrice, cartStartPrice);
    Assert.assertEquals(promisedMonthlyPaymentAmount, cartMonthlyPaymentAmount);
  }

  @When("Użytkownik wraca na stronę główną T-Mobile")
  public void użytkownikWracaNaStronęGłównąTMobile() {
    open("https://www.t-mobile.pl/");
  }

  @Then("Widoczna jest ikonka koszyka z liczbą produktów w koszyku")
  public void widocznaJestIkonkaKoszykaZLiczbąProduktówWKoszyku() {
    Assert.assertEquals("1", homePage.getBasketIconProductQuantity());
  }

  @And("Użytkownik zamyka przeglądarke")
  public void użytkownikZamykaPrzeglądarke() {
    WebDriverConfig.tearDown();
    WebDriverRunner.closeWebDriver();
  }
}
