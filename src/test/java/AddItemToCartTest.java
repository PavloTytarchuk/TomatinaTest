import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddItemToCartTest {
    static WebDriver driver;
    private final String chickenSandwich = "Фіт сендвіч з куркою";

    @BeforeSuite
    protected void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void addItemToCart() {
        TomatinaStartPage tomatinaStartPage = new TomatinaStartPage(driver);
        tomatinaStartPage.openTomatinaStartPage();
        FitSandwichesPage fitSandwichesPage = tomatinaStartPage.enterFitSandwitchesPage();
        ProductOverviewPage productOverviewPage = fitSandwichesPage.enterProductOverviewPage(chickenSandwich);
        productOverviewPage.clickAddToCartButton();
        CartPage cartPage = productOverviewPage.enterCartPage();
        Assert.assertTrue(cartPage.isElementPresent(cartPage.cartItem(chickenSandwich)));
    }

    @AfterSuite
    protected void closeBrowser() {
        driver.close();
    }
}
