package checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;
import utils.DataProviderUtil;

import static org.testng.Assert.*;

public class OrdersTests extends BaseTests {

    //G. Complete a purchase
    @Test(dataProvider = "sortItems", dataProviderClass = DataProviderUtil.class)
    public void testCompleteAPurchase(String usernameString, String passwordString, String option, String
            validateValue){
        loginPage.navigateToLogin();
        HomePage home = loginPage.login(usernameString, passwordString);
        home.addToCartMultipleItems();
        CartPage cart = home.clickOnCartLink();
        CheckOutStepOnePage stepOne = cart.clickCheckOutBtn();
        CheckOutStepTwoPage stepTwo = stepOne.fillForm();
        CheckoutCompletePage completeOrder = stepTwo.clickFinish();
        assertTrue(completeOrder.isImageDisplayed());
        assertEquals(completeOrder.getConfirmationMsg(),"THANK YOU FOR YOUR ORDER");

    }

}
