package tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

public class CreateGistTests extends BaseTest {

    // Extra information:
    // 1) @BeforeClass we declared driver variable.
    // 2) We send driver variable to the page class with below declaration.
    //    Homepage homepage = new HomePage(driver);
    // 3) super () method in page class transfer the driver variable value to the BasePage class.

    @Test(priority = 0, description = "Write Gist")
	public void writeGits(Method method) {
		// ExtentReports Description
		ExtentTestManager.startTest(method.getName(), "Write Gist");

        ghPage
	        .gotoLoginPage()
	        .inputCredential("email", "password")
	        .gotoGitsPage()
	        .verivyPage()
	        .createGist("description", "name", "ini text ya")
	        .savePublicGist()
	        .verifyCreatedGist("description", "name", "ini text ya");

    }
}