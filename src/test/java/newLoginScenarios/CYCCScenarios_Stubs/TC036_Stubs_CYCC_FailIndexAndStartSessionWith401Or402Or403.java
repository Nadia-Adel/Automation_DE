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

public class TC036_Stubs_CYCC_FailIndexAndStartSessionWith401Or402Or403 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("CYCCUser_Stubs"), GetUserFromJson.getpassword("CYCCUser_Stubs"));
	}
	
	@Test(priority = 2)
	public void Step2_userIndexResponseWithErrorCode402() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("Index_Mint_VssDublin_402_Path");
		apiURL=SandboxConfigReader.getProberty("Mint_vfssDublin_Index_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_CYCC");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[71]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL,stubsName,textAreaXPath);
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);
	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() {
		System.out.println("Step3");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}

	@Test(priority = 5)
	public void Step5_SetIndexMintDublinResponseWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step5");

		resFilePath=SandboxConfigReader.getProberty("Index_Mint_VssDublin_200_Path");
		apiURL=SandboxConfigReader.getProberty("Mint_vfssDublin_Index_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_CYCC");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[71]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL,stubsName,textAreaXPath);
	}
}