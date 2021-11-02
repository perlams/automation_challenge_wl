package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.BrowserFactory;

import java.time.Duration;

public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser){
    //public void setUp(){
        driver = BrowserFactory.GetBrowser(browser);
        //driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "/Users/perlams/IdeaProjects/automation_challenge/src/main/resources/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        loginPage = new LoginPage(driver);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
