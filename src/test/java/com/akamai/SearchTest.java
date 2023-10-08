//package com.akamai;
//
//import com.akamai.helpers.AllureHelper;
//import com.akamai.page.SearchPage;
//import com.akamai.utils.DriverManager;
//import io.qameta.allure.Story;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
//import org.openqa.selenium.WebDriver;
//
//import static com.akamai.utils.ConfigManager.getConfig;
//
//public class SearchTest {
//    private WebDriver driver;
//    private SearchPage searchPage;
//    private AllureHelper allureHelper;
//
//
//    @BeforeMethod
//    public void setUp() {
//        driver = new DriverManager().getDriver();
//        allureHelper = new AllureHelper(driver);
//        driver.get(getConfig("url"));
//        searchPage = new SearchPage(driver);
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        if (!result.isSuccess()) {
//            allureHelper.takeScreenshot();
//        }
//        driver.quit();
//    }
//
//    @Story("Search for a job matching given criteria")
//    @Test(description = "Search for a job matching given criteria")
//    public void successJobSearch() {
//        searchPage.searchInput("Senior Software Development Engineer in Test");
//        searchPage.confirmCareerSuggestion();
//        searchPage.filterCountry("Poland");
//        searchPage.clickSearch();
//        searchPage.validateResults();
//    }
//
//    @Story("Customer is notified when no offers match given criteria")
//    @Test(groups = "2")
//    public void noResults() {
//        searchPage.searchInput("ABC");
//        searchPage.filterCountry("Poland");
//        searchPage.clickSearch();
//        searchPage.noResults();
//    }
//
//}
