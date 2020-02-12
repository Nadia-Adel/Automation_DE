package newLoginScenarios.UCMScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC037_UCM_FaildTariffPlanGetResponseWithErrorCode404Or500Or510 extends MobileTestBase {


	@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));

	}

	@Test(priority = 2)
	public void Step2_failResponseWith500() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_500_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[47]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.mobileLoginBtn);
	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() {
		System.out.println("Step4");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 4)
	public void Step4_SetResponseWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_200_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[47]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
		
	}


	@Test(priority = 5)
	public void Step5_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step5");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));

	}

	@Test(priority = 6)
	public void Step6_failResponseWith500() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_404_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[47]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 7)
	public void Step7_ValidteBlockingScreen() {
		System.out.println("Step4");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 8)
	public void Step8_SetResponseWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_200_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[47]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
		
	}
	
	@Test(priority = 9)
	public void Step9_LaunchTheAppAndOpenMobileTab() throws IOException, ParseException {

		System.out.println("Step5");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_Mobile(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));

	}

	@Test(priority = 10)
	public void Step10_failResponseWith500() throws InterruptedException, IOException {

		resFilePath=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_510_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[47]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}

	@Test(priority = 11)
	public void Step11_ValidteBlockingScreen() {
		System.out.println("Step4");
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 12)
	public void Step12_SetResponseWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_200_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_TariffBooked_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[47]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.validateLoginBlockingScreenAfterPassWith200_all();
		
	}
}
