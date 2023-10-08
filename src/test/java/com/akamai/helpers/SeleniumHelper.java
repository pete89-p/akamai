package com.akamai.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    private final WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Explicit wait used before actions to set up the test correctly and stable
     * @param element - WebElement
     * @param timeout - the amount of time provided in seconds to wait before TimeOutException is thrown
     */
    protected void waitForElement(WebElement element, int timeout) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Simple click method
     * @param element - WebElement
     * @param timeout - the amount of time provided in seconds to wait before TimeOutException is thrown
     */
    public void click(WebElement element, int timeout) {
        waitForElement(element, timeout);
        element.click();
    }

    public void fillInput(WebElement element, String text, int timeout) {
        waitForElement(element, timeout);
        element.clear();
        element.sendKeys(text);
    }

}
