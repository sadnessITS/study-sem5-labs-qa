package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends AbstractPage {
    public static final String BASE_URL = "https://www.ihg.com/content/us/en/customer-care/main";
    private final Logger logger = LogManager.getRootLogger();

    public HelpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HelpPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
