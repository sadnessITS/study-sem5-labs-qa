package test;

import org.testng.annotations.Test;
import page.BrandsPage;
import page.HomePage;
import page.SixSenses;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CollectionTest extends CommonConditions
{
    @Test(description = "TC_FC_1")
    public void TC_FC_1(){
        HomePage homePage = new HomePage(driver);
        BrandsPage brandsPage = new BrandsPage(driver);
        SixSenses sixSenses = new SixSenses(driver);
        homePage
                .openPage()
                .goToBrandsPage();
        brandsPage
                .clickToSixSenses();

        assertThat(sixSenses.getContactButton().isDisplayed(), is(true));
    }
}
