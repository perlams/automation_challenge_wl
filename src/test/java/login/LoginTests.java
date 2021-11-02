package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DataProviderUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    //A. Login with a valid user
    @Test(dataProvider = "validCredentials", dataProviderClass = DataProviderUtil.class)
    public void testLogin_WithValidUser( String usernameString, String passwordString, String validateValue ){
        loginPage.navigateToLogin();
        loginPage.login(usernameString,passwordString);
        assertTrue(loginPage.getUrl().contains(validateValue)); //Validate against the actual URL

    }

    //B. Login with an invalid user
    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataProviderUtil.class)
    public void testLogin_WithInvalidUser(String usernameString, String passwordString, String validateValue){
        loginPage.navigateToLogin();
        loginPage.login(usernameString,passwordString);
        assertEquals(loginPage.getErrorMsg(),validateValue ); //Validate against the specific error message when using an invalid user

    }

    // Extra scenario: Login with a Locked user
    @Test(dataProvider = "lockedCredentials", dataProviderClass = DataProviderUtil.class)
    public void testLogin_WithLockedUser(String usernameString, String passwordString, String validateValue){
        loginPage.navigateToLogin();
        loginPage.login(usernameString,passwordString);
        assertEquals(loginPage.getErrorMsg(),validateValue); //Validate against the specific error message when using a locked user

    }

    //C. Logout from the home page
    @Test (dataProvider = "validCredentials", dataProviderClass = DataProviderUtil.class)
    public void testLogout(String usernameString, String passwordString, String validateValue){
        loginPage.navigateToLogin();
        HomePage homePage = loginPage.login(usernameString,passwordString);
        homePage.logout();
        assertTrue(loginPage.isLoginButtonDisplayed()); //Validate if the Login Button is displayed meaning that you got back to Login Page
    }



}
