package SwitchBetweenUsers;

import org.testng.annotations.Test;

import ios_pages.LoginPage;
import testBase.GlobalDriver;
import testBase.MobileTestBase;

public class TC03 extends MobileTestBase {
	@Test
	public void LgnDSL() {
		
		loginPageObject = new LoginPage(GlobalDriver.appium);
		loginPageObject.dslLogin("", "");
	}
}
