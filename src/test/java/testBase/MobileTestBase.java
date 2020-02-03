package testBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import externalDataFilesHandeller.CapabilitiesFileReader;
import externalDataFilesHandeller.ConfigurationFileHandeller;
import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.MenuItemsPage;
import ios_pages.PushedNotificationPagesValidator_Mobile;
import mobileUtilities.Mobile_CommonActions_Set;
import sandboxTestCases.UpdateSandBox;

public class MobileTestBase {

	public String userUDID;
	public String platformName;
	public String deepLink;
	public String notifcationMessage;
	public HomePage homePageObject =null; 
	public WebElement globalElement =null;
	public LoginPage loginPageObject =null;
	public String resFilePath;
	public String apiURL;
	public String stubsName;
	public PushedNotificationPagesValidator_Mobile pagesValidatorObject = null;
	public MenuItemsPage menuObject = null;
	public String textAreaXPath;

	@BeforeClass
	public void baseTest () throws MalformedURLException {

		CapabilitiesFileReader cap = new CapabilitiesFileReader();

		if(ConfigurationFileHandeller.getPlatformName().equalsIgnoreCase("ios")) {

			System.out.println("lauching IOS ....");
			GlobalDriver.appium = new IOSDriver<MobileElement>(new URL(ConfigurationFileHandeller.getAppiumServerURL()),cap.getCapabilities());
		}
		else if(ConfigurationFileHandeller.getPlatformName().equalsIgnoreCase("android")) {

			System.out.println("lauching Android ....");
			GlobalDriver.appium = new AndroidDriver<MobileElement>(new URL(ConfigurationFileHandeller.getAppiumServerURL()),cap.getCapabilities());			
		}

		GlobalDriver.appium.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}


	@Test
	public void Step1_dslLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		lgn.dslLogin(GetUserFromJson.getUsername("DSLUser"),GetUserFromJson.getpassword("DSLUser"));
	}

	@AfterClass
	public void tearDown() {

		GlobalDriver.appium.closeApp();
	}

	public void setStatusCode(String resFilePath, String apiURL,String stubsName,String textAreaXpath) throws InterruptedException, IOException {

		webTestBase.startDriver();

		String username = SandboxConfigReader.getProberty("username");
		String password = SandboxConfigReader.getProberty("password");

		UpdateSandBox.update(username, password, stubsName, apiURL, resFilePath,textAreaXpath);

		webTestBase.stopDriver();

	}
	
	public void setStatusCodeMulltipleURLs(String resFilePath, String apiURL,String stubsName,String textAreaXpath) throws InterruptedException, IOException {

		webTestBase.startDriver();

		String username = SandboxConfigReader.getProberty("username");
		String password = SandboxConfigReader.getProberty("password");

		UpdateSandBox.updateMultipleURLs(username, password, stubsName, apiURL, resFilePath,textAreaXpath);

		webTestBase.stopDriver();

	}


	public void TerminateTheAppAfterSuccessCode() throws InterruptedException {

		Thread.sleep(3000);
		Mobile_CommonActions_Set.scrollDownTo(loginPageObject.acceptGDBR, 10000, "native-ios");
		Mobile_CommonActions_Set.setExplicitWait(loginPageObject.acceptGDBR, 30);
		Mobile_CommonActions_Set.killApp();
	}

////Users/medhatali/eclipse-workspace/MobileFramework/cms/cms
	//Users/medhatali/Documents/MobileFramework/cms/cms
}
