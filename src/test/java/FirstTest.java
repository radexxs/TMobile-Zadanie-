import org.example.config.WebDriverConfig;
import org.example.pages.CartPage;
import org.example.pages.ProductPage;
import org.example.pages.SmartWatchesPage;
import org.example.pages.HomePage;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {


  HomePage homePage = new HomePage();
  SmartWatchesPage smartWatchesPage = new SmartWatchesPage();
  ProductPage productPage = new ProductPage();
  CartPage cartPage = new CartPage();

  public static final String URL = "https://www.t-mobile.pl/";

  @Before
  public void setUp() {
    WebDriverConfig.configure();
    }

 @After
 public void quit(){
   WebDriverConfig.tearDown();
 }

  @Test
  public void firstTest(){
    open(URL);
    homePage.navigateToSmartWatches();
    smartWatchesPage.selectFirstSmartWatches();
    String promisedStartPrice = productPage.getStartPriceValue();
    String promisedMonthlyPaymentAmount = productPage.getMonthlyPaymentAmountValue();
    productPage.addToCart();
    String cartStartPrice = cartPage.getStartPriceValue();
    String cartMonthlyPaymentAmount = cartPage.getMonthlyPaymentAmountValue();
    Assert.assertEquals(promisedStartPrice, cartStartPrice);
    Assert.assertEquals(promisedMonthlyPaymentAmount, cartMonthlyPaymentAmount);
    open(URL);
    Assert.assertEquals("1", homePage.getBasketIconProductQuantity());
  }
}
