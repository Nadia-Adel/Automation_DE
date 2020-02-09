package SwitchBetweenUsers;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC01 extends MobileTestBase {


	@Test(priority = 1)
	public void Case1_LoginDSLToPostpaid() throws IOException, ParseException {

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));

		homePageObject =  new HomePage(GlobalDriver.appium);
		homePageObject.assertLoggedInUser("001944194562");

		homePageObject.switchFromDSLToMobile();

		loginPageObject.mobileLogin(GetUserFromJson.getUsername("PostpaidUser"), GetUserFromJson.getpassword("PostpaidUser"));
		homePageObject.mobileLogout();

	}

	
}
