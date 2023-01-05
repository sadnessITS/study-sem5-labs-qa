package test;

import org.testng.annotations.Test;
import page.HelpPage;
import page.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HelpTest extends CommonConditions
{
    @Test(description = "TC_FH_7")
    public void TC_FH_7()
    {
        HomePage homePage = new HomePage(driver);
        homePage
                .openPage()
                .goToHelpPage();

        assertThat(driver.getCurrentUrl(), is(equalTo(HelpPage.BASE_URL)));
    }
}