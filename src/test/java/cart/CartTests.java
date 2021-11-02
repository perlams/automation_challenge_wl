package cart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.DataProviderUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends BaseTests {
    //E. Add multiple items to the shopping cart
   @Test(dataProvider = "sortItems", dataProviderClass = DataProviderUtil.class)
    public void testAddItemsToCart(String usernameString, String passwordString, String option, String
            validateValue ){
        loginPage.navigateToLogin();
        HomePage home = loginPage.login(usernameString, passwordString);
        home.addToCartMultipleItems();
        CartPage cart = home.clickOnCartLink();
        assertTrue(cart.getCartUrl().contains("cart.html"));
        assertEquals(cart.getCartQuantityItems(),6);
    }

    //F. Add the specific product ‘Sauce Labs Onesie’ to the shopping cart
    @Test(dataProvider = "sortItems", dataProviderClass = DataProviderUtil.class)
    public void testAddAnSpecificSingleItem(String usernameString, String passwordString, String option, String
            validateValue ) throws InterruptedException {
        loginPage.navigateToLogin();
        HomePage home = loginPage.login(usernameString, passwordString);
        home.clearCart();
        home.clickOnLowToHighOption(option);
        CartPage cart = home.addToCartSingleItem();
        home.clickOnCartLink();
        assertTrue(cart.getCartUrl().contains("cart.html"));
        assertEquals(cart.getItemTitle(),"Sauce Labs Onesie");

    }


}
