package test;

import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MapTest extends CommonConditions
{
    @Test(description = "TC_FM_8")
    public void TC_FM_8(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage
                .openPage()
                .searchDestination();

        searchPage.openMap().selectHotel();
        assertThat(searchPage.getHotelLabelFromMap(), is(equalTo("Holiday Inn Express")));
    }
}
