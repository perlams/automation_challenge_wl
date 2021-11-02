package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage {
    private WebDriver driver;
    private By finishBtn = By.id("finish");
    private By cancelBtn = By.id("cancel");
    private By cartItem = By.className("cart_item");
    private By shippingInfLbl = By.className("summary_value_label");



    public CheckOutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutCompletePage clickFinish(){
        driver.findElement(finishBtn).click();
        return new CheckoutCompletePage(driver);
    }


}
