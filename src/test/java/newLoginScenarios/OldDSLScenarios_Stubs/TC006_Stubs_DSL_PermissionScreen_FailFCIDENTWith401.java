package newLoginScenarios.OldDSLScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC006_Stubs_DSL_PermissionScreen_FailFCIDENTWith401 extends MobileTestBase {


	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));		
	}

	@Test(priority = 2)
	public void Step2_FailFCIDENTWithErrorCode500() throws InterruptedException, IOException {
		System.out.println("Step2");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_401_Path");
		apiURL= SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL"); 
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() throws IOException, ParseException {
		System.out.println("Step3");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	
	}

	@Test(priority = 4)
	public void Step4_SetFCIDENTWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
	}
}
