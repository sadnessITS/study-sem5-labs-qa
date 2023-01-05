package test;

import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CurrencyTest extends CommonConditions
{
    @Test(description = "TC_FC_2")
    public void TC_FC_2(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage
                .openPage()
                .searchDestination();
        searchPage.changeCurrencyToUsd();
        assertThat(searchPage.getCurrentCurrency().getText(), is(equalTo("USD")));
    }
}
