package home;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DataProviderUtil;

import static org.testng.Assert.assertEquals;


public class HomeTests extends BaseTests {

    //D. Sort products by Price (low to high)
    @Test(dataProvider = "sortItems", dataProviderClass = DataProviderUtil.class)
    public void testSortProductsLowToHigh( String usernameString, String passwordString, String option, String validateValue ){
        loginPage.navigateToLogin();
        HomePage home = loginPage.login(usernameString,passwordString);
        home.clickOnLowToHighOption(option);
        assertEquals(home.getFirstItemTitle(),validateValue); //Validate against the expected title of the cheapest item

    }
}
