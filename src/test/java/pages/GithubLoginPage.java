package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GithubLoginPage extends BasePage {

    /**Constructor*/
    public GithubLoginPage(WebDriver driver) {
        super(driver);
    }

    /**Variables*/
    String baseURL = "https://github.com/login";
    String gitsPage = "https://gist.github.com";
    
    
    /**Web Elements*/
    By userNameId = By.id("login_field");
    By passwordId = By.id("password");
    By loginButtonId = By.className("btn-primary");
    By addGits = By.className("octicon-plus");
    

    public GithubLoginPage gotoLoginPage() {
        driver.get(baseURL);
        return this;
    }
    
    
    public GithubLoginPage inputCredential(String username, String password) {
    	writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        waitVisibility(addGits);
        return this;
    }
    
    public GitsPage gotoGitsPage() {
    	driver.get(gitsPage);
    	return new GitsPage(driver);
    }

}
