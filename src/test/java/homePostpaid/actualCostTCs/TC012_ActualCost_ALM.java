package homePostpaid.actualCostTCs;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.CMSConfigFilesReader;
import dataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import terminalOperatgions.CMDFeatures;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC012_ActualCost_ALM extends MobileTestBase{

	//Upload Required CMS and clear cash via the new reset btn 
	// reset step should be implemented and called
	@Test(priority = 1)
	public void Step1_uploadRequiredCMS() throws IOException, InterruptedException  {
		CMDFeatures.RunBashScriptToUpdateCMSFile_Parameterized(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("ActualCost_FirstEligible_SquareTile_InvalidLink"));

	} 
	
	@Test(priority = 2)
	public void Step2_resetTheApp() {

		// reset step should be implemented and called here 
		// reset function MUST reactivate the app again 
		
		System.err.println("Now reset App Manually");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void Step3_LoginWithPostpaidUser() throws IOException, ParseException {
		
		//	GlobalDriver.appium.runAppInBackground(Duration.ofSeconds(2));
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.mobileLogin(GetUserFromJson.getUsername("PostpaidUser"), GetUserFromJson.getpassword("PostpaidUser"));
	
		//Mobile_CommonActions_Set.killApp();
		//GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
	}

	@Test(priority = 4 )
	public void Step4_ValidateSquareTileInvalidDeeplink() {
		
		homePageObject = new HomePage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(homePageObject.squareTileHeadline);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mobile_CommonActions_Set.setExplicitWait(homePageObject.squareTileHeadline, 20);
	}
	
	@Test(priority = 5)
	public void Step5_logout() {

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();

	}
}