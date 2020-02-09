package homePostpaid.actualCostTCs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.CMSConfigFilesReader;
import externalDataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Get;
import mobileUtilities.Mobile_CommonActions_Set;
import terminalOperatgions.CMDFeatures;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC020_ActualCost_ALM extends MobileTestBase{

	//Upload Required CMS and clear cash via the new reset btn 
	// reset step should be implemented and called
	@Test(priority = 1)
	public void Step1_uploadRequiredCMS() throws IOException, InterruptedException  {
		CMDFeatures.RunBashScriptToUpdateCMSFile_Parameterized(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("ActualCost_FirstEligible_SquareTile_EmptyHeadline"));

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
		/**
		 * when you make the headline empty, the ID of the subline became 
		 * same id of the headline and the headline position will appear empty - correct for business-
		 * So we used the headline inspection as it to assert the cms new reflection 
		 * and make sure that there is no subline inspection
		 */
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.squareTileHeadline),"Auto_ActualCostSubline_TC20_ALM");
		assertFalse(Mobile_CommonActions_Set.checkPresenceOfElement(homePageObject.squareTileSubline));

		
	}

	@Test(priority = 5)
	public void Step5_logout() {

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();

	}
}