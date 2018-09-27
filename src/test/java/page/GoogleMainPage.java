package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * GoogleMainPage Object class.
 */
public class GoogleMainPage extends GoogleBasePage {
    @FindBy(xpath = "//*[@id = 'lst-ib']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id= 'hplogoy']")
    private WebElement logo;

    /**
     * Constructor for GoogleMainPage.
     *
     * @param driver - driver instance from test.
     */
    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //Можем вычитать из другого класса тогда вместо this ставим pageOld.LinkedinHomePage.class
        assertElementsIsVisible(logo, 10, "Login page is not loaded");
    }

    /**
     * Check is page loaded up on to controll parameters.
     */
    public boolean isPageLoaded(){
        String currentURL= "https://www.google.com/";
        String currentTitle = "Google";
        return  getCurrentUrl().equals(currentURL)
                && getCurrentTitle().equals(currentTitle)
                && logo.isDisplayed();
    }

    /**
     * Search value using search field on the page.
     *
     * @param searchTerm - value that is searched.
     * @return page that loaded after search input submited.
     */
    public GoogleSearchPage1 searchText(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage1(driver);
    }


}
