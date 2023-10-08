package com.akamai.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;

public class DriverManager {

    private WebDriver driver;

    public DriverManager() {
        driver = createDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver createDriver() {
        var service = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
