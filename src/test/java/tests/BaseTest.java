package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.GithubLoginPage;
import pages.HomePage;

public class BaseTest {
    public WebDriver driver;
    public GithubLoginPage ghPage;
    public HomePage homepage;
    
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
    	
    	// chrome 
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ocharla\\Documents\\Cilsy\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        // firefox
//        System.setProperty("webdriver.gecko.driver", "/Users/rizqi.fauzan/Downloads/geckodriver");
//        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
    	ghPage = new GithubLoginPage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
