package newLoginScenarios.OldDSLScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC053_FailBilledUsageRequest401_DSL  extends MobileTestBase{

	@Test(priority = 1)
	public void Step1_dslLogin() throws IOException, ParseException {
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin_WithOnBoarding(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));	
	}
	
	/*@Test(priority = 1)
	public void Step1_LaunchTheAppAndOpenDSLTab() throws IOException, ParseException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
	}*/

	
	@Test(priority = 2)
	public void Step2_FailBilledUsageResponseWith401() throws IOException, ParseException, InterruptedException {
		resFilePath=SandboxConfigReader.getProberty("BilledUsage_DSL_401_Path");
		apiURL=SandboxConfigReader.getProberty("BilledUsage_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath= "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[25]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);	
		
		
	}

	@Test(priority = 3)
	public void validateHomeScreenAfterFailure() {
		
		homePageObject = new HomePage(GlobalDriver.appium);
		
		Mobile_CommonActions_Set.Click(homePageObject.homeIcon);
		System.out.println("Refresh");
		Mobile_CommonActions_Set.setExplicitWait(loginPageObject.usernameTxtField,30);	
		System.out.println("Login");

	}
	
	@Test(priority = 4)
	public void setStatusCode200() throws InterruptedException, IOException {
		resFilePath=SandboxConfigReader.getProberty("BilledUsage_DSL_200_Path");
		apiURL=SandboxConfigReader.getProberty("BilledUsage_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_Postpaid_DSL");
		textAreaXPath= "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[25]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);	

	}
}
