package newLoginScenarios.UCMScenarios_Stubs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC055_FailSubscriberDetailsRequest401_UCM  extends MobileTestBase{

	@Test(priority = 1)
	public void Step1_dslLogin() throws IOException, ParseException {
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin(GetUserFromJson.getUsername("UCMUser_Stubs"), GetUserFromJson.getpassword("UCMUser_Stubs"));	
	}
	@Test(priority = 2)
	public void Step2_FailSubscriberDetailsResponseWith401() throws IOException, ParseException, InterruptedException {
		resFilePath=SandboxConfigReader.getProberty("SubscriberDetails_Get_401_Path");
		apiURL=SandboxConfigReader.getProberty("SubscriberDetails_Get_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[57]/div[2]/form/div/div[2]/div[2]/textarea";
		
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);
	}

	@Test(priority = 3)
	public void validateHomeScreenAfterFailure() {
		
		homePageObject = new HomePage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(homePageObject.homeIcon);

		Mobile_CommonActions_Set.setExplicitWait(loginPageObject.usernameTxtField,30);	

	}
	@Test(priority = 4)
	public void setStatusCode200() throws InterruptedException, IOException {
		resFilePath=SandboxConfigReader.getProberty("SubscriberDetails_Get_200_Path");
		apiURL=SandboxConfigReader.getProberty("SubscriberDetails_Get_URL");
		stubsName = SandboxConfigReader.getProberty("automationStubs_UCM");
		textAreaXPath = "/html/body/div[2]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div[57]/div[2]/form/div/div[2]/div[2]/textarea";
		
		setStatusCode(resFilePath, apiURL, stubsName,textAreaXPath);

	}
}
