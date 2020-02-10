package newLoginScenarios.CableScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.UrbanAirshipAPIConfigHandeller;
import dataFilesHandeller.UrbanAirshipAPI_NotificationBody_Handeller;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.DeeplinkPagesValidator_DSL;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC030_pushNotification_PermissionScreen_SpeedTest_DSL extends MobileTestBase {
	
	HomePage homepage = null;
	DeeplinkPagesValidator_DSL pagesValidatorObject = null;
	
	
	@Test(priority = 1)
	public void Step1_mobileLogin() throws IOException, ParseException, InterruptedException {

		System.out.println("Step 1, user is logging in ......");
		
	    loginPageObject = new LoginPage(GlobalDriver.appium);
	    loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
		Mobile_CommonActions_Set.waitPrsenceOfElement(By.id("Hallo,"), 5);
	
	}
	
	@Test(priority = 2)
	public void Step2_HandlePushNotificationFromForeground() throws InterruptedException {

		System.out.println("Step 2, handle pushed notification from the app ......");

		userUDID = GetUserFromJson.getUserUDID("DSLUser_Stubs");
		platformName = UrbanAirshipAPIConfigHandeller.getPlatformName_IOS();
		deepLink = UrbanAirshipAPIConfigHandeller.getReguiredDEEPLINK("Speedtest_DEEPLINK");
		notifcationMessage = UrbanAirshipAPI_NotificationBody_Handeller.getRequiredMessage("Speedtest_DEEPLINK_NotificationMessage");

		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromForground(userUDID,platformName,deepLink,notifcationMessage);	
		Mobile_CommonActions_Set.waitPrsenceOfElement(By.id("Hallo,"), 5);
		

	}
	
	@Test(priority = 3)
	public void Step3_ValidateTheSpeedTestDeeplinkAction_FrontGround() {

		System.out.println("Step 3, validate speedtest page ......");

		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		
		Mobile_CommonActions_Set.scrollDownTo(loginPageObject.acceptGDBR, 2000 , "native-ios");
		System.out.println("permissionn weiter");
		Mobile_CommonActions_Set.Click(loginPageObject.acceptGDBR);
		
		pagesValidatorObject.validateSpeedTestDeeplinkAction();

	}
	
	@Test(priority = 4)
	public void Step4_dslLogout() {
        System.out.println("Step 4, user is logging out ....");
		
		homepage = new HomePage(GlobalDriver.appium);
		homepage.dslLogout();
	
	}
	
	@Test(priority = 5)
	public void Step5_mobileLogin() throws IOException, ParseException, InterruptedException {

		System.out.println("Step 4, user is logging in ......");
		
	    loginPageObject = new LoginPage(GlobalDriver.appium);
	    loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
		Mobile_CommonActions_Set.waitPrsenceOfElement(By.id("Hallo,"), 5);
	
	}

	@Test(priority = 6)
	public void Step6_HandlePushNotification_FromBackground() {
	
		System.out.println("Step 6, handle pushed notification from the background ......");
		
		homepage = new HomePage(GlobalDriver.appium);
		homepage.handlePushNotificationFromBackground(userUDID,platformName,deepLink,notifcationMessage);
		
	}

	@Test(priority = 7)
	public void Step7_ValidateTheFAQDeeplinkAction_Backround() {

		System.out.println("Step 7, validate FAQ page ......");
		
		pagesValidatorObject = new DeeplinkPagesValidator_DSL(GlobalDriver.appium);
		
		Mobile_CommonActions_Set.scrollDownTo(loginPageObject.acceptGDBR, 5000 , "native-ios");
		Mobile_CommonActions_Set.Click(loginPageObject.acceptGDBR);
		
		pagesValidatorObject.validateFAQPage();
		
	}


//	@Test(priority = 6)
//	public void Step6_HandlePushNotificationFromFrontgound_AfterKillingTheApp() {
//		
//		System.out.println("Step 6, handle pushed notification after killing the app ......");
//		
//		homepage = new HomePage(GlobalDriver.appium);
//		homepage.handlePushNotificationFromBackground(userUDID,platformName,deepLink,notifcationMessage);
//	}
//	
//	@Test(priority = 7)
//	public void Step7_ValidateTheFAQDeeplinkAction_AfterKillingTheApp() {
//		
//		System.out.println("Step 7, validate FAQ page ......");
//		
//		pagesValidatorObject = new PushedNotificationPagesValidator_DSL(GlobalDriver.appium);
//		pagesValidatorObject.validateFAQPage();
//	
//	}
//	
//	@Test(priority = 8)
//	public void Step8_dslLogout() {
//        System.out.println("Finally, user is logging out ....");
//		
//		homepage = new HomePage(GlobalDriver.appium);
//		homepage.dslLogout();
//		
//	}
}