import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TomatinaStartPage {
    private WebDriver driver;

    public TomatinaStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public TomatinaStartPage openTomatinaStartPage() {
        driver.get("https://tomatina.ua/");
        return this;
    }

    public FitSandwichesPage enterFitSandwitchesPage() {
        driver.findElement(By.xpath("//a[text() = 'Фіт сендвічі']")).click();
        return new FitSandwichesPage(driver);
    }
}
