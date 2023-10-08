package com.akamai.hooks;

import com.akamai.utils.DriverManager;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class AfterHooks {

    private final WebDriver driver;

    public AfterHooks(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
