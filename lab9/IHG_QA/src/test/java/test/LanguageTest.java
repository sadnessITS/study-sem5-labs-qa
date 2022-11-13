package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

import java.time.Duration;

public class LanguageTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new FirefoxDriver();
    }

    @Test(description = "TC_FS_5")
    public void TC_FS_5(){
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage().
                changeLocalizationToRu();

        WebElement localizationMenuButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='language-text nav-middle']")));
        Assert.assertEquals(localizationMenuButton.getText(), "РУССКИЙ");
    }

    @AfterMethod(alwaysRun = true)
    public void browserShoutDown(){
        driver.quit();
        driver = null;
    }
}
