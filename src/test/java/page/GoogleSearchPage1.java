package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * GoogleSearchPage1 Object class.
 */
public class GoogleSearchPage1 extends GoogleBasePage {


    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[2]/span")
    private WebElement number1PageBottomBold;

    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[3]")
    private WebElement number2PageBottomLink;

    /**
     * Constructor for GoogleSearchPage1.
     *
     * @param driver - driver instance from test.
     */
    public GoogleSearchPage1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waitUntilElementVisibleRet(searchResBlock, 10);
    }

    /**
     * Check is page loaded up on to controll parameters.
     */
    public boolean isPageLoaded(){
        String currentURL = "search";
        String currentTitle = "Google";
        return isPageLoaded(currentURL, currentTitle, number1PageBottomBold);
    }


    /**
     * Go to the next Search Page with results
     *
     * @return Next loaded page
     */
    public GoogleSearchPage2 goToSearchPage2() {
        number2PageBottomLink.click();
        return new GoogleSearchPage2(driver);
    }


}
