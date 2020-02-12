package newLoginScenarios.DSLScenarios_Stubs;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC025_Stubs_DSL_Fail_Info_Get_Post_With401 extends MobileTestBase {

	
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
	public void Step2_LaunchTheAppAndLoginWithDSLUser() throws IOException, ParseException, InterruptedException {

		System.out.println("Step2");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
		
	}
	

	@Test(priority = 3)
	public void Step3_FailFcInfoGetWithErrorCode401() throws InterruptedException, IOException {
		
		System.out.println("Step3");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_401_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		Mobile_CommonActions_Set.killApp();

	}

	@Test(priority = 4)
	public void Step4_ValidteBlockingScreen() throws MalformedURLException {
		System.out.println("Step4");
		//GlobalDriver.appium.launchApp();
		GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
		//MobileTestBase LaunchApp= new MobileTestBase();
		//LaunchApp.baseTest();
		
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 5)
	public void Step5_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.scrollGDBRAfterBlockingScreen();
	}
	
	@Test(priority = 6)
	public void Step6_FailFcInfoPostWithErrorCode401() throws InterruptedException, IOException {
		
		System.out.println("Step6");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_401_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.acceptGDBR();

	}
	
	@Test(priority = 7)
	public void Step7_ValidteBlockingScreen() throws MalformedURLException {
		
		System.out.println("Step7");
		loginPageObject.validateLoginBlockingScreen();
	}
	
	@Test(priority = 8)
	public void Step8_SetFCInfoPostWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step8");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateGDPRBlockingScreenAfterPassWith200_all();
	}
		

}
