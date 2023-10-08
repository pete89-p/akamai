package com.akamai.hooks;

import com.akamai.utils.DriverManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static com.akamai.utils.ConfigManager.getConfig;

public class BeforeHooks {

    private final WebDriver driver;

    public BeforeHooks(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
    }

    @Before
    public void setup() {
        driver.get(getConfig("url"));
    }

}
