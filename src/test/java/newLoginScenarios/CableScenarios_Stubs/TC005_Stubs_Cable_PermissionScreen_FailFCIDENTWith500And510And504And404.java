package newLoginScenarios.CableScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC005_Stubs_Cable_PermissionScreen_FailFCIDENTWith500And510And504And404 extends MobileTestBase {


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
	public void Step3_FailFCIDENTWithErrorCode500() throws InterruptedException, IOException {
		System.out.println("Step3");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_500_Path");
		apiURL= SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Cable"); 
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);

	}

	@Test(priority = 4)
	public void Step4_ValidteBlockingScreen() {
		System.out.println("Step4");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 5)
	public void Step4_SetFCIDENTWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}

	@Test(priority = 6)
	public void Step6_LaunchTheAppAndOpenCableTab() throws IOException, ParseException {
		System.out.println("Step6");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("CableUser_Stubs"), GetUserFromJson.getpassword("CableUser_Stubs"));
	}

	@Test(priority = 7)
	public void Step7_FailFCIDENTWithErrorCode504() throws InterruptedException, IOException {
		System.out.println("Step7");

		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_504_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 8)
	public void Step8_ValidteBlockingScreen() {
		
		System.out.println("Step8");
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 9)
	public void Step9_SetFCIDENTWith200AndValidateGDBR() throws InterruptedException, IOException {
		System.out.println("Step9");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
	}


	@Test(priority = 10)
	public void Step10_LaunchTheAppAndOpenCableTab() throws IOException, ParseException {
		System.out.println("Step10");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("CableUser_Stubs"), GetUserFromJson.getpassword("CableUser_Stubs"));
	}

	@Test(priority = 11)
	public void Step11_FailFCIDENTWithErrorCode510() throws InterruptedException, IOException {
		System.out.println("Step11");

		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_510_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 12)
	public void Step12_ValidteBlockingScreen() {
		System.out.println("Step12");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}


	@Test(priority = 13)
	public void Step13_SetFCIDENTWith200AndValidateGDBR() throws InterruptedException, IOException {
		System.out.println("Step13");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();

	}
	
	@Test(priority = 14)
	public void Step14_LaunchTheAppAndOpenCableTab() throws IOException, ParseException {
		System.out.println("Step14");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("CableUser_Stubs"), GetUserFromJson.getpassword("CableUser_Stubs"));
	}

	@Test(priority = 15)
	public void Step15_FailFCIDENTWithErrorCode510() throws InterruptedException, IOException {
		System.out.println("Step15");

		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_404_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 16)
	public void Step16_ValidteBlockingScreen() {
		System.out.println("Step16");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}


	@Test(priority = 17)
	public void Step17_SetFCIDENTWith200AndValidateGDBR() throws InterruptedException, IOException {
		System.out.println("Step17");
		resFilePath=SandboxConfigReader.getProberty("FCIDENT_GET_200_Path");
		apiURL=SandboxConfigReader.getProberty("FCIdent_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[86]/div[2]/form/div/div[2]/div[2]/textarea"; 
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();

	}
}
