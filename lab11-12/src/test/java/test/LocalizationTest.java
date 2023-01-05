package test;

import org.testng.annotations.Test;
import page.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LocalizationTest extends CommonConditions
{
    @Test(description = "TC_FS_5")
    public void TC_FS_5(){
        HomePage homePage = new HomePage(driver);
        homePage
                .openPage()
                .changeLocalizationToRu();

        assertThat(homePage.getCountryMenuButton().getText(), is(equalTo("РУССКИЙ")));
    }
}

