package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    /**Constructor*/
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**Variables*/
    String baseURL = "";

    /**Web Elements*/
    By signInButtonClass = By.className("btnSignIn");
    

    /**Page Methods*/
    public HomePage gotoHomePage() {
        driver.get(baseURL);

        return this;
    }

    public LoginPage goToLoginPage() {
        click(signInButtonClass);
        return new LoginPage(driver);
    }
}