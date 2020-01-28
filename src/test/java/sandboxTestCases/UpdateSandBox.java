package sandboxTestCases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import externalDataFilesHandeller.SandboxConfigReader;
import testBase.GlobalDriver;
import testBase.webTestBase;
import webPages.DashBoardPage;
import webPages.SignInPage;
import webPages.Stubs;
import webUtilities.CommonActions_Set;

public class UpdateSandBox extends webTestBase {

	static SignInPage signInPageObject;
	static DashBoardPage DashBoardPageobject;

	static Stubs StubsObject;

	@Test
	public static void updateSandBox() throws IOException, InterruptedException
	{
		System.out.println("Start gecko driver");

		startDriver();	

		System.out.println("Start gecko driver");

		StubsObject = new Stubs(GlobalDriver.seleniumDriver);

		String apiURL=SandboxConfigReader.getProberty("StartSession_URL");
		StubsObject.setApiURL(apiURL);

		String resFilePath=SandboxConfigReader.getProberty("StartSession_Response_200_path");
		responseJson = FileUtils.readFileToString(new File(resFilePath), StandardCharsets.UTF_8);
		signInPageObject = new SignInPage(GlobalDriver.seleniumDriver);

		DashBoardPageobject = new DashBoardPage(GlobalDriver.seleniumDriver);


		signInPageObject.login("Automation@testing.com","Automation123");//sandboxUsername, sandboxPassword);

		CommonActions_Set.waitElement(DashBoardPageobject.dashboardBtn, 30);

		Assert.assertTrue(DashBoardPageobject.dashboardBtn.isDisplayed());

		String stubsName="automation-cycc";
		GlobalDriver.seleniumDriver.navigate().to("https://getsandbox.com/sandboxes/" + stubsName + "#overview");

		CommonActions_Set.waitElement(DashBoardPageobject.stubsname, 30); 
		CommonActions_Set.waitElement(StubsObject.stubs, 30);
		//	StubsObject.stubsclick(responseJson);

		stopDriver();

	}
	
	public static void update(String sandboxUsername , String sandboxPassword, String stubsName, String apiURL,String responeFilePath,String textAreaXpath) throws InterruptedException, IOException {
		
		System.out.println("Start gecko driver");
		//startDriver();

		StubsObject = new Stubs(GlobalDriver.seleniumDriver);
		signInPageObject = new SignInPage(GlobalDriver.seleniumDriver);
		DashBoardPageobject = new DashBoardPage(GlobalDriver.seleniumDriver);

		StubsObject.setApiURL(apiURL);
		
		responseJson = FileUtils.readFileToString(new File(responeFilePath), StandardCharsets.UTF_8);

		signInPageObject.login(sandboxUsername, sandboxPassword);
		CommonActions_Set.waitElement(DashBoardPageobject.dashboardBtn, 30);

		Assert.assertTrue(DashBoardPageobject.dashboardBtn.isDisplayed());

		GlobalDriver.seleniumDriver.navigate().to("https://getsandbox.com/sandboxes/" + stubsName + "#overview");
		CommonActions_Set.waitElement(DashBoardPageobject.stubsname, 30);
		CommonActions_Set.waitElement(StubsObject.stubs, 30);
		
		StubsObject.stubsclick(responseJson, textAreaXpath);

	}
	
public static void updateMultipleURLs(String sandboxUsername , String sandboxPassword, String stubsName, String apiURL,String responeFilePath,String textAreaXpath) throws InterruptedException, IOException {
		
		System.out.println("Start gecko driver");
		//startDriver();

		StubsObject = new Stubs(GlobalDriver.seleniumDriver);
		signInPageObject = new SignInPage(GlobalDriver.seleniumDriver);
		DashBoardPageobject = new DashBoardPage(GlobalDriver.seleniumDriver);

		StubsObject.setApiURL(apiURL);
		
		responseJson = FileUtils.readFileToString(new File(responeFilePath), StandardCharsets.UTF_8);

		signInPageObject.login(sandboxUsername, sandboxPassword);
		CommonActions_Set.waitElement(DashBoardPageobject.dashboardBtn, 30);

		Assert.assertTrue(DashBoardPageobject.dashboardBtn.isDisplayed());

		GlobalDriver.seleniumDriver.navigate().to("https://getsandbox.com/sandboxes/" + stubsName + "#overview");
		CommonActions_Set.waitElement(DashBoardPageobject.stubsname, 30);
		CommonActions_Set.waitElement(StubsObject.stubs, 30);
		
		StubsObject.stubsclickMultipleURLs(responseJson, textAreaXpath);

	}





}
