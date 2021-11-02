package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.tagName("h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String usernameString) {
        driver.findElement(username).sendKeys(usernameString);
    }

    public void setPassword(String passwordString) {
      driver.findElement(password).sendKeys(passwordString);
    }

    public  void clickOnLoginButton(){
        driver.findElement(loginBtn).click();

    }

    public  HomePage login(String username, String password) {

        setUsername(username);
        setPassword(password);
        clickOnLoginButton();
        return new HomePage(driver);
    }

    public LoginPage navigateToLogin(){
        driver.get("https://www.saucedemo.com/");
        return new LoginPage(driver);

    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getErrorMsg(){
        return driver.findElement(errorMsg).getText();
    }

    public boolean isLoginButtonDisplayed(){
        return driver.findElement(loginBtn).isDisplayed();
    }


}
