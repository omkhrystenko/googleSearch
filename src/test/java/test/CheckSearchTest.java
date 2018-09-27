package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchPage1;
import page.GoogleSearchPage2;

import java.util.List;

public class CheckSearchTest extends CheckSearchBaseTest  {
    String searchTerm = "Selenium";

    @Test
    public void googleSearchTest() {
        Assert.assertTrue(googleMainPage.isPageLoaded(), "Home page is not loaded.");
        GoogleSearchPage1 googleSearchPage1 = googleMainPage.searchText(searchTerm);
        Assert.assertTrue(googleSearchPage1.isPageLoaded(), "Search page 1 is not loaded.");
        Assert.assertEquals(googleSearchPage1.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page 1.");

        List<String> searchResultsListSearch1 = googleSearchPage1.getSearchResultsList();

        for (String searchResult : searchResultsListSearch1) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

        GoogleSearchPage2 googleSearchPage2 = googleSearchPage1.goToSearchPage2();
        Assert.assertTrue(googleSearchPage2.isPageLoaded(), "Search page 2 is not loaded.");
        Assert.assertEquals(googleSearchPage2.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page 2.");

        List<String> searchResultsListSearch2 = googleSearchPage2.getSearchResultsList();

        for (String searchResult : searchResultsListSearch2) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }
    }
}

