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

public class TC018_pushNotification_Speedtest_Postpaid extends MobileTestBase {
	

	@Test(priority = 1)
	public void Step1_mobileLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		lgn.mobileLogin(GetUserFromJson.getUsername("PostpaidUser"),GetUserFromJson.getpassword("PostpaidUser"));	

		//menuObject = new MenuItemsPage(GlobalDriver.appium);
		//menuObject.clickMenuIcon();
		//menuObject.clickSettingsMenuItem();
	}

	@Test(priority = 2)
	public void Step2_HandlePushNotificationFromFrontgound() {

		System.out.println("Step 2, handle pushed notification from the app ......");

		userUDID = GetUserFromJson.getUserUDID("PostpaidUser");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("Speedtest_DEEPLINK");
		notifcationMessage =UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("Speedtest_DEEPLINK_NotificationMessage");

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.handlePushNotificationFromForground(userUDID,platformName,deepLink,notifcationMessage);	

	}


	@Test(priority = 3)
	public void Step3_ValidateTheSpeedtestDeeplinkAction_FrontGround() {
		
		System.out.println("Step 3, Validate Speedtest Deeplink Action  ......");
		
		pagesValidatorObject_mobile = new DeeplinkPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject_mobile.validateSpeedtestDeeplinkAction();
	}

	@Test(priority = 4)
	public void Step4_HandlePushNotification_FromBackground() {
	
		System.out.println("Step 4, handle pushed notification from the background ......");
		
		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.handlePushNotificationFromBackground(userUDID,platformName,deepLink,notifcationMessage);
		
	}

	@Test(priority = 5)
	public void Step5_ValidateTheSpeedtestDeeplinkAction_Backround() {

		System.out.println("Step 5, validate Speedtest Deeplink Action ......");
		
		pagesValidatorObject_mobile = new DeeplinkPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject_mobile.validateSpeedtestDeeplinkAction();
		}

	@Test(priority = 6)
	public void Step6_HandlePushNotificationFromFrontgound_AfterKillingTheApp() {
		
		System.out.println("Step 6, handle pushed notification after killing the app ......");
		
		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.handlePushNotificationAfterKillingTheApp(userUDID,platformName,deepLink,notifcationMessage);
	}
		
	@Test(priority = 7)
	public void Step7_ValidateTheSpeedTestDeeplinkAction_AfterKillingTheApp() {
		
		System.out.println("Step 7, validate Speedtest Deeplink Action......");
		
		pagesValidatorObject_mobile = new DeeplinkPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject_mobile.validateSpeedtestDeeplinkAction();
	
	}
	
	@Test(priority = 8)
	public void Step8_MobileLogout() {
		
        System.out.println("Finally, user is logging out ....");
        
		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();
	}
}