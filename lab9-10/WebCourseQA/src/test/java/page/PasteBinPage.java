package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinPage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    private static final String mainInputAreaId = "postform-text";
    private static final String syntaxFormatListId = "select2-postform-format-container";
    private static final String expirationListId = "select2-postform-expiration-container";
    private static final String pasteNameAreaId = "postform-name";

    public PasteBinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteBinPage openRaw() {
        WebElement openRawButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='raw' and @class='btn -small']")));
        openRawButton.click();
        return this;
    }

    public PasteBinPage inputMessage(String message) {
        driver.findElement(By.id(mainInputAreaId)).sendKeys(message);
        return this;
    }

    public PasteBinPage setBashSyntax()
    {
        driver.findElement(By.id(syntaxFormatListId)).click();
        String selectedSyntaxFormat = "//li[text()='Bash']";
        driver.findElement(By.xpath(selectedSyntaxFormat)).click();
        return this;
    }

    public PasteBinPage setExpirationTimeToTenMinutes() {
        driver.findElement(By.id(expirationListId)).click();
        String selectedTimeBlock = "//li[text()='10 Minutes']";
        driver.findElement(By.xpath(selectedTimeBlock)).click();
        return this;
    }

    public PasteBinPage setPasteName(String pasteName) {
        driver.findElement(By.id(pasteNameAreaId)).sendKeys(pasteName);
        return this;
    }
    public PasteBinPage pressConfirmButton() {
        WebElement confirmButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn -big']")));
        confirmButton.click();
        return this;
    }
    public boolean isSuccessConfirmationForICanWin() {
        String successNoteXpath = "//div[@class='notice -success -post-view']";
        return driver.findElement(By.xpath(successNoteXpath)).isDisplayed();
    }
    public String getCodeText() {
        return driver.findElement(By.xpath("/html/body/pre")).getText();
    }
}
