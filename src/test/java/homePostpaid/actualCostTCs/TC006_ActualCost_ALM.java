package homePostpaid.actualCostTCs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.CMSConfigFilesReader;
import dataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Get;
import servicesAndAPIs.UnbilledUsage_Get;
import terminalOperatgions.CMDFeatures;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC006_ActualCost_ALM extends MobileTestBase{

	//Upload Required CMS and clear cash via the new reset btn 
	// reset step should be implemented and called
	@Test(priority = 1)
	public void Step1_uploadRequiredCMS() throws IOException, InterruptedException  {
		CMDFeatures.RunBashScriptToUpdateCMSFile_Parameterized(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("ActualCost_FirstEligible_SquareTile"));
	} 

	@Test(priority = 2)
	public void Step2_GetAmountValueFromUnbilledUsageService() throws IOException, ParseException {

		SavedAmount = UnbilledUsage_Get.getHomeScreenActualCost_ServiceValue(GetUserFromJson.getUsername("PostpaidUser"),GetUserFromJson.getpassword("PostpaidUser"));	

	}

	@Test(priority = 3)
	public void Step3_LoginWithPostpaidUser() throws IOException, ParseException {
		//	GlobalDriver.appium.runAppInBackground(Duration.ofSeconds(2));
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.mobileLogin(GetUserFromJson.getUsername("PostpaidUser"), GetUserFromJson.getpassword("PostpaidUser"));
		//Mobile_CommonActions_Set.killApp();
		//GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
	}

	@Test(priority = 6 )
	public void Step6_ValidateSquareTile() {
		homePageObject = new HomePage(GlobalDriver.appium);
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.squareTileHeadline),"Mobilfunkkosten");
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.squareTileSubline),"Auto_ActualCostSubline_Update");
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.squareTileAmount),SavedAmount.replace('.', ','));
	
	
	}


	@Test(priority = 7)
	public void Step7_logout() {

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();

	}
}