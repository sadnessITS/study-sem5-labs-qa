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
import page.BrandsPage;

import java.time.Duration;

public class CollectionTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new FirefoxDriver();
    }

    @Test(description = "TC_FC_1")
    public void TC_FC_1(){
        HomePage homePage = new HomePage(driver);
        BrandsPage brandsPage = new BrandsPage(driver);
        homePage
                .openHomePage()
                .openBrandsPage();
        brandsPage
                .clickToSixSenses();
        WebElement isAnyBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/en/contact-us']")));
        Assert.assertTrue(isAnyBtn.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void browserShoutDown(){
        driver.quit();
        driver = null;
    }
}
