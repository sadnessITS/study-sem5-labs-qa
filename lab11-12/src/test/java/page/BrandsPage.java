package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrandsPage extends AbstractPage
{
    private static final String BASE_URL = "https://www.ihg.com";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@href='https://www.sixsenses.com/en?scmisc=WEB-_-6C-_-GLO-_-EN-_-AWA-_-BrandsPage-_-PageCTA-_-SixSenses']")
    private WebElement sixSensesLocator;
    public BrandsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public BrandsPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
    public void clickToSixSenses() {
        WebElement sixSensesButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sixSensesLocator));
        sixSensesButton.click();
        logger.info("Page is switched to SixSenses");
    }
}
