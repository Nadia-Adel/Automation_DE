package DSLLandLineNumberTileContent;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC003 extends  MobileTestBase {





	public void Step1_UpdateHomeFile() {

	} 

	public void Step2_UpdateVersionFile() {

	} 

	public void pushCMSChanges() {
		
	}

	@Test(priority = 3)
	public void Step3_dslLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");
		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		lgn.dslLogin(GetUserFromJson.getUsername("DSLUser"),GetUserFromJson.getpassword("DSLUser"));

	}

	@Test(priority =4 )
	public void Step4_ValidateWideTile(){
		homePageObject = new HomePage(GlobalDriver.appium);
		// to be replaced by Json Path 
		homePageObject.validateStaticWideTile("Rufnummern Automation Edits", "DSL landline subline");	
	}
	
	@Test(priority = 5)
	public void Step5_logout() {
		
		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.dslLogout();
		
	}
	
}
