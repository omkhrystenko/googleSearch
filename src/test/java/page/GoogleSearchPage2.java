package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * GoogleSearchPage2 Object class.
 */
public class GoogleSearchPage2 extends GoogleBasePage {

    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[3]/span")
    private WebElement number2PageBottomBold;



    /**
     * Constructor for GoogleSearchPage2.
     *
     * @param driver - driver instance from test.
     */
    public GoogleSearchPage2(WebDriver driver){
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
        return isPageLoaded(currentURL, currentTitle, number2PageBottomBold);
    }


}
