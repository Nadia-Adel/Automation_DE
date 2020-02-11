package ios_pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;

public class LoginPage {

	public LoginPage(AppiumDriver<MobileElement> appium) {
		PageFactory.initElements(new AppiumFieldDecorator(appium), this);
	}

	@iOSXCUITFindBy(id = "Internet-Passwort Login")
	public WebElement internetPasswordLogin;

	@iOSXCUITFindBy(id = "manual_login_msisdn_tv")
	public WebElement usernameTxtField;

	@iOSXCUITFindBy(id = "manual_login_password_tv")
	public WebElement passwordTxtField;

	@iOSXCUITFindBy(id = "Einloggen")
	public WebElement mobileLoginBtn;

	@iOSXCUITFindBy(id = "collectionView")
	public WebElement collectionView;

	@iOSXCUITFindBy(id = "Weiter")
	public WebElement acceptGDBR;

	//@iOSXCUITFindBy(id = "MeinDSL")
	@iOSXCUITFindBy(id = "Internet & Festnetz")
	//@iOSXCUITFindBy(id = "dsl_cable_tv")
	public WebElement meinDSLTab;

	@iOSXCUITFindBy(id = "manual_login_btn")
	public WebElement dslLoginBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"ToppyLoginLogo\"]")
	public WebElement toppyLoginLogo;


	@iOSXCUITFindBy(id = "MeinMobilfunk")
	public WebElement mobileLoginTab;

	@iOSXCUITFindBy(id = "Der Login ist fehlgeschlagen. "
			+ "Bitte überprüfe dein Kennwort und versuche es erneut. Bitte beachte, dass bei 3 maliger Falscheingabe "
			+ "Dein Zugang aus Sicherheitsgründen für 24 Stunden gesperrt wird.")
	public WebElement invalidCredentialsMessage_txt;

	@iOSXCUITFindBy(id = "Mein DSL Login fehlgeschlagen")
	public WebElement StartSession401ErrorMessage_txt;

	@iOSXCUITFindBy(id = "OK")
	public WebElement confirmInvalidCredentialsMessage_btn;

	@iOSXCUITFindBy(id = "Nochmal versuchen")
	public WebElement reTryBtn_BlockingScreen;

	@iOSXCUITFindBy(id = "Hallo,")
	public WebElement halloOnboarding;

	public void validateLoginBlockingScreen() {

		Mobile_CommonActions_Set.setExplicitWait(reTryBtn_BlockingScreen, 20);
		Mobile_CommonActions_Set.Click(reTryBtn_BlockingScreen);
		Mobile_CommonActions_Set.setExplicitWait(reTryBtn_BlockingScreen, 20);
	}

	public void validateLoginErrorPopup_error401_402_403() {

		Mobile_CommonActions_Set.Click(confirmInvalidCredentialsMessage_btn);
	
		try{
			Mobile_CommonActions_Set.Click(dslLoginBtn);
		}
		catch (Exception e) {
			// TODO: handle exception
			Mobile_CommonActions_Set.Click(mobileLoginBtn);
		}
		Mobile_CommonActions_Set.setExplicitWait(confirmInvalidCredentialsMessage_btn, 20);
	}

	public void validateNewLoginInvalidCredentials_Mobile(String IncorrectMSISDN, String password) {

		// assertTrue(toppyLoginLogo.isDisplayed());
		// CommonActions_Set.setExplicitWait(toppyLoginLogo, 120);

		Mobile_CommonActions_Set.setExplicitWait(internetPasswordLogin, 60);
		Mobile_CommonActions_Set.Click(internetPasswordLogin);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, IncorrectMSISDN);

		Mobile_CommonActions_Set.enterText(passwordTxtField, password);

		Mobile_CommonActions_Set.Click(mobileLoginBtn);

		Mobile_CommonActions_Set.setExplicitWait(invalidCredentialsMessage_txt, 20);
		Mobile_CommonActions_Set.Click(confirmInvalidCredentialsMessage_btn);

	}

	public void validateNewLoginInvalidCredentials_DSL(String IncorrectUsername, String password) {

		// assertTrue(toppyLoginLogo.isDisplayed());
		// CommonActions_Set.setExplicitWait(toppyLoginLogo, 120);

		Mobile_CommonActions_Set.setExplicitWait(meinDSLTab, 60);
		Mobile_CommonActions_Set.Click(meinDSLTab);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, IncorrectUsername);

		Mobile_CommonActions_Set.enterText(passwordTxtField, password);

		Mobile_CommonActions_Set.Click(dslLoginBtn);

		//Mobile_CommonActions_Set.setExplicitWait(collectionView, 20);

	}

	
	public void mobileLoginAndStopAtOnBoardingScreen(String username, String password) {
		
		Mobile_CommonActions_Set.setExplicitWait(internetPasswordLogin, 60);
		Mobile_CommonActions_Set.Click(internetPasswordLogin);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, username);

		Mobile_CommonActions_Set.enterText(passwordTxtField, password);

		Mobile_CommonActions_Set.Click(mobileLoginBtn);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");
		assertTrue(acceptGDBR.isDisplayed());
		
	}
	
	
	public void mobileLogin(String username, String password) {

		Mobile_CommonActions_Set.setExplicitWait(internetPasswordLogin, 60);
		Mobile_CommonActions_Set.Click(internetPasswordLogin);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, username);

		Mobile_CommonActions_Set.enterText(passwordTxtField, password);

		Mobile_CommonActions_Set.Click(mobileLoginBtn);

		try {
			Thread.sleep(3000);
			Mobile_CommonActions_Set.setExplicitWait(halloOnboarding, 20);
			System.err.println("Found");
			Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");

			Mobile_CommonActions_Set.Click(acceptGDBR);

			Mobile_CommonActions_Set.setExplicitWait(collectionView, 20);

		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mobile_CommonActions_Set.setExplicitWait(collectionView, 20);
		}
		
	}

	public void dslLogin(String username, String password) {

		Mobile_CommonActions_Set.setExplicitWait(meinDSLTab, 60);
		Mobile_CommonActions_Set.Click(meinDSLTab);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, username);

		Mobile_CommonActions_Set.enterText(passwordTxtField, password);

		Mobile_CommonActions_Set.Click(dslLoginBtn);

		try {
			Thread.sleep(3000);

			Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");

			Mobile_CommonActions_Set.Click(acceptGDBR);
			Mobile_CommonActions_Set.setExplicitWait(collectionView, 20);

		} catch (InterruptedException e) {
			Mobile_CommonActions_Set.setExplicitWait(collectionView, 20);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void dslInvalidLogin(String username, String password) {
		
		Mobile_CommonActions_Set.setExplicitWait(meinDSLTab, 60);
		Mobile_CommonActions_Set.Click(meinDSLTab);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, username);

		Mobile_CommonActions_Set.enterText(passwordTxtField, password);

		Mobile_CommonActions_Set.Click(dslLoginBtn);

	}
	
	public void EnterUserCredentials_Mobile(String username, String anyPassword)

	{

		Mobile_CommonActions_Set.setExplicitWait(mobileLoginTab, 60);
		Mobile_CommonActions_Set.Click(mobileLoginTab);
		Mobile_CommonActions_Set.Click(internetPasswordLogin);

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, username);

		Mobile_CommonActions_Set.enterText(passwordTxtField, anyPassword);

	}

	public void EnterUserCredentials_DSL(String username, String anyPassword)

	{

		Mobile_CommonActions_Set.setExplicitWait(meinDSLTab, 60);
		Mobile_CommonActions_Set.Click(meinDSLTab);
		System.out.println("newInspection");

		Mobile_CommonActions_Set.setExplicitWait(usernameTxtField, 30);
		Mobile_CommonActions_Set.enterText(usernameTxtField, username);

		Mobile_CommonActions_Set.enterText(passwordTxtField, anyPassword);

	}


	public void validateLoginBlockingScreenAfterPassWith200_all() {

		Mobile_CommonActions_Set.Click(reTryBtn_BlockingScreen);
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");
		Mobile_CommonActions_Set.Click(acceptGDBR);
		
		try {
			new HomePage(GlobalDriver.appium).dslLogout();
			System.out.println("LogoutDSL");
		}
		catch (Exception e) {
			new HomePage(GlobalDriver.appium).mobileLogout();
			System.out.println("LogoutMobile");
		}

	}
	
	
	public void validateLoginErrorPopupAfterPassWith200_Mobile(String username, String anyPassword) {

		Mobile_CommonActions_Set.Click(confirmInvalidCredentialsMessage_btn);
	
		Mobile_CommonActions_Set.Click(mobileLoginBtn);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");
		Mobile_CommonActions_Set.Click(acceptGDBR);
		new HomePage(GlobalDriver.appium).mobileLogout();
//
	}
	public void validateLoginErrorPopupAfterPassWith200_DSL(String username, String anyPassword) {

		Mobile_CommonActions_Set.Click(confirmInvalidCredentialsMessage_btn);
		
		
		Mobile_CommonActions_Set.Click(dslLoginBtn);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");
		Mobile_CommonActions_Set.Click(acceptGDBR);
		new HomePage(GlobalDriver.appium).dslLogout();

	}
	
	public void scrollGDBRAfterBlockingScreen() {
		Mobile_CommonActions_Set.Click(reTryBtn_BlockingScreen);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mobile_CommonActions_Set.scrollDownTo(acceptGDBR, 10000, "native-ios");
		
	}
	
	public void acceptGDBR() {
		Mobile_CommonActions_Set.Click(acceptGDBR);
		
	}
	
	public void validateGDPRBlockingScreenAfterPassWith200_all() {

		Mobile_CommonActions_Set.Click(reTryBtn_BlockingScreen);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new HomePage(GlobalDriver.appium).dslLogout();
		System.out.println("LogoutDSL");
		

	}

}

