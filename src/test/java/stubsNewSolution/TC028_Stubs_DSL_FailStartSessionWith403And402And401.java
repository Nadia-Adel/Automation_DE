package stubsNewSolution;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader_NewSolution;
import dataFilesReaders.TextFileReader;
import ios_pages.*;
import mobileUtilities.Mobile_CommonActions_Set;
import sandboxNewSolution.SandBoxes;
import sandboxNewSolution.SandBoxes_APIS;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC028_Stubs_DSL_FailStartSessionWith403And402And401 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException, InterruptedException {

		System.out.println("Step1");
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}

	@Test(priority = 2)
	public void Step2_FailStartSessionWithErrorCode401() throws InterruptedException, IOException {

		System.out.println("Step2");
		
		SandBoxes SB ;
		SandBoxes.UpdateSandBox("Start Session" ,TextFileReader.readTextFilAsString(SandboxConfigReader_NewSolution.getProberty("startSession_401")));
		
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}
	
	
	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() {
		System.out.println("Step3");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopup_error401_402_403();
	}

	@Test(priority = 4)
	public void Step4_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {

		System.out.println("Step 4");
		
		SandBoxes.WriteSandBox(SandBoxes_APIS.main(null) );

		System.exit(1);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Thread.sleep(5000);
		
		new HomePage(GlobalDriver.appium).dslLogout();
	}
	
	@Test(priority = 5)
	public void Step5_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step5");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
	}
//
//	/*
//	@Test(priority = 6)
//	public void Step6_FailStartSessionWithErrorCode402() throws InterruptedException, IOException {
//
//		System.out.println("Step6");
//		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_402_path");
//		apiURL= SandboxConfigReader.getProberty("StartSession_URL");
//		stubsName = SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL"); 
//		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
//		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
//		
//		loginPageObject = new LoginPage(GlobalDriver.appium);
//		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
//
//	}*/
//	@Test(priority = 6)
//	public void Step6_FailStartSessionWithErrorCode402() throws InterruptedException, IOException {
//
//		System.out.println("Step6");
//		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_402_path");
//		apiURL= SandboxConfigReader.getProberty("StartSession_URL");
//		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
//		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
//		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
//		
//		loginPageObject = new LoginPage(GlobalDriver.appium);
//		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
//
//	}
//
//	@Test(priority = 7)
//	public void Step7_ValidteBlockingScreen() {
//		System.out.println("Step7");
//		loginPageObject= new LoginPage(GlobalDriver.appium);
//		loginPageObject.validateLoginErrorPopup_error401_402_403();
//	}
//
//	@Test(priority = 8)
//	public void Step8_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {
//		System.out.println("Step 8");
//
//		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
//		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
//		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
//		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
//		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
//		
//		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
//	}
//
//
//	@Test(priority = 9)
//	public void Step9_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {
//		System.out.println("Step9");
//		loginPageObject = new LoginPage(GlobalDriver.appium);
//		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
//		
//	}
//
//	@Test(priority = 10)
//	public void Step10_FailStartSessionWithErrorCode403() throws InterruptedException, IOException {
//		System.out.println("Step10");
//
//		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_402_path");
//		apiURL= SandboxConfigReader.getProberty("StartSession_URL");
//		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
//		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
//		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
//
//		loginPageObject = new LoginPage(GlobalDriver.appium);
//		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
//	}
//
//	@Test(priority = 11)
//	public void Step11_ValidteBlockingScreen() {
//		System.out.println("Step11");
//		loginPageObject= new LoginPage(GlobalDriver.appium);
//		loginPageObject.validateLoginErrorPopup_error401_402_403();
//	}
//
//
//	@Test(priority = 12)
//	public void Step12_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException, ParseException {
//		resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
//		apiURL=SandboxConfigReader.getProberty("StartSession_URL");
//		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
//		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[62]/div[2]/form/div/div[2]/div[2]/textarea";
//		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
//		
//		loginPageObject.validateLoginErrorPopupAfterPassWith200_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
//	
//	}

}
