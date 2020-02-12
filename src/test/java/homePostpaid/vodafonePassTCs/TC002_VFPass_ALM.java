package homePostpaid.vodafonePassTCs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.CMSConfigFilesReader;
import dataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Get;
import mobileUtilities.Mobile_CommonActions_Set;
import terminalOperatgions.CMDFeatures;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC002_VFPass_ALM extends MobileTestBase{

	@Test(priority = 1)
	public void Step1_uploadRequiredCMS() throws IOException, InterruptedException  {
		CMDFeatures.RunBashScriptToUpdateCMSFile_Parameterized(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("VFpass_TC2_ALM"));

	} 
	
	@Test(priority = 3)
	public void Step3_LoginWithPostpaidUser() throws IOException, ParseException {
		
		//	GlobalDriver.appium.runAppInBackground(Duration.ofSeconds(2));
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.mobileLogin(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"), GetUserFromJson.getpassword("PostpaidUSer_NoEnojymore")); 
		
		//Mobile_CommonActions_Set.killApp();
		//GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
	}
	
	@Test(priority = 6 )
	public void Step6_ValidateSquareTile() {
	
		homePageObject = new HomePage(GlobalDriver.appium);
		assertFalse(Mobile_CommonActions_Set.checkPresenceOfElement(homePageObject.secondSmallTileTitle_txt));
		assertFalse(Mobile_CommonActions_Set.checkPresenceOfElement(homePageObject.secondSmallTileSubline_txt));
		
		assertFalse(Mobile_CommonActions_Set.checkPresenceOfElement(homePageObject.firstSmallTileTitle_txt));
		assertFalse(Mobile_CommonActions_Set.checkPresenceOfElement(homePageObject.firstSmallTileSubline_txt));
		
	}
	
	
	@Test(priority = 7)
	public void Step7_logout() {

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();

	}
	
}
