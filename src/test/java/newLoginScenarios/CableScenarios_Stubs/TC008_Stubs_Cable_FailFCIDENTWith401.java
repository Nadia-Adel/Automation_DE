package newLoginScenarios.CableScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC008_Stubs_Cable_FailFCIDENTWith401 extends MobileTestBase {


	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenCableTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("CableUser_Stubs"), GetUserFromJson.getpassword("CableUser_Stubs"));		
	}
	
	@Test(priority = 2)
	public void Step2_SetUserDataToBeCableUser() throws InterruptedException, IOException {

		System.out.println("Step2");
		resFilePath=SandboxConfigReader.getProberty("userData_Cable_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
	}

	@Test(priority = 3)
	public void Step3_FailFCIDENTWithErrorCode401() throws InterruptedException, IOException {
		System.out.println("Step3");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_401_Path");
		apiURL= SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 4)
	public void Step4_ValidteBlockingScreen() throws IOException, ParseException {
		System.out.println("Step4");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	
	}

	@Test(priority = 5)
	public void Step5_SetFCIDENTWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("CableUser_Stubs"), GetUserFromJson.getpassword("CableUser_Stubs"));
	}
}
