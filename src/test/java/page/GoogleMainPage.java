package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends GoogleBasePage {
    @FindBy(xpath = "//*[@id = 'lst-ib']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id= 'hplogoy']")
    private WebElement logo;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //Можем вычитать из другого класса тогда вместо this ставим pageOld.LinkedinHomePage.class
        assertElementsIsVisible(logo, 10, "Login page is not loaded");
    }

    public boolean isPageLoaded(){
        String currentURL_Login = "https://www.google.com/";
        String currentTitle_Login = "Google";
        return isPageLoaded(currentURL_Login, currentTitle_Login, logo);
    }

    public GoogleSearchPage1 searchText(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage1(driver);
    }


}
