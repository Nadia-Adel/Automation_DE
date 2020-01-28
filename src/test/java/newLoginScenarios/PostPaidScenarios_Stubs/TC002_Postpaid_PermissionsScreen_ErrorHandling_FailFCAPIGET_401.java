package newLoginScenarios.PostPaidScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC002_Postpaid_PermissionsScreen_ErrorHandling_FailFCAPIGET_401 extends MobileTestBase {
	
	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("PostpaidUser_Stubs"), GetUserFromJson.getpassword("PostpaidUser_Stubs"));

	}
	
	@Test(priority = 2)
	public void Step2_FCAPIWithErrorCode401() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_401_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
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
	public void Step5_SetFCAPIResponseWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step6");
		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopupAfterPassWith200_Mobile(GetUserFromJson.getUsername("PostpaidUser_Stubs"), GetUserFromJson.getpassword("PostpaidUser_Stubs"));

	}

}
