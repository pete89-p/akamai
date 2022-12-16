package com.akamai.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.akamai.utils.ConfigManager.getConfig;

public class WebDriverManager {

    private WebDriver driver;


    public WebDriverManager() {
        driver = createDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", getConfig("chromeDriverPath"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
