import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductOverviewPage {
    WebDriver driver;

    public ProductOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductOverviewPage clickAddToCartButton() {
        driver.findElement(By.xpath("//button[text() = 'Додати в кошик']")).click();
        return this;
    }

    public CartPage enterCartPage() {
        driver.findElement(By.xpath("//a[text() = 'Перейти до кошика']")).click();
        return new CartPage(driver);
    }
}
