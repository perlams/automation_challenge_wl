package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;


public class HomePage {

    private WebDriver driver;
    private By burguerBtn = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By filterIcon = By.className("select_container");
    private By dropdown = By.className("product_sort_container");
    List<WebElement> itemTitle = null;
    List<WebElement> addToCartBtnAllItems = null;
    private By specificItem = By.id("add-to-cart-sauce-labs-onesie");
    private By firstListItem = By.className("inventory_item_name");
    private By titlePage = By.className("title");
    private  By cartLink = By.className("shopping_cart_link");
    private By oneSieItemLink = By.id("item_2_title_link");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        addToCartBtnAllItems = driver.findElements(By.className("btn_inventory"));
        itemTitle = driver.findElements(By.className("inventory_item_name"));

    }

    public void logout(){
        driver.findElement(burguerBtn).click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementNotInteractableException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));

        driver.findElement(logoutLink).click();
    }

    public void selectFormDropDown(String label){
        Select dropdownElement = new Select(driver.findElement(dropdown));
        dropdownElement.selectByVisibleText(label);
    }

    public void clickOnLowToHighOption(String option){
        driver.findElement(filterIcon).click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(dropdown)));
        selectFormDropDown(option);

    }

    public CartPage clickOnCartLink(){
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    public void clearCart(){

        for(WebElement element: addToCartBtnAllItems){
            element.click();
        }

    }

    public void clickOnAddToCart(){
        for(WebElement element: addToCartBtnAllItems){
           element.click();
        }

    }

    public void selectSpecificItem(){
        driver.findElement(firstListItem).click();

    }

    public CartPage addToCartSingleItem(){
        selectSpecificItem();
        driver.findElement(specificItem).click();

        return new CartPage(driver);
    }

    public String getFirstItemTitle(){
        return driver.findElement(firstListItem).getText();
    }

   public HomePage addToCartMultipleItems(){
       clickOnAddToCart();
        return new HomePage(driver);
    }
}
