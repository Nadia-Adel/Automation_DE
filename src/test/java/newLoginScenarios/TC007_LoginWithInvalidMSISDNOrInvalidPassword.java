package newLoginScenarios;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import ios_pages.LoginPage;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC007_LoginWithInvalidMSISDNOrInvalidPassword extends MobileTestBase {

	
	@Test
	public void checkLoginScreenBody() throws IOException, ParseException {
		loginPageObject = new LoginPage(GlobalDriver.appium);
		
		// enter any incorrect username or password
		loginPageObject.validateNewLoginInvalidCredentials_Mobile("010022345631", "test1234");
		
		// enter correct credentials and complete login flow 
		loginPageObject.mobileLogin(GetUserFromJson.getUsername("PostpaidUser"), GetUserFromJson.getpassword("PostpaidUser"));
	}
}