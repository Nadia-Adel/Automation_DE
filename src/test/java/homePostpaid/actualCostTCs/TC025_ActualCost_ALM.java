package homePostpaid.actualCostTCs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.CMSConfigFilesReader;
import externalDataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Get;
import terminalOperatgions.CMDFeatures;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC025_ActualCost_ALM extends MobileTestBase{

	//Upload Required CMS and clear cash via the new reset btn 
	// reset step should be implemented and called
	@Test(priority = 1)
	public void Step1_uploadRequiredCMS() throws IOException, InterruptedException  {

		// please note that this testcase is the same bevahior of TC not 21 
		// so we will use same CMS Configurations
		CMDFeatures.RunBashScriptToUpdateCMSFile_Parameterized(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("ActualCost_FirstEligible_NewItem"));

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
	public void Step4_ValidateSquareTile() {

		homePageObject = new HomePage(GlobalDriver.appium);
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.squareTileHeadline),"New_Item_Automation");
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.squareTileSubline),"NewItem_Aut0mation_subline_TC25");

	}
	@Test(priority = 5)
	public void Step5_logout() {

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();

	}
}