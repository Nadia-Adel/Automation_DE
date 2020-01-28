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

public class TC001_Postpaid_PermissionsScreen_ErrorHandling_FailFCAPIGET extends MobileTestBase{

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("PostpaidUser_Stubs"), GetUserFromJson.getpassword("PostpaidUser_Stubs"));

	}

	@Test(priority = 2)
	public void Step2_FailFCAPIWithErrorCode500() throws InterruptedException, IOException {
		System.out.println("Step2");

		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_500_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

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
		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");

		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();

	}

	@Test(priority = 5)
	public void Step5_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step5");

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("PostpaidUser_Stubs"), GetUserFromJson.getpassword("PostpaidUser_Stubs"));
	}

	@Test(priority = 6)
	public void Step6_FailFCAPIWithErrorCode510() throws InterruptedException, IOException {
		System.out.println("Step6");

		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_510_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);

	}

	@Test(priority = 7)
	public void Step7_ValidteBlockingScreen() {
		System.out.println("Step7");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 8)
	public void Step8_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step8");
		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}

	////////////////

	@Test(priority = 9)
	public void Step9_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step9");

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("PostpaidUser_Stubs"), GetUserFromJson.getpassword("PostpaidUser_Stubs"));
	}

	@Test(priority = 10)
	public void Step10_FailFCAPIWithErrorCode504() throws InterruptedException, IOException {
		System.out.println("Step10");

		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_504_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);

	}

	@Test(priority = 11)
	public void Step11_ValidteBlockingScreen() {
		System.out.println("Step11");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 12)
	public void Step12_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step12");
		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

	}
	//////////////////////////////////////


	@Test(priority = 13)
	public void Step13_LaunchTheAppAndOpenMoboileTab() throws IOException, ParseException {

		System.out.println("Step13");

		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("PostpaidUser_Stubs"), GetUserFromJson.getpassword("PostpaidUser_Stubs"));
	}

	@Test(priority = 14)
	public void Step14_FailFCAPIWithErrorCode404() throws InterruptedException, IOException {
		System.out.println("Step14");

		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_404_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);

	}

	@Test(priority = 15)
	public void Step15_ValidteBlockingScreen() {
		System.out.println("Step15");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 16)
	public void Step16_SetStartSessionWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step15");
		resFilePath=SandboxConfigReader.getProberty("FCAPI_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCAPI_GET_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[79]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		//loginPageObject.validateLoginBlockingScreenAfterPassWith200_DSL();

	}


}

