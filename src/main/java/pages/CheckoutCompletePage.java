package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;
    private By thankyouOrderMsg = By.tagName("h2");
    private By ponyImg = By.className("pony_express");
    private By backHomeBtn = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMsg(){
       return driver.findElement(thankyouOrderMsg).getText();
    }

    public boolean isImageDisplayed(){
        return driver.findElement(ponyImg).isDisplayed();
    }
}
