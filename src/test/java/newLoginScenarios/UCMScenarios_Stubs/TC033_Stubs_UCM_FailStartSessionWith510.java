package newLoginScenarios.UCMScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC033_Stubs_UCM_FailStartSessionWith510 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));
		
	}

	@Test(priority = 2)
	public void Step2_FailStartSessionWithErrorCode510() throws InterruptedException, IOException {
		System.out.println("Step2");
		
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_510_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName, textAreaXPath);
		
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
		
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_510_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName, textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}

	
}
