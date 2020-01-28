package SwitchBetweenUsers;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC02 extends MobileTestBase{

	
	@Test(priority = 1)
	public void Case2_SwitchFromUCMToDSL() throws IOException, ParseException {
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.mobileLogin_WithoutOnboarding(GetUserFromJson.getUsername("UCMPrepaidUser"), GetUserFromJson.getpassword("UCMPrepaidUser"));

		homePageObject =  new HomePage(GlobalDriver.appium);
		homePageObject.assertLoggedInUser("0152 56439574");

		homePageObject.switchFromMobileToDSL();

		loginPageObject.dslLogin(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
		homePageObject.dslLogout();
	}
}
