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

public class SixSenses extends AbstractPage {
    private static final String BASE_URL = "https://www.sixsenses.com/en?scmisc=WEB-_-6C-_-GLO-_-EN-_-AWA-_-BrandsPage-_-PageCTA-_-SixSenses";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@href='/en/contact-us']")
    private WebElement contactButtonLocator;

    public SixSenses(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SixSenses openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public WebElement getContactButton() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(contactButtonLocator));
    }
}
