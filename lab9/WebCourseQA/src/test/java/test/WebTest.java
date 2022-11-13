package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PasteBinPage;

import java.time.Duration;

public class WebTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new FirefoxDriver();
    }

    @Test(description = "I Can Win")
    public void ICanWin(){
        PasteBinPage pasteBinPage = new PasteBinPage(driver);
        pasteBinPage.openPage().inputMessage("Hello from WebDriver")
                .setBashSyntax()
                .setExpirationTimeToTenMinutes()
                .setPasteName("helloweb")
                .pressConfirmButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='raw' and @class='btn -small']")));

        Assert.assertTrue(pasteBinPage.isSuccessConfirmationForICanWin(), "Confirmation is not successful!!!");
    }

    @Test(description = "Bring It On")
    public void BringItOn() {
        PasteBinPage pasteBinPage = new PasteBinPage(driver);
        String inputMessage =   "git config --global user.name  \"New Sheriff in Town\"\n" +
                                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                "git push origin master --force";

        pasteBinPage.openPage().inputMessage(inputMessage)
                .setBashSyntax()
                .setExpirationTimeToTenMinutes()
                .setPasteName("how to gain dominance among developers")
                .pressConfirmButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='raw' and @class='btn -small']")));

        Assert.assertEquals("how to gain dominance among developers - Pastebin.com", driver.getTitle());
        Assert.assertEquals("Bash", driver.findElement(By.xpath("//a[@class='btn -small h_800']")).getText());
        Assert.assertEquals(pasteBinPage.openRaw().getCodeText(), inputMessage);
    }
	
    @AfterMethod(alwaysRun = true)
    public void browserShoutDown(){
        driver.quit();
        driver = null;
    }
}
