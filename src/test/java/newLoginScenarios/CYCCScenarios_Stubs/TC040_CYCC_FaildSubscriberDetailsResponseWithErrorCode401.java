package newLoginScenarios.CYCCScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC040_CYCC_FaildSubscriberDetailsResponseWithErrorCode401 extends MobileTestBase {


	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("CYCCUser_Stubs"), GetUserFromJson.getpassword("CYCCUser_Stubs"));

	}

	@Test(priority = 2)
	public void Step2_failResponseWith401() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("SubscriberDetails_Get_401_Path");
		apiURL=SandboxConfigReader.getProberty("SubscriberDetails_Get_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[38]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);
	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() {
		System.out.println("Step3");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}

	@Test(priority = 4)
	public void Step4_SetResponseWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("SubscriberDetails_Get_200_Path");
		apiURL=SandboxConfigReader.getProberty("SubscriberDetails_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[38]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		//loginPageObject = new LoginPage(GlobalDriver.appium);
		//loginPageObject.validateLoginErrorPopupAfterPassWith200_Mobile(GetUserFromJson.getUsername("CYCCUser_Stubs"), GetUserFromJson.getpassword("CYCCUser_Stubs"));
		
	}
}
