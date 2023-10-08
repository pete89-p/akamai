package com.akamai.page;

import com.akamai.helpers.SeleniumHelper;
import com.akamai.interfaces.SearchForm;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.AssertJUnit.*;

// page_url = https://akamaicareers.inflightcloud.com/
public class SearchPage extends SeleniumHelper implements SearchForm {

    private final WebDriver driver;

    @FindBy(css = "[id=\"keywordLocation\"]")
    private WebElement inputSearch;

    @FindBy(css = "[id=\"location\"]")
    private WebElement inputCountry;

    @FindBy(css = "[controlid=\"keywordLocation\"] button")
    private WebElement buttonSearch;

    @FindBy(css = ".count-and-sort span")
    private WebElement resultsCounter;

    private String suggestionRes = "//*[@id=\"keywordLocation_list\"]/li[text()=\" FIND \"]";
    private String locSuggestion = "//*[@id=\"location_list\"]/li[text()=\" COUNTRY \"]";

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Fill career input")
    public void searchInput(String text) {
        suggestionRes = suggestionRes.replace("FIND", text.toLowerCase());
        fillInput(inputSearch, text, 10);
    }

    @Step("Confirm suggestion in career input")
    public void confirmCareerSuggestion() {
        WebElement suggestionResult = driver.findElement(By.xpath(suggestionRes));
        click(suggestionResult, 10);
    }


    @Override
    @Step("Fill location input")
    public void filterCountry(String country) {
        locSuggestion = locSuggestion.replace("COUNTRY", country);
        fillInput(inputCountry, country, 10);
        WebElement locationSuggestion = driver.findElement(By.xpath(locSuggestion));
        click(locationSuggestion, 10);
    }

    @Step("Click search button")
    public void clickSearch() {
        click(buttonSearch, 10);
    }

    @Step("Validate results list for right search")
    public void validateResults() {
        // Local declaration of selector because it's used only by this method
        String results = "[id=\"results\"] [aria-labelledby=\"header-titler\"]";
        // Waiting foe actual results with jobs
        WebElement res = driver.findElement(By.cssSelector(results));
        waitForElement(res, 10);
        // Validating if a list with results has one or more elements
        List<WebElement> resultList = driver.findElements(By.cssSelector(results));
        assertFalse(resultList.isEmpty());
    }

    @Step("Validate results for not matching criteria")
    public void noResults() {
        String expectedText = "We found 0 jobs based on your search criteria";
        String actualText = resultsCounter.getText();
        assertEquals(actualText, expectedText);
    }
}
