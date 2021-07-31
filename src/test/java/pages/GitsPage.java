package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitsPage extends BasePage {

    /**Constructor*/
    public GitsPage(WebDriver driver) {
        super(driver);
    }

    /**Web Elements*/
    By backToGithub = By.xpath("//a[.='Back to GitHub']");
    By gistDescription = By.xpath("//input[@name='gist[description]']");
    By gistName = By.xpath("//input[@name='gist[contents][][name]']");
    By gistText = By.className("CodeMirror-line");
    
    By dropdownSave = By.xpath("//div[2]/div/details/summary");
    By radioPublic = By.xpath("//span[contains(.,'Create public gist')]");
    By btnSubmit = By.xpath("//button[contains(.,'Create public gist')]");

    By descriptionLabel = By.cssSelector("div[itemprop='about']");
    By nameLabel = By.cssSelector(".user-select-contain");
    By textLabel = By.cssSelector(".blob-code");
    
    By userAvatar = By.xpath("//div[@id='user-links']/details/summary/img");
    By userLink = By.xpath("//div[@id='user-links']/details/details-menu/div/a/strong");
    
    By btnEdit = By.xpath("//a[contains(.,'Edit')]");
    By btnSubmitUpdate = By.cssSelector(".btn-primary[type='submit']");
    
    By btnDelete = By.xpath("//button[@class='btn btn-sm btn-danger']");
    By lblTerms = By.xpath("//a[.='Terms']");
    
    /**Page Methods*/
    public GitsPage verivyPage() {
    	waitVisibility(backToGithub);
        return this;
    }
    
    public GitsPage createGist(String description, String name, String text){
    	writeText(gistDescription, description);
        writeText(gistName, name);
    	writeText(gistText, text);
    	return this;
    }

    public GitsPage savePublicGist() {
    	click(dropdownSave);
    	click(radioPublic);
    	click(btnSubmit);
    	return this;
    }

    
    public GitsPage verifyCreatedGist(String description, String name, String text){
    	verifyElement(descriptionLabel, description);
    	verifyElement(nameLabel, name);
    	verifyElement(textLabel, text);
    	return this;
    }
    
    public GitsUserPage gotoUserpage() {
    	click(userAvatar);
    	click(userLink);
    	return new GitsUserPage(driver);
    }
    
    public GitsPage editGist() {
    	click(btnEdit);
    	return this;
    }
    
    public GitsPage editToSimpleGist() {
    	clearText(gistDescription);
    	
    	writeText(gistDescription, "description Edit");
    	writeText(gistText, "Text Edit");
//        writeText(gistName, "name Edit");
    	click(btnSubmitUpdate);
    	return this;
    }
    
    public GitsPage verifyEditedGist(){
    	verifyElementTextContains(descriptionLabel, "Edit");
    	verifyElementTextContains(textLabel, "Edit");
    	return this;
    }
    
    public GitsPage deleteGist() {
    	click(btnDelete);
    	driver.switchTo().alert().accept();
    	return this;
    }
    
}
