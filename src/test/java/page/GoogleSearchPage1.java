package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage1 extends GoogleBasePage {


    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[2]/span")
    private WebElement number1PageBottomBold;

    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[3]")
    private WebElement number2PageBottomLink;




    public GoogleSearchPage1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResBlock, 10);
    }

    public boolean isPageLoaded(){
        String currentURL_Login = "https://www.google.com/search?source";
        String currentTitle_Login = "Selenium - Пошук Google";
        return isPageLoaded(currentURL_Login, currentTitle_Login, number1PageBottomBold);
    }



    public GoogleSearchPage2 goToSearchPage2() {
        number2PageBottomLink.click();
        return new GoogleSearchPage2(driver);
    }


}
