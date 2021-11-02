package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage {
    private WebDriver driver;
    private By firstNameTxtField = By.id("first-name");
    private By lastNameTxtField = By.id("last-name");
    private By zipcodeTxtField = By.id("postal-code");
    private By cancelBtn = By.id("cancel");
    private By continueBtn = By.id("continue");
    private By errorMsg = By.cssSelector(".error>h3");

    public CheckOutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckOutStepTwoPage fillForm(){
        driver.findElement(firstNameTxtField).sendKeys("John");
        driver.findElement(lastNameTxtField).sendKeys("Doe");
        driver.findElement(zipcodeTxtField).sendKeys("12312");
        driver.findElement(continueBtn).click();

        return new CheckOutStepTwoPage(driver);

    }
}
