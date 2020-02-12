package homePostpaid.vodafonePassTCs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.CMSConfigFilesReader;
import dataFilesHandeller.GetUserFromJson;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Get;
import mobileUtilities.Mobile_CommonActions_Set;
import servicesAndAPIs.UnbilledUsage_Get;
import terminalOperatgions.CMDFeatures;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC003_VFPass_ALM extends MobileTestBase{



	@Test(priority = 1)
	public void Step1_uploadRequiredCMS() throws IOException, InterruptedException  {
		CMDFeatures.RunBashScriptToUpdateCMSFile_Parameterized(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("VFpass_TC3_ALM"));

	} 

	@Test(priority = 2)
	public void Step1_getServiceIdentfireFromUnbilledUsageService() throws IOException, ParseException {
		ServiceIdentfier = UnbilledUsage_Get.getHomeScreenVfpassUsedServiceIdentfier(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"), GetUserFromJson.getpassword("PostpaidUSer_Enojymore"));
	}

	@Test(priority = 3)
	public void Step3_getUnitOfMeasureFromUnbilledUsageService() throws IOException, ParseException {
		UnitOfMeasure = UnbilledUsage_Get.getHomeScreenVfpassUsedUnitOfMeasure(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"), GetUserFromJson.getpassword("PostpaidUSer_Enojymore"));
	}
	@Test(priority = 3)
	public void Step3_LoginWithPostpaidUser() throws IOException, ParseException {
		//	GlobalDriver.appium.runAppInBackground(Duration.ofSeconds(2));

		loginPageObject = new LoginPage(GlobalDriver.appium);

		loginPageObject.mobileLogin(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"), GetUserFromJson.getpassword("PostpaidUSer_Enojymore"));

		//Mobile_CommonActions_Set.killApp();
		//GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
	}

	@Test(priority = 6 )
	public void Step6_ValidateSquareTile() {
		homePageObject = new HomePage(GlobalDriver.appium);
		if(ServiceIdentfier=="Vodafone Pässe") {
			assertEquals(Mobile_CommonActions_Get.getText(homePageObject.vodafonepassstile_title_tv), "Vodafone Passes");
		}

		assertTrue(Mobile_CommonActions_Get.getText(homePageObject.vodafonepassstile_usage_tv).contains(UnitOfMeasure));

	
	}

	@Test(priority = 7)
	public void Step7_logout() {

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();

	}	
}