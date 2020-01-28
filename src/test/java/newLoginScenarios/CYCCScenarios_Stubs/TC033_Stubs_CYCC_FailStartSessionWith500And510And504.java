package newLoginScenarios.CYCCScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC033_Stubs_CYCC_FailStartSessionWith500And510And504 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("CYCCUser_Stubs"), GetUserFromJson.getpassword("CYCCUser_Stubs"));
	}

	@Test(priority = 2)
	public void Step2_FailStartSessionWithErrorCode504() throws InterruptedException, IOException {
		System.out.println("Step2");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_504_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";

		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		Thread.sleep(3000);
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);
	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() {
		System.out.println("Step3");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 4)
	public void Step4_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL,stubsName,textAreaXPath);
		
	//	loginPageObject = new LoginPage(GlobalDriver.appium);
	//	loginPageObject.validateLoginBlockingScreenAfterPassWith200();

	}
}
