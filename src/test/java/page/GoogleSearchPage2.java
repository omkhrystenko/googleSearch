package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage2 extends GoogleBasePage {
    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[3]/span")
    private WebElement number2PageBottomBold;




    public GoogleSearchPage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResBlock, 10);
    }

    public boolean isPageLoaded(){
        String currentURL_Login = "https://www.google.com/search?q";
        String currentTitle_Login = "Selenium - Пошук Google";
        return isPageLoaded(currentURL_Login, currentTitle_Login, number2PageBottomBold);
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
