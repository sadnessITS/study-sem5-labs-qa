package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.ihg.com";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void changeLocalizationToRu() {
        WebElement localizationMenuButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='language-text nav-middle']")));
        localizationMenuButton.click();
        driver.findElement(By.id("uhfLanguageSelection")).click();
        driver.findElement(By.xpath("//option[text()='Russian / русский']")).click();
        driver.findElement(By.xpath("//option[text()='Russian / русский']")).click();
        WebElement saveLocalizationButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='buttonSave']")));
        saveLocalizationButton.click();
    }
}
