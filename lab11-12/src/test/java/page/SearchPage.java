package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends AbstractPage
{
    private static final String BASE_URL = "https://www.ihg.com/hotels/gb/en/find-hotels/hotel/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[@class='dph-cta' and @data-slnm-ihg='currencyConverterDropdownComponent']")
    private WebElement currencyMenuLocator;

    @FindBy(xpath = "//button[@class='dph-cta' and @data-slnm-ihg='SortByOptions']")
    private WebElement sortMenuLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[3]/sort-by-selector/hotel-sort-filter-dropdown/div/form/div[4]")
    private WebElement sortLowToHighLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[3]/sort-by-selector/hotel-sort-filter-dropdown/div/button/span[2]")
    private WebElement sortText;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[3]/hotel-currency-selector/div/hotel-sort-filter-dropdown/div/form/div[1]")
    private WebElement usdButtonLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[3]/hotel-currency-selector/div/hotel-sort-filter-dropdown/div/form/div[11]")
    private WebElement arsButtonLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[3]/hotel-currency-selector/div/hotel-sort-filter-dropdown/div/form/div[2]")
    private WebElement eurButtonLocator;

    @FindBy(xpath = "//span[@class='hSixBold themeText toggle-label lvp' and text()='Filters']")
    private WebElement filterButtonLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[2]/amenities-selector/div/div[2]/div[1]")
    private WebElement wifiFilterButton;

    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyFilterButtonLocator;

    @FindBy(xpath = "//span[@class='ng-star-inserted' and @dir='ltr']")
    private WebElement labelAmountHotelsLocator;

    @FindBy(xpath = "//button[@class='tonMapListToggle themeBorder themeText ng-star-inserted' and @data-slnm-ihg='mapViewButton']")
    private WebElement mapButtonLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/hotel-map-view/div[2]/hotel-offers-map-view/div/div/hotel-offers-map/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[2]")
    private WebElement hotelPointButtonLocator;

    @FindBy(xpath = "//span[@class='ng-star-inserted' and @data-slnm-ihg='hotelBrand']")
    private WebElement selectedHotelLabelLocator;

    @FindBy(xpath = "//h1[@data-slnm-ihg='hotelBrandName']")
    private WebElement labelHotelLocator;

    @FindBy(xpath = "//button[@class='btn btn-link btn-link-va link-va-6c' and @data-slnm-ihg='VirtualAssistantLinkSID']")
    private WebElement virtualAssistantButtonLocator;

    @FindBy(xpath = "/html/body/div[1]/div/find-hotels-root/ng-component/div[2]/div[1]/hotel-sort-filter/div/div/div[2]/amenities-selector/div/div[1]/div[2]/button")
    private WebElement selectAllButtonLocator;

    private By currentCurrencyLocator = By.xpath("//span[@class='price-currency pFourteen']");

    public SearchPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SearchPage changeCurrencyToUsd()
    {
        WebElement currencyMenuButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(currencyMenuLocator));
        currencyMenuButton.click();
        WebElement usdButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(usdButtonLocator));
        usdButton.click();
        logger.info("Currency was changed to USD");
        return new SearchPage(driver);
    }

    public SearchPage sortByLowToHigh()
    {
        WebElement sortMenuButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sortMenuLocator));
        sortMenuButton.click();
        logger.info("Sort menu is opened");
        WebElement sortLowToHighButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sortLowToHighLocator));
        sortLowToHighButton.click();
        logger.info("Sort is set to Low to High");
        return new SearchPage(driver);
    }

    public SearchPage openFilters()
    {
        WebElement filterButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(filterButtonLocator));
        filterButton.click();
        logger.info("Filters are open");
        return new SearchPage(driver);
    }

    public SearchPage filterByWifi()
    {
        wifiFilterButton.click();
        WebElement applyFilterButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyFilterButtonLocator));
        logger.info("Wifi is selected");
        return new SearchPage(driver);
    }

    public WebElement getSelectAllFiltersButton()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectAllButtonLocator));
    }

    public WebElement getLabelAmountHotels()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelAmountHotelsLocator));
    }

    public WebElement getCurrentSort()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sortText));
    }

    public WebElement getCurrentCurrency()
    {
        WebElement currentCurrency = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(currentCurrencyLocator));
        return currentCurrency;
    }

    public SearchPage openMap()
    {
        WebElement mapButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(mapButtonLocator));
        mapButton.click();
        logger.info("Map was opened");
        return new SearchPage(driver);
    }

    public SearchPage selectHotel()
    {
        WebElement hotelPointButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(hotelPointButtonLocator));
        hotelPointButton.click();
        logger.info("Hotel is selected");
        return new SearchPage(driver);
    }

    public String getHotelLabelFromMap()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectedHotelLabelLocator)).getText();
    }

    public HelpPage goToVirtualAssistant()
    {
        WebElement virtualAssistantButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(virtualAssistantButtonLocator));
        virtualAssistantButton.click();
        logger.info("Virtual Assistant was clicked");
        return new HelpPage(driver);
    }
}
