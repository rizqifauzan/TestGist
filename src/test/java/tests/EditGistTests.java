package tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

public class EditGistTests extends BaseTest {

    // Extra information:
    // 1) @BeforeClass we declared driver variable.
    // 2) We send driver variable to the page class with below declaration.
    //    Homepage homepage = new HomePage(driver);
    // 3) super () method in page class transfer the driver variable value to the BasePage class.

    @Test(priority = 0, description = "Edit Gist")
	public void simpleEditGits(Method method) {
		// ExtentReports Description
		ExtentTestManager.startTest(method.getName(), "Edit Gist");
 
        ghPage
	        .gotoLoginPage()
	        .inputCredential("caesariawredhani@gmail.com", "rere71829498")
	        .gotoGitsPage()
	        .verivyPage()
	        .gotoUserpage()
	        .gotoLatestGist()
	        .verivyPage()
	        .editGist()
	        .editToSimpleGist()
	        .verifyEditedGist();
        
    }
}