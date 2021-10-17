package com.tests;

import com.driver.DriverManager;
import com.pages.HomePage;
import com.pages.SearchResultsPage;
import com.utils.EnvConfig;
import com.utils.reports.ExtentTestManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseTest {

    SearchResultsPage searchResultsPage;
    HomePage homePage;
    SoftAssert softAssert;

    @Test(enabled = true)
    public void test_SearchQuery_ResultValidation() {
        ExtentTestManager.startTest("search engine validation", "search engine validation");
        searchResultsPage = new SearchResultsPage(DriverManager.getDriver());
        homePage = new HomePage(DriverManager.getDriver());
        softAssert = new SoftAssert();
        homePage.searchTerm(BaseTest.searchEngine, EnvConfig.getJsonElement("searchTerm_PhoneCat"));
        homePage.verifyUserLandedOnHomePage(BaseTest.searchEngine);
        softAssert.assertTrue(searchResultsPage.verifyFirstSearchResultIsCorrect(BaseTest.searchEngine, EnvConfig.getJsonElement("searchTerm_PhoneCat_expected")), "First Search result is not correct. Expected: " + EnvConfig.getJsonElement("searchTerm_PhoneCat_expected"));
        softAssert.assertAll();
    }
}
