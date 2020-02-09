package ErrorHandling.DSLScenarios;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import sandboxNewSolution.SandBoxes;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC001_Regression_FailSubcriptionDetails_401_TariffPlan_500 extends MobileTestBase{

	@Test(priority = 1)
	public void Step1_SetUserDataToBeDSLUser() throws InterruptedException, IOException {
	
		//SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	

		System.out.println("Step 1");
		
		resFilePath=SandboxConfigReader.getProberty("userData_FixedNet_Response_200_path");
		apiURL=SandboxConfigReader.getProberty("UserDataResponse_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[42]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

	} 

	@Test(priority = 2)
	public void Step2_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step 2");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));		
	}

	@Test(priority = 3)
	public void Step3_FailSubscription_Get_401() throws InterruptedException, IOException {
		//SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	
		System.out.println("Step 3");

		resFilePath=SandboxConfigReader.getProberty("Subscriptions_Get_401_Path");
		apiURL=SandboxConfigReader.getProberty("Subscriptions_fixednet_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[27]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}

	@Test(priority = 4)
	public void Step4_FailTariffPlan_ACN_Get_500() throws InterruptedException, IOException {
		//SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	

		System.out.println("Step 4");

		resFilePath=SandboxConfigReader.getProberty("TariffPaln_ACN_Get_500_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_ACN_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[26]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}

	@Test(priority = 5)
	public void Step5_ValidteIfAppRedirectedToLoginScreen() {
		System.out.println("Step 5");

		homePageObject = new HomePage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(homePageObject.homeIcon);
	
		loginPageObject = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.setExplicitWait(loginPageObject.passwordTxtField, 20);
		assertTrue(loginPageObject.passwordTxtField.isDisplayed());
		
	}


	@Test(priority = 6)
	public void Step6_FailSubscription_Get_200() throws InterruptedException, IOException {
		//	SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	
		System.out.println("Step 6");
		
		resFilePath=SandboxConfigReader.getProberty("Subscriptions_Get_200_Path");
		apiURL=SandboxConfigReader.getProberty("Subscriptions_fixednet_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[27]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}
	
	@Test(priority = 7)
	public void Step7_FailSubscription_Get_200() throws InterruptedException, IOException {
		//SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	

		System.out.println("Step 7");

		resFilePath=SandboxConfigReader.getProberty("TariffPaln_ACN_Get_200_Path");
		apiURL=SandboxConfigReader.getProberty("TariffPlan_Get_ACN_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[26]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}

}