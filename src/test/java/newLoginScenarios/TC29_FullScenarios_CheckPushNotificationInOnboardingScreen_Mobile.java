package newLoginScenarios;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.UrbanAirshipAPIConfigHandeller;
import externalDataFilesHandeller.UrbanAirshipAPI_NotificationBody_Handeller;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.DeeplinkPagesValidator_Mobile;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC29_FullScenarios_CheckPushNotificationInOnboardingScreen_Mobile extends MobileTestBase {


	@Test(priority = 1)
	public void mobileLogin() throws IOException, ParseException {

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.mobileLoginAndStopAtOnBoardingScreen(GetUserFromJson.getUsername("PostpaidUser"), GetUserFromJson.getpassword("PostpaidUser"));

	}

	@Test(priority = 2)
	public void Step2_HandlePushNotificationFromFrontgound() {

		System.out.println("Step 2, handle pushed notification from the app ......");

		userUDID = GetUserFromJson.getUserUDID("PostpaidUser");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("FAQ_DEEPLINK");
		notifcationMessage =UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("FAQ_DEEPLINK_NotificationMessage");

		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.handlePushNotificationFromForground(userUDID,platformName,deepLink,notifcationMessage);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.acceptGDBR);

	}


	@Test(priority = 3)
	public void Step3_ValidateTheFAQDeeplinkAction_FrontGround() {

		System.out.println("Step 3, Validate FAQ Deeplink Action  ......");

		pagesValidatorObject_mobile = new DeeplinkPagesValidator_Mobile(GlobalDriver.appium);
		pagesValidatorObject_mobile.validateFAQPage();
		
		
		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.mobileLogout();
	}

}
