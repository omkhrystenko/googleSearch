package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleSearchPage1;
import page.GoogleSearchPage2;

import java.util.List;

/**
 * CheckSearchTest Object class.
 */
public class CheckSearchTest extends CheckSearchBaseTest  {
    @DataProvider
    public Object[][] searchDataProviderCaseSensetive() {
        return new Object[][]{
                {"Selenium"},
                {"selenium"},
                {"seleNium"},
                {"SELENIUM"}
        };
    }

    /**
     * Verify cases that search data on Google main page
     *
     * Preconditions
     * - Open new browser.
     * - Navigate to google.com
     *
     * Scenario
     * - Verify that main page is loaded.
     * - Enter search word and submit.
     * - Verify  page with search results is loaded.
     * - Check number of results displayed
     * - Check is search requests corresponds search word
     * - Go to the second page with responces
     * - Verify  page with search results is loaded.
     * - Check number of results displayed
     * - Check is search requests corresponds search word
     */
    @Test(dataProvider = "searchDataProviderCaseSensetive")
    public void googleSearchTestCaseSensetive(String searchTerm) {
        Assert.assertTrue(googleMainPage.isPageLoaded(), "Home page is not loaded.");
        GoogleSearchPage1 googleSearchPage1 = googleMainPage.searchText(searchTerm);
        Assert.assertTrue(googleSearchPage1.isPageLoaded(), "Search page 1 is not loaded.");
        Assert.assertEquals(googleSearchPage1.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page 1.");

        List<String> searchResultsListSearch1 = googleSearchPage1.getSearchResultsList();

        for (String searchResult : searchResultsListSearch1) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult + "on Page 1");
        }

        GoogleSearchPage2 googleSearchPage2 = googleSearchPage1.goToSearchPage2();
        Assert.assertTrue(googleSearchPage2.isPageLoaded(), "Search page 2 is not loaded.");
        Assert.assertEquals(googleSearchPage2.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page 2.");

        List<String> searchResultsListSearch2 = googleSearchPage2.getSearchResultsList();

        for (String searchResult : searchResultsListSearch2) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult + "on Page 2");
        }
    }
}

