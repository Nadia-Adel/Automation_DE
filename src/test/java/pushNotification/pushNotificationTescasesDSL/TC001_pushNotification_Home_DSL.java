package pushNotification.pushNotificationTescasesDSL;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.UrbanAirshipAPIConfigHandeller;
import externalDataFilesHandeller.UrbanAirshipAPI_NotificationBody_Handeller;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.MenuItemsPage;
import ios_pages.DeeplinkPagesValidator_DSL;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC001_pushNotification_Home_DSL extends MobileTestBase {

	HomePage homepage = null;
	DeeplinkPagesValidator_DSL pagesValidatorObject = null;

	@Test(priority = 1)
	public void Step1_dslLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin(GetUserFromJson.getUsername("DSLUser"),GetUserFromJson.getpassword("DSLUser"));

		 //MenuItemsPage menuObject = new MenuItemsPage(GlobalDriver.appium);
		 //menuObject.clickMenuIcon();
         //menuObject.clickSettingsMenuItem();

	}

	@Test(priority = 2)
	public void Step2_HandlePushNotificationFromFrontgound() {

		System.out.println("Step 2, handle pushed notification from the app ......");

		userUDID = GetUserFromJson.getUserUDID("DSLUser");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("HomePage_DEEPLINK");
		notifcationMessage = UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("HomePage_DEEPLINK_NotificationMessage");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromForground(userUDID,platformName,deepLink,notifcationMessage);	

	}

	@Test(priority = 3)
	public void Step3_ValidateTheHomePage_FrontGround() {

		System.out.println("Step 3, Validate Home Page  ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		pagesValidatorObject.validateHomePage();
	}

	@Test(priority = 4)
	public void Step4_HandlePushNotification_FromBackground() {

		System.out.println("Step 4, handle pushed notification from the background ......");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromBackground(userUDID,platformName,deepLink,notifcationMessage);

	}

	@Test(priority = 5)
	public void Step5_ValidateTheHomePage_Backround() {

		System.out.println("Step 5, validate Home Page ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		pagesValidatorObject.validateHomePage();
	}


	@Test(priority = 6)
	public void Step6_HandlePushNotificationFromFrontgound_AfterKillingTheApp() {

		System.out.println("Step 6, handle pushed notification after killing the app ......");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationAfterKillingTheApp(userUDID,platformName,deepLink,notifcationMessage);
	}

	@Test(priority = 7)
	public void Step7_ValidateTheHomePage_AfterKillingTheApp() {

		System.out.println("Step 7, validate Home Page ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		pagesValidatorObject.validateHomePage();

	}

	@Test(priority = 8)
	public void Step8_MobileLogout() {
		System.out.println("Finally, user is logging out ....");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.dslLogout();

	}
}