import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FitSandwichesPage {
    WebDriver driver;

    public FitSandwichesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductOverviewPage enterProductOverviewPage(String productName) {
        driver.findElement(By.xpath(String.format("//h2[text() = '%s']", productName))).click();
        return new ProductOverviewPage(driver);
    }
}
