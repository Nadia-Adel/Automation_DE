package newLoginScenarios.DSLScenarios_Live;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC014_LoginWithDSLUsingInvalidUsernameOrPassword extends MobileTestBase {
	
	
	
	@Test(priority = 1)
	public void checkLoginScreenBody() throws IOException, ParseException {
		loginPageObject = new LoginPage(GlobalDriver.appium);
		
		// enter any incorrect username or password
		loginPageObject.validateNewLoginInvalidCredentials_DSL("DSL-Testkunde2WebFactory_invalid", "DSLTestkunde2WebFactory");
		
		// enter correct credentials and complete login flow 
		//loginPageObject.dslInvalidLogin(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
	}
	
	
	@Test(priority = 2)
	public void validate() {
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.setExplicitWait(loginPageObject.confirmInvalidCredentialsMessage_btn, 20);
		
		Mobile_CommonActions_Set.Click(loginPageObject.confirmInvalidCredentialsMessage_btn);
		
	}
	

}
