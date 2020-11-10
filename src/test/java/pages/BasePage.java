package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Click Method
    public void click(By elementLocation) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).sendKeys(text);
    }
    
    //Clear Text
    public void clearText(By elementLocation) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).clear();
    }

    //Read Text
    public String readText(By elementLocation) {
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }

    //Wait
    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    //Wait
    public void verifyElement(By by, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertEquals(text, driver.findElement(by).getText());
    }
    
    //Wait
    public void verifyElementTextContains(By by, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        assertTrue(driver.findElement(by).getText().contains(text));
    }

	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}
}