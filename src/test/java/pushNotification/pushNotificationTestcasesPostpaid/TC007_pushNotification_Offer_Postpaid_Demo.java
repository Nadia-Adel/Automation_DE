package pushNotification.pushNotificationTestcasesPostpaid;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.UrbanAirshipAPIConfigHandeller;
import dataFilesHandeller.UrbanAirshipAPI_NotificationBody_Handeller;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.MenuItemsPage;
import ios_pages.DeeplinkPagesValidator_Mobile;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC007_pushNotification_Offer_Postpaid_Demo extends MobileTestBase {
	
	HomePage homepage = null;
	DeeplinkPagesValidator_Mobile pagesValidatorObject = null;
	
	@Test(priority = 1)
	public void Step1_mobileLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");
		
	    LoginPage lgn = new LoginPage(GlobalDriver.appium);
	    lgn.mobileLogin(GetUserFromJson.getUsername("PostpaidUser"),GetUserFromJson.getpassword("PostpaidUser"));	
		
	
	}

	@Test(priority = 2)
	public void Step6_HandlePushNotificationFromFrontgound_AfterKillingTheApp() {
		
		System.out.println("Step 6, handle pushed notification after killing the app ......");
		
		userUDID = GetUserFromJson.getUserUDID("PostpaidUser");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("ANGEBOTE_DEEPLINk");
		notifcationMessage =UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("ANGEBOTE_DEEPLINk_NotificationMessage");
		
		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationAfterKillingTheApp(userUDID,platformName,deepLink,notifcationMessage);
	}
	
	@Test(priority = 3)
	public void Step7_ValidateTheAngebotePage_AfterKillingTheApp() {
		
		System.out.println("Step 7, validate angebote page ......");
		
		pagesValidatorObject = new DeeplinkPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject.validateAngebotePage_Empfehlungen();
	
	}
	
	@Test(priority = 4)
	public void Step8_MobileLogout() {
        System.out.println("Finally, user is logging out ....");
		
		homepage = new HomePage(GlobalDriver.appium);
		homepage.mobileLogout();
		
	}
}