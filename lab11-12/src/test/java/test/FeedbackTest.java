package test;

import org.testng.annotations.Test;
import page.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FeedbackTest extends CommonConditions
{
    @Test(description = "TC_FF_6")
    public void TC_FF_6(){
        HomePage homePage = new HomePage(driver);
        assertThat(homePage.openPage().isFeedbackClickable(), is(true));
    }
}