package com.akamai.steps;

import com.akamai.page.SearchPage;
import com.akamai.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class StepDefs {

    private final SearchPage searchPage;

    public StepDefs(DriverManager driverManager) {
        WebDriver driver = driverManager.getDriver();
        searchPage = new SearchPage(driver);
    }

    @Given("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String arg0) {
        searchPage.searchInput(arg0);
    }

    @When("^I do search$")
    public void iDoSearch() {
        searchPage.confirmCareerSuggestion();
        searchPage.filterCountry("Poland");
        searchPage.clickSearch();
    }

    @Then("^I see valid results$")
    public void iSeeValidResults() {
        searchPage.validateResults();
    }
}
