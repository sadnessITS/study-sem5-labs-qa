package test;

import org.testng.annotations.Test;
import page.HelpPage;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AssistantTest extends CommonConditions
{
    @Test(description = "TC_FV_9")
    public void TC_FV_9(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage
                .openPage()
                .searchDestination();

        searchPage.goToVirtualAssistant();
        assertThat(driver.getCurrentUrl(), is(equalTo(HelpPage.BASE_URL)));
    }
}
