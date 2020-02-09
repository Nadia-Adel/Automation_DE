package ErrorHandling.DSLScenarios;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Get;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC002_Regression_SetBillAmountWithNULL extends MobileTestBase{

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
	public void Step2_SetBilledUsageAmountToBeNull() throws InterruptedException, IOException {
		//SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	
		System.out.println("Step 2");

		resFilePath=SandboxConfigReader.getProberty("BilledUsage_BillAmount_Null_Path");
		apiURL=SandboxConfigReader.getProberty("BilledUsage_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[25]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}
	
	
	@Test(priority = 3)
	public void Step3_LaunchTheAppAndLoginWithDSLUser() throws IOException, ParseException {

		System.out.println("Step 3");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));		
	}

	
	@Test(priority = 4)
	public void Step4_ValidteIfTileErrorMessageDisplayed() {
		System.out.println("Step 4");

		homePageObject = new HomePage(GlobalDriver.appium);
		assertEquals(Mobile_CommonActions_Get.getText(homePageObject.wideTileErrorText), "Daten konnten nicht geladen werden");
		
		
	}

	@Test(priority = 5)
	public void Step5_ResetBilledUsageToBeWithValue() throws InterruptedException, IOException {
		//	SandBoxes.UpdateSandBox(API_Name, NewBody, newResponseFilePath);	
		System.out.println("Step 5");
		
		resFilePath=SandboxConfigReader.getProberty("BilledUsage_DSL_200_Path");
		apiURL=SandboxConfigReader.getProberty("BilledUsage_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");

		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[25]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}
	
	@Test(priority = 6)
	public void Step6_Logout() {
		homePageObject = new HomePage(GlobalDriver.appium);
		homePageObject.dslLogout();
		
		
	}

}