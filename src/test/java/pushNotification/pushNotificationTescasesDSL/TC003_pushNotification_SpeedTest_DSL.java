package pushNotification.pushNotificationTescasesDSL;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.UrbanAirshipAPIConfigHandeller;
import dataFilesHandeller.UrbanAirshipAPI_NotificationBody_Handeller;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.MenuItemsPage;
import ios_pages.DeeplinkPagesValidator_DSL;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC003_pushNotification_SpeedTest_DSL extends MobileTestBase {

	HomePage homepage = null;
	DeeplinkPagesValidator_DSL pagesValidatorObject = null;

	@Test(priority = 1)
	public void Stepd1_dslLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		lgn.dslLogin(GetUserFromJson.getUsername("DSLUser"),GetUserFromJson.getpassword("DSLUser"));	

		MenuItemsPage menuObject = new MenuItemsPage(GlobalDriver.appium);
		menuObject.clickMenuIcon();
		menuObject.clickSettingsMenuItem();
	}
	
	@Test(priority = 2)
	public void Step2_HandlePushNotificationFromFrontgound() {

		System.out.println("Step 2, handle pushed notification from the app ......");

		userUDID = GetUserFromJson.getUserUDID("DSLUser");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("Speedtest_DEEPLINK");
		notifcationMessage = UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("Speedtest_DEEPLINK_NotificationMessage");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromForground(userUDID,platformName,deepLink,notifcationMessage);	

	}

	@Test(priority = 3)
	public void Step3_ValidateTheSpeedTestDeeplinkAction_FrontGround() {

		System.out.println("Step 3, validate speedtest page ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		pagesValidatorObject.validateSpeedTestDeeplinkAction();

	}

	@Test(priority = 4)
	public void Step4_HandlePushNotification_FromBackground() {

		System.out.println("Step 4, handle pushed notification from the background ......");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromBackground(userUDID,platformName,deepLink,notifcationMessage);

	}

	@Test(priority = 5)
	public void Step5_ValidateTheSpeedtestDeeplinkAction_Backround() {

		System.out.println("Step 5, validate Speedtest page ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		pagesValidatorObject.validateSpeedTestDeeplinkAction();
	}

	@Test(priority = 6)
	public void Step6_HandlePushNotificationFromFrontgound_AfterKillingTheApp() {

		System.out.println("Step 6, handle pushed notification after killing the app ......");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationAfterKillingTheApp(userUDID,platformName,deepLink,notifcationMessage);
	}

	@Test(priority = 7)
	public void Step7_ValidateTheSpeedtestDeeplinkAction_AfterKillingTheApp() {

		System.out.println("Step 7, validate Speedtest page ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		pagesValidatorObject.validateSpeedTestDeeplinkAction();


	}

	@Test(priority = 8)
	public void Step8_dslLogout() {

		System.out.println("Finally, user is logging out ....");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.dslLogout();		
	}
}