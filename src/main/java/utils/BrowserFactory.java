package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.HashMap;
import java.util.Map;


public class BrowserFactory {

    public static WebDriver GetBrowser(String browserName) {
        browserName = browserName.toLowerCase();

        if(browserName.equals("chrome"))
            return getChromeInstance();

        if(browserName.equals("edge"))
            return getEdgeInstance();

        else
            return getFFInstance();
    }


    private static FirefoxDriver getFFInstance() {

        System.setProperty("webdriver.gecko.driver", "/Users/perlams/IdeaProjects/automation_challenge/src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette",true);
        options.setHeadless(true); //Comment this line in order to run opening the browser
        FirefoxDriver driver = new FirefoxDriver(options);
        return driver;
    }

    private static ChromeDriver getChromeInstance() {

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("incognito");
        options.addArguments("headless");  //Comment this line in order to run opening the browser
        System.setProperty("webdriver.chrome.driver", "/Users/perlams/IdeaProjects/automation_challenge/src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }



    public static EdgeDriver getEdgeInstance() {
        System.setProperty("webdriver.edge.driver", "/Users/perlams/IdeaProjects/automation_challenge/src/main/resources/msedgedriver");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("incognito");
        options.addArguments("headless");  //Comment this line in order to run opening the browser
        EdgeDriver driver = new EdgeDriver(options);

        return driver;
    }

}