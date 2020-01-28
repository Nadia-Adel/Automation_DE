package newLoginScenarios.DSLScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC029_Stubs_DSL_FailDataRequestWith500And504And510And404 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}

	@Test(priority = 2)
	public void Step2_FailUserDataWithErrorCode500() throws InterruptedException, IOException {
		System.out.println("Step2");

		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_500_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() {
		System.out.println("Step3");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 4)
	public void Step4_SetUserDataWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}

	@Test(priority = 5)
	public void Step5_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step5");
		loginPageObject = new LoginPage(GlobalDriver.appium);

		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}

	@Test(priority = 6)
	public void Step6_FailUserDataWithErrorCode504() throws InterruptedException, IOException {
		System.out.println("Step6");
		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_504_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 7)
	public void Step7_ValidteBlockingScreen() {
		System.out.println("Step7");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 8)
	public void Step8_SetUserDataWith200AndValidateGDBR() throws InterruptedException, IOException {
		System.out.println("Step8");

		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}


	@Test(priority = 9)
	public void Step9_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {
		System.out.println("Step9");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}

	@Test(priority = 10)
	public void Step10_FailUserDataWithErrorCode510() throws InterruptedException, IOException {
		System.out.println("Step10");

		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_510_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);	
	}

	@Test(priority = 11)
	public void Step11_ValidteBlockingScreen() {
		System.out.println("Step11");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}


	@Test(priority = 12)
	public void Step12_SetUserDataWith200AndValidateGDBR() throws InterruptedException, IOException {
		System.out.println("Step12");
		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}



	@Test(priority = 13)
	public void Step13_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {
		System.out.println("Step13");
		loginPageObject = new LoginPage(GlobalDriver.appium);

		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
	}

	@Test(priority = 14)
	public void Step14_FailUserDataWithErrorCode404() throws InterruptedException, IOException {
		System.out.println("Step10");

		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_404_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 15)
	public void Step15_ValidteBlockingScreen() {
		System.out.println("Step15");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 16)
	public void Step16_SetUserDataWith200AndValidateGDBR() throws InterruptedException, IOException {
		System.out.println("Step16");
		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}
}
