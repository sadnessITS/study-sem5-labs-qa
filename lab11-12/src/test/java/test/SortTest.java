package test;

import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SortTest extends CommonConditions
{
    @Test(description = "TC_FS_3")
    public void TC_FS_3(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage
                .openPage()
                .searchDestination();
        searchPage.sortByLowToHigh();
        assertThat(searchPage.getCurrentSort().getText(), is(equalTo("Price : Low to High")));
    }
}
