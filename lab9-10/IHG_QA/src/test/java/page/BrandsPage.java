package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrandsPage {
    private WebDriver driver;
    private static final String BRANDS_URL = "https://www.ihg.com/content/gb/en/about/brands";

    public BrandsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BrandsPage openBrandsPage() {
        driver.get(BRANDS_URL);
        return this;
    }

    public void clickToSixSenses() {
        WebElement brandButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.sixsenses.com/en?scmisc=WEB-_-6C-_-GLO-_-EN-_-AWA-_-BrandsPage-_-PageCTA-_-SixSenses']")));
        brandButton.click();
    }
}
