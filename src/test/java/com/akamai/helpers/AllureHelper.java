package com.akamai.helpers;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureHelper {

    private final WebDriver driver;

    public AllureHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        byte[] scr = screenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(scr));
    }

}
