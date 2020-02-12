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

public class TC034_Stubs_CYCC_FailDataRequestAndStartSessionWith401 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("CYCCUser_Stubs"), GetUserFromJson.getpassword("CYCCUser_Stubs"));
	}

	@Test(priority = 2)
	public void Step2_userStartSessionWithErrorCode401() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_401_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}

	@Test(priority = 3)
	public void Step3_userDataResponseWithErrorCode401() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("userData_Response_401_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL,stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);
	}

	@Test(priority = 4)
	public void Step4_ValidteBlockingScreen() {

		System.out.println("Step4");
	     
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}

	@Test(priority = 5)
	public void Step5_SetUserStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}
	@Test(priority = 6)
	public void Step6_SetUserDataResponseWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step6");

		resFilePath=SandboxConfigReader.getProberty("userData_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopupAfterPassWith200_Mobile(GetUserFromJson.getUsername("CYCCUser_Stubs"), GetUserFromJson.getpassword("CYCCUser_Stubs"));
	}
}