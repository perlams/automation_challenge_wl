package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][]{{"standard_user", "secret_sauce", "inventory.html"}};
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{{"anystring", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}};
    }

    @DataProvider(name = "lockedCredentials")
    public Object[][] lockedCredentials() {
        return new Object[][]{{"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}};
    }

    @DataProvider(name = "sortItems")
    public Object[][] sortItems() {
        return new Object[][]{{"standard_user", "secret_sauce", "Price (low to high)", "Sauce Labs Onesie"}};
    }

}
