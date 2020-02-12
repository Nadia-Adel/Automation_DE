package newLoginScenarios.DSLScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC028_Stubs_DSL_FailStartSessionWith403And402And401 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_SetUserDataToBeDSLUser() throws InterruptedException, IOException {

		System.out.println("Step1");
		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
	}
	
	@Test(priority = 2)
	public void Step2_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step2");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}
	
	
	@Test(priority = 3)
	public void Step3_FailStartSessionWithErrorCode401() throws InterruptedException, IOException {

		System.out.println("Step3");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_401_path");
		apiURL= SandboxConfigReader.getProberty("StartSession_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 4)
	public void Step4_ValidteBlockingScreen() {
		System.out.println("Step4");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}

	@Test(priority = 5)
	public void Step5_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));

	}

	@Test(priority = 6)
	public void Step6_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step6");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
	}

	
	@Test(priority = 7)
	public void Step7_FailStartSessionWithErrorCode402() throws InterruptedException, IOException {

		System.out.println("Step7");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_402_path");
		apiURL= SandboxConfigReader.getProberty("StartSession_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 8)
	public void Step8_ValidteBlockingScreen() {
		System.out.println("Step8");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}

	@Test(priority = 9)
	public void Step9_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {
		System.out.println("Step9");

		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}


	@Test(priority = 10)
	public void Step10_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {
		System.out.println("Step10");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		
	}

	@Test(priority = 11)
	public void Step11_FailStartSessionWithErrorCode403() throws InterruptedException, IOException {
		System.out.println("Step11");

		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_402_path");
		apiURL= SandboxConfigReader.getProberty("StartSession_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 12)
	public void Step12_ValidteBlockingScreen() {
		System.out.println("Step12");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}


	@Test(priority = 13)
	public void Step13_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {
		System.out.println("Step13");
		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	
	}
}
