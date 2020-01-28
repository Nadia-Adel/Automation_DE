package newLoginScenarios.DSLScenarios_Stubs;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import externalDataFilesHandeller.SandboxConfigReader;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC022_Stubs_DSL_Fail_Info_Get_Post_With403And405And415 extends MobileTestBase {

	@Test(priority = 1)
	public void Step1_LaunchTheAppAndLoginWithDSLUser() throws IOException, ParseException, InterruptedException {

		System.out.println("Step1");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
		
	}

	@Test(priority = 2)
	public void Step2_FailFcInfoGetWithErrorCode403() throws InterruptedException, IOException {
		
		System.out.println("Step2");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_403_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		Mobile_CommonActions_Set.killApp();

	}

	@Test(priority = 3)
	public void Step3_ValidteBlockingScreen() throws MalformedURLException {
		System.out.println("Step3");
		//GlobalDriver.appium.launchApp();
		GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
		//MobileTestBase LaunchApp= new MobileTestBase();
		//LaunchApp.baseTest();
		
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 4)
	public void Step4_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step4");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.scrollGDBRAfterBlockingScreen();
	}
	
	@Test(priority = 5)
	public void Step5_FailFcInfoPostWithErrorCode403() throws InterruptedException, IOException {
		
		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_403_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.acceptGDBR();

	}
	
	@Test(priority = 6)
	public void Step6_ValidteBlockingScreen() throws MalformedURLException {
		
		System.out.println("Step6");
		loginPageObject.validateLoginBlockingScreen();
	}
	
	@Test(priority = 7)
	public void Step7_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step7");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateGDPRBlockingScreenAfterPassWith200_all();
	}
	
	@Test(priority = 8)
	public void Step8_LaunchTheAppAndLoginWithDSLUser() throws IOException, ParseException, InterruptedException {

		System.out.println("Step8");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
		
	}

	@Test(priority = 9)
	public void Step9_FailFcInfoGetWithErrorCode405() throws InterruptedException, IOException {
		
		System.out.println("Step9");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_405_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		Mobile_CommonActions_Set.killApp();

	}

	@Test(priority = 10)
	public void Step10_ValidteBlockingScreen() throws MalformedURLException {
		System.out.println("Step10");
		//GlobalDriver.appium.launchApp();
		GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
		//MobileTestBase LaunchApp= new MobileTestBase();
		//LaunchApp.baseTest();
		
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 11)
	public void Step11_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step11");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.scrollGDBRAfterBlockingScreen();
	}
	
	@Test(priority = 12)
	public void Step12_FailFcInfoPostWithErrorCode405() throws InterruptedException, IOException {
		
		System.out.println("Step5");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_405_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.acceptGDBR();

	}
	
	@Test(priority = 13)
	public void Step13_ValidteBlockingScreen() throws MalformedURLException {
		
		System.out.println("Step13");
		loginPageObject.validateLoginBlockingScreen();
	}
	
	@Test(priority = 14)
	public void Step14_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step14");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateGDPRBlockingScreenAfterPassWith200_all();
	}
	
	@Test(priority = 15)
	public void Step15_LaunchTheAppAndLoginWithDSLUser() throws IOException, ParseException, InterruptedException {

		System.out.println("Step15");
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.EnterUserCredentials_DSL(GetUserFromJson.getUsername("DSLUser_Stubs"), GetUserFromJson.getpassword("DSLUser_Stubs"));
		Mobile_CommonActions_Set.Click(loginPageObject.dslLoginBtn);
		
	}

	@Test(priority = 16)
	public void Step16_FailFcInfoGetWithErrorCode415() throws InterruptedException, IOException {
		
		System.out.println("Step16");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_415_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		Mobile_CommonActions_Set.killApp();

	}

	@Test(priority = 17)
	public void Step17_ValidteBlockingScreen() throws MalformedURLException {
		System.out.println("Step17");
		//GlobalDriver.appium.launchApp();
		GlobalDriver.appium.activateApp("com.tsse.meinvodafone");
		//MobileTestBase LaunchApp= new MobileTestBase();
		//LaunchApp.baseTest();
		
		loginPageObject.validateLoginBlockingScreen();
	}

	@Test(priority = 18)
	public void Step18_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step18");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Get_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Get_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[87]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.scrollGDBRAfterBlockingScreen();
	}
	
	@Test(priority = 19)
	public void Step19_FailFcInfoPostWithErrorCode415() throws InterruptedException, IOException {
		
		System.out.println("Step19");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_415_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium);
		loginPageObject.acceptGDBR();

	}
	
	@Test(priority = 20)
	public void Step20_ValidteBlockingScreen() throws MalformedURLException {
		
		System.out.println("Step20");
		loginPageObject.validateLoginBlockingScreen();
	}
	
	@Test(priority = 21)
	public void Step21_SetFCInfoGetWith200AndValidateGDBR() throws InterruptedException, IOException {

		System.out.println("Step21");
		resFilePath=SandboxConfigReader.getProberty("FCInfo_Post_200_path");
		apiURL=SandboxConfigReader.getProberty("FCInfo_Post_URL");
		stubsName=SandboxConfigReader.getProberty("automationStubs_Cable");
		textAreaXPath="/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[88]/div[2]/form/div/div[2]/div[2]/textarea";
		setStatusCodeMulltipleURLs(resFilePath, apiURL, stubsName,textAreaXPath);
		
		loginPageObject= new LoginPage(GlobalDriver.appium); 
		loginPageObject.validateGDPRBlockingScreenAfterPassWith200_all();
	}
	

}
