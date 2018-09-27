package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleMainPage;

public class CheckSearchBaseTest {
    WebDriver driver;
    WebDriverWait driverWait;

    GoogleMainPage googleMainPage;

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName) throws Exception {

        switch(browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception("Browser " + browserName + " is not supported.");
        }

        driver.get("https://www.google.com");
        driverWait = new WebDriverWait(driver, 10);
        googleMainPage = new GoogleMainPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.quit();
    }



}
