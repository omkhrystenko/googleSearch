package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleBasePage {
    @FindBy(xpath = "//*[@id= 'rso']")
    protected WebElement searchResBlock;

    @FindBy(xpath = "//*[@class = 'st']")
    protected List<WebElement> searchResults;

    protected WebDriver driver;

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected String getCurrentTitle(){
        return driver.getTitle();
    }

    protected boolean isPageLoaded(String currentUrl, String currentTitle, WebElement uniqElement){
        String url = getCurrentUrl();
        String curentitle = getCurrentTitle();
        boolean b = uniqElement.isDisplayed();

        boolean s = getCurrentUrl().contains(currentUrl);
        boolean d = getCurrentTitle().equals(currentTitle);
        boolean a = uniqElement.isDisplayed();


        return  getCurrentUrl().contains(currentUrl)
                && getCurrentTitle().equals(currentTitle)
                && uniqElement.isDisplayed();
    }

    protected WebElement waitUntilElementVisible(WebElement webElement, int timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected boolean waitUrlContains(String partialURL, int timeOutSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        try {
            return wait.until(ExpectedConditions.urlContains(partialURL));
        }catch (TimeoutException e) {
            return false;
        }
    }

    protected void assertElementsIsVisible (WebElement webElement, int timeOutInSec, String mess){
        try {
            waitUntilElementVisible(webElement, timeOutInSec);
        }catch (TimeoutException e){
            throw new AssertionError(mess);
        }
    }

    public int getSearchResultsNumber() {
        return searchResults.size();
    }

    public List<String> getSearchResultsList(){
        List<String> searchResultList = new ArrayList<String>();
        for(WebElement searchResult : searchResults){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", searchResults);
            searchResultList.add(searchResult.getText());
        }
        return searchResultList;
    }

}
