package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitsUserPage extends BasePage {

	/** Constructor */
	public GitsUserPage(WebDriver driver) {
		super(driver);
	}

	/** Web Elements */
	By backToGithub = By.xpath("//a[.='Back to GitHub']");
	By latestgist = By
			.xpath("//*[@id=\"gist-pjax-container\"]/div/div/div[2]/div[2]/div[1]/div/div[2]/span[1]/a[2]/strong");

	/** Page Methods */
	public GitsUserPage verivyPage() {
		waitVisibility(backToGithub);
		return this;
	}

	public GitsPage gotoLatestGist() {
		click(latestgist);
		return new GitsPage(driver);
	}
}
