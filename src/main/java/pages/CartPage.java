package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By cartItem = By.className("cart_item");
    private By continueBtn = By.id("continue-shopping");
    private By removeBtn = By.className("button.cart_button");
    private By checkoutBtn = By.id("checkout");
    private By cartItemTitle = By.className("inventory_item_name");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartUrl(){
        return driver.getCurrentUrl();

    }

    public String getItemTitle(){
        return driver.findElement(cartItemTitle).getText();
    }

    public int getCartQuantityItems(){
        return driver.findElements(cartItem).size();
    }

    public CheckOutStepOnePage clickCheckOutBtn(){
         driver.findElement(checkoutBtn).click();
        return new CheckOutStepOnePage(driver);
    }


}
