package ios_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileUtilities.Mobile_CommonActions_Set;

public class MenuItemsPage {

	@iOSXCUITFindBy(id ="back button")
	public WebElement backBtn ;

	@iOSXCUITFindBy(id ="vf_brand_logo_dark")
	public WebElement homeIcon ;

	@iOSXCUITFindBy(id="Mehr")
	public WebElement menuBtn;	

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[contains(@name,\"Einstellungen\")]")
	public WebElement settingAndInfoMenuItem;

	@iOSXCUITFindBy(id="Logout und Neuanmeldung")
	public WebElement logoutOption;
	
	@iOSXCUITFindBy(id="2233Logout und Neuanmeldung")
	public WebElement logoutOption_Stubs_DSL;
	
	@iOSXCUITFindBy(id="Neuanmeldung")
	public WebElement mobileLogoutBtn;
	
	@iOSXCUITFindBy(id="88test_Neuanmeldung")
	public WebElement mobileLogoutBtn_Stubs_DSL;
	@iOSXCUITFindBy(id = "Zu MeinDSL wechseln")
	public WebElement switchToDSLBtn;

	@iOSXCUITFindBy(id = "Zu MeinMobilfunk wechseln")
	public WebElement switchToMobileBtn;

	public MenuItemsPage(AppiumDriver<MobileElement>appium) {

		PageFactory.initElements(new AppiumFieldDecorator(appium), this);

	}

	public void clickMenuIcon() {

		Mobile_CommonActions_Set.setExplicitWait(menuBtn,60);
		Mobile_CommonActions_Set.Click(menuBtn);

	}

	public void clickSettingsMenuItem() {


		Mobile_CommonActions_Set.scrollDownTo(settingAndInfoMenuItem, 10000, "native-ios");

		Mobile_CommonActions_Set.Click(settingAndInfoMenuItem);
	}

	
	
	public void clickLogout_Stubs() {
		Mobile_CommonActions_Set.Click(logoutOption_Stubs_DSL);
		Mobile_CommonActions_Set.Click(mobileLogoutBtn_Stubs_DSL);
	}
	
	public void clickLogout() {
		
		//Mobile_CommonActions_Set.setExplicitWait(logoutOption,30);
		
		Mobile_CommonActions_Set.Click(logoutOption);
		Mobile_CommonActions_Set.Click(mobileLogoutBtn);
		
	}

	public void clickBackBtn() {

		Mobile_CommonActions_Set.setExplicitWait(backBtn, 20);
		Mobile_CommonActions_Set.Click(backBtn);

	}
	
	public void clickHomeIcon() {

		Mobile_CommonActions_Set.Click(homeIcon);
	}
}
