package test;

import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SelectAllTest extends CommonConditions {
    @Test(description = "TC_FD_10")
    public void TC_FD_10() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage
                .openPage()
                .searchDestination();
        assertThat(searchPage.openFilters().getSelectAllFiltersButton().getText(), is(equalTo("Select All")));
    }
}
