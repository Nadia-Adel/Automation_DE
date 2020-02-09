package ios_pages;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileUtilities.Mobile_CommonActions_Get;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;


public class HomePage {


	public HomePage(AppiumDriver<MobileElement>appium) {

		PageFactory.initElements(new AppiumFieldDecorator(appium), this);
	}

	@iOSXCUITFindBy(id="Weiter")
	public WebElement acceptNotification;

	@iOSXCUITFindBy(id="Deep Link action")
	public WebElement notificationBodyTxt;

	@iOSXCUITFindBy(id="bigTileBodyText")
	public WebElement staticTileSublineTxt;

	@iOSXCUITFindBy(id="bigTileIconView")
	public WebElement staticTileIcon_icon;

	@iOSXCUITFindBy(id="Start")
	public WebElement  homeIcon;

	@iOSXCUITFindBy(id = "mediumTileIconView")
	public WebElement squareTileIcon;
	
	//XCUIElementTypeStaticText[@name="mediumTileTitleText"])[1]
			//[@name ='collectionView']/[2]//*[@name='mediumTileTitleText']
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='mediumTileTitleText'])[1]")
	public WebElement squareTileHeadline;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"mediumTileTitleText\"])[2]")
	public WebElement squareTileSubline;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"mediumTileNumberText\"])[1]")
	public WebElement squareTileAmount;
	
	@iOSXCUITFindBy(id = "Nochmal versuchen")
	public WebElement reTryBtn_BlockingScreen;

	@iOSXCUITFindBy(id = "bigTileErrorText")
	public WebElement wideTileErrorText;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"smallTileTitleText\"])[1]")
	public WebElement firstSmallTileTitle_txt;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"smallTileSublineText\"])[1]")
	public WebElement firstSmallTileSubline_txt;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"smallTileIconView\"])[1]")
	public WebElement firstSmallTileIcon_icon;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"smallTileTitleText\"])[2]")
	public WebElement secondSmallTileTitle_txt;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"smallTileSublineText\"])[2]")
	public WebElement secondSmallTileSubline_txt;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"smallTileIconView\"])[2]")
	public WebElement secondSmallTileIcon_icon;
	
	@iOSXCUITFindBy(id="vodafonepassstile_usage_tv")
	public WebElement vodafonepassstile_usage_tv;
	
	@iOSXCUITFindBy(id="vodafonepassstile_title_tv")
	public WebElement vodafonepassstile_title_tv;
	
	@iOSXCUITFindBy(id="vodafonepassstile_more_tv")
	public WebElement vodafonepassstile_icon_iv;
	
	
	public void assertLoggedInUser(String loggedInUsername) {

		MenuItemsPage menuItemPageObject = new MenuItemsPage(GlobalDriver.appium);
		menuItemPageObject.clickMenuIcon();
		WebElement element = GlobalDriver.appium.findElement(By.id(loggedInUsername));
		assertTrue(element.isDisplayed());

	}

	public void switchFromMobileToDSL () {
		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		MenuItemsPage menuItemPageObject = new MenuItemsPage(GlobalDriver.appium);
		menuItemPageObject.clickMenuIcon();	
		Mobile_CommonActions_Set.Click(menuItemPageObject.switchToDSLBtn);
		Mobile_CommonActions_Set.Click(acceptNotification);
		Mobile_CommonActions_Set.setExplicitWait(lgn.usernameTxtField,10);

	}

	public void switchFromDSLToMobile () {
		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		MenuItemsPage menuItemPageObject = new MenuItemsPage(GlobalDriver.appium);
		menuItemPageObject.clickMenuIcon();	
		Mobile_CommonActions_Set.Click(menuItemPageObject.switchToMobileBtn);
		Mobile_CommonActions_Set.Click(acceptNotification);
		Mobile_CommonActions_Set.setExplicitWait(lgn.internetPasswordLogin,10);

	}

	public void mobileLogout(){
		LoginPage lgn = new LoginPage(GlobalDriver.appium);

		MenuItemsPage menuItemPageObject = new MenuItemsPage(GlobalDriver.appium);
		menuItemPageObject.clickMenuIcon();

		try {
			menuItemPageObject.clickSettingsMenuItem(); 
			menuItemPageObject.clickLogout();
			//set validation point
			Mobile_CommonActions_Set.setExplicitWait(lgn.internetPasswordLogin,10);
		}

		catch(Exception e) {
			// to handle any problem with the scrolling to settings element 
			// if there is a problem will logout from the switch user btn

			Mobile_CommonActions_Set.Click(menuItemPageObject.switchToDSLBtn);
			Mobile_CommonActions_Set.Click(acceptNotification);
			Mobile_CommonActions_Set.Click(lgn.mobileLoginTab);
			Mobile_CommonActions_Set.setExplicitWait(lgn.internetPasswordLogin,10);
		}

	}

	public void dslLogout(){

		MenuItemsPage menuItemPageObject = new MenuItemsPage(GlobalDriver.appium);

		menuItemPageObject.clickMenuIcon();
		menuItemPageObject.clickSettingsMenuItem(); 
		menuItemPageObject.clickLogout();

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		//set validation point

		Mobile_CommonActions_Set.setExplicitWait(lgn.passwordTxtField,10);

	}


	public void stubsLogout() {
		MenuItemsPage menuItemPageObject = new MenuItemsPage(GlobalDriver.appium);
		menuItemPageObject.clickMenuIcon();

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		Mobile_CommonActions_Set.Click(menuItemPageObject.switchToDSLBtn);
		Mobile_CommonActions_Set.Click(acceptNotification);
		Mobile_CommonActions_Set.Click(lgn.mobileLoginTab);
		Mobile_CommonActions_Set.setExplicitWait(lgn.internetPasswordLogin,10);		
	}

	public void manageNotificationFromBackground(String bundleID) {
		try {
			//	All_Setters.testPushNotificationsFromBackground(bundleID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Kill_App() {

		Mobile_CommonActions_Set.killApp();
	}

	public void handlePushNotificationFromForground(String userUDID , String Platform , String Deeplink,String notifcationMessage) {

		Mobile_CommonActions_Set.pushNotification(userUDID,Platform, Deeplink,notifcationMessage);

		//CommonActions_Set.setExplicitWait(notificationBodyTxt, 120);
		//assertTrue(CommonActions_Get.getText(notificationBodyTxt).contains(notifcationMessage + " Deep Link"));

		Mobile_CommonActions_Set.Click(acceptNotification);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void handlePushNotificationFromBackground(String userUDID , String Platform , String Deeplink, String notifcationMessage) {
		Mobile_CommonActions_Set.setAppIntoTheBackground();

		Mobile_CommonActions_Set.pushNotification(userUDID,Platform, Deeplink , notifcationMessage);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Mobile_CommonActions_Set.showNotifications();

		NotificationLayerPage notificationLayerPageObject = new NotificationLayerPage(GlobalDriver.appium);

		//notificationLayerPageObject.validatePushedNotification();

		notificationLayerPageObject.openNotification();
	}


	public void handlePushNotificationAfterKillingTheApp(String userUDID , String Platform , String Deeplink, String notifcationMessage) {

		Mobile_CommonActions_Set.killApp();

		Mobile_CommonActions_Set.pushNotification(userUDID,Platform, Deeplink,notifcationMessage);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Mobile_CommonActions_Set.showNotifications();

		NotificationLayerPage notificationLayerPageObject = new NotificationLayerPage(GlobalDriver.appium);

		//notificationLayerPageObject.validatePushedNotification();

		notificationLayerPageObject.openNotification();

	}

	public void validateStaticWideTile(String title, String subTitle) {

		WebElement element = GlobalDriver.appium.findElement(By.xpath("//*[@label='"+title+"']"));
		Mobile_CommonActions_Set.setExplicitWait(element, 120);
		assertEquals(Mobile_CommonActions_Get.getText(element), title);
		assertEquals(Mobile_CommonActions_Get.getText(staticTileSublineTxt), subTitle);
		assertTrue(Mobile_CommonActions_Set.checkIfElementISDisplayed(staticTileIcon_icon));
	}
}
