package test;

import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterTest extends CommonConditions
{
    @Test(description = "TC_FT_4")
    public void TC_FT_4(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage
                .openPage()
                .searchDestination();
        searchPage
                .openFilters()
                .filterByWifi();
        assertThat(searchPage.getLabelAmountHotels().getText(), not(equalTo(" 0 Hotels Found ")));
    }
}
