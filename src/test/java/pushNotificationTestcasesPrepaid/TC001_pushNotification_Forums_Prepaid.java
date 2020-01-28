package pushNotificationTestcasesPrepaid;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.UrbanAirshipAPIConfigHandeller;
import externalDataFilesHandeller.UrbanAirshipAPI_NotificationBody_Handeller;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.MenuItemsPage;
import ios_pages.PushedNotificationPagesValidator_Mobile;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC001_pushNotification_Forums_Prepaid extends MobileTestBase {

	HomePage homepage = null;
	PushedNotificationPagesValidator_Mobile pagesValidatorObject = null;

	@Test(priority = 1)
	public void Step1_mobileLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		lgn.mobileLogin_WithoutOnboarding(GetUserFromJson.getUsername("UCMPrepaidUser"),GetUserFromJson.getpassword("UCMPrepaidUser"));	

		MenuItemsPage menuObject = new MenuItemsPage(GlobalDriver.appium);
		menuObject.clickMenuIcon();
		menuObject.clickSettingsMenuItem();
	}

	@Test(priority = 2)
	public void Step2_HandlePushNotificationFromForeground() {
		System.out.println("Step 2, handle pushed notification from the app ......");

		userUDID = GetUserFromJson.getUserUDID("UCMPrepaidUser");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("Forums_DEEPLINK");
		notifcationMessage = UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("Forums_DEEPLINK_NotificationMessage");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromForntground(userUDID,platformName,deepLink,notifcationMessage);	

	}

	@Test(priority = 3)
	public void Step3_ValidateTheForumsPage_FrontGround() {

		System.out.println("Step 3, validate forums page ......");

		pagesValidatorObject = new PushedNotificationPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject.validateForumsPage();
	}

	@Test(priority = 4)
	public void Step4_HandlePushNotification_FromBackground() {

		System.out.println("Step 4, handle pushed notification from the background ......");
		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromForntground(userUDID,platformName,deepLink,notifcationMessage);

	}

	@Test(priority = 5)
	public void Step5_ValidateTheForumsPage_Backround() {

		System.out.println("Step 5, validate forums page ......");

		pagesValidatorObject = new PushedNotificationPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject.validateForumsPage();
	}


	@Test(priority = 6)
	public void Step6_HandlePushNotificationFromFrontgound_AfterKillingTheApp() {

		System.out.println("Step 6, handle pushed notification after killing the app ......");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromForntground(userUDID,platformName,deepLink,notifcationMessage);;

	}

	@Test(priority = 7)
	public void Step7_ValidateTheForumsPage_AfterKillingTheApp() {
		System.out.println("Step 7, validate forums page ......");
		pagesValidatorObject = new PushedNotificationPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject.validateForumsPage();

	}

	@Test(priority = 8)
	public void Step8_MobileLogout() {
		System.out.println("Finally, user is logging out ....");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.mobileLogout();
	}
}