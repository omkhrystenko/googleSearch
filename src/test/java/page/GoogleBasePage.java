package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Common class for Page class group.
 */
public class GoogleBasePage {
    @FindBy(xpath = "//*[@id= 'rso']")
    protected WebElement searchResBlock;

    @FindBy(xpath = "//div[@class = 'g']")
    protected List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id= 'nav']")
    protected WebElement controllBottomBlock;

    protected WebDriver driver;

    /**
     * Get current url.
     *
     * @return current Url String.
     */
    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    /**
     * Get current title.
     *
     * @return current title String.
     */
    protected String getCurrentTitle(){
        return driver.getTitle();
    }

    /**
     * Check is page loaded up on to controll parameters.
     *
     * @param currentUrl - url of verifyed page.
     * @param currentTitle - title of verifyed page.
     * @param uniqElement - controll element on the verifyed page.
     * @return
     */
    protected boolean isPageLoaded(String currentUrl, String currentTitle, WebElement uniqElement){
        String c = getCurrentUrl();
        String title = getCurrentTitle();

        try {
            System.out.println("currentTitle [" + new String(currentTitle.getBytes("UTF-8"), "cp1251") + "]");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("title [" + title + "]");

        boolean b = uniqElement.isDisplayed();
        boolean a= c.contains(currentUrl);
        boolean v= title.contains(currentTitle);
        System.out.println(b + " " + a + " " + v);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", controllBottomBlock);
        return  getCurrentUrl().contains(currentUrl)
                && getCurrentTitle().contains(currentTitle)
                && waitUntilElementVisibleRet(uniqElement, 3).isDisplayed();
    }

    /**
     * Vait untill element is loaded on the page during set time.
     *
     * @param webElement - element that loaded on the page.
     * @param timeOutInSec - time how to wait.
     * @return loaded element.
     */
    protected WebElement waitUntilElementVisibleRet(WebElement webElement, int timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Verifying visibility of element with wait its loading on page
     *
     * @param webElement - WebElement that is waited to display
     * @param timeOutInSec - time of waiting
     * @param mess - assert message
     */
    protected void assertElementsIsVisible (WebElement webElement, int timeOutInSec, String mess){
        try {
            this.waitUntilElementVisibleRet(webElement, timeOutInSec);
        }catch (TimeoutException e){
            throw new AssertionError(mess);
        }
    }

    /**
     * Counting quantity of requests on the search page
     *
     * @return - number of requests
     */
    public int getSearchResultsNumber() {
        return searchResults.size();
    }

    /**
     * Collecting of text results that are displayed on search page
     *
     * @return list of text results
     */
    public List<String> getSearchResultsList(){
        List<String> searchResultList = new ArrayList<String>();
        for(WebElement searchResult : searchResults){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", searchResult);
            searchResultList.add(searchResult.getText());
        }
        return searchResultList;
    }

}
