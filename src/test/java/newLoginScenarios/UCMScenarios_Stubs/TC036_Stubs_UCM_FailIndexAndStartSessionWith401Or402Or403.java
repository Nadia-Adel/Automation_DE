package newLoginScenarios.UCMScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC036_Stubs_UCM_FailIndexAndStartSessionWith401Or402Or403 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));
	}



	@Test(priority = 2)
	public void Step2_userIndexResponseWithErrorCode401() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("Index_Mint_VssDublin_401_Path");
		apiURL=SandboxConfigReader.getProberty("Mint_vfssDublin_Index_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[71]/div[2]/form/div/div[2]/div[2]/textarea";
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
	public void Step5_SetIndexMintDublinResponseWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step5");

		resFilePath=SandboxConfigReader.getProberty("Index_Mint_VssDublin_200_Path");
		apiURL=SandboxConfigReader.getProberty("Mint_vfssDublin_Index_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[71]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL,stubsName,textAreaXPath);

		new LoginPage(GlobalDriver.appium).validateLoginErrorPopupAfterPassWith200_Mobile(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));

	}
}