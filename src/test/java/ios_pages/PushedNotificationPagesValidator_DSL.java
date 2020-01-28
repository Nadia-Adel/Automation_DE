package ios_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileUtilities.Helper_Class;
import mobileUtilities.Mobile_CommonActions_Get;
import mobileUtilities.Mobile_CommonActions_Set;
import testBase.GlobalDriver;

public class PushedNotificationPagesValidator_DSL {


	public PushedNotificationPagesValidator_DSL(AppiumDriver<MobileElement>appium) {

		PageFactory.initElements(new AppiumFieldDecorator(appium),this);

	}

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Forum\"]")
	public 	WebElement forumsPageTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Aufladen\"]")
	public 	WebElement rechargePageTitle;

	@iOSXCUITFindBy(id="Dein aktuelles Guthaben:")
	public 	WebElement rechargePageSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Transfer\"]")
	public 	WebElement transferPageTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"GigaGarantie\"]")
	public 	WebElement netzfeedbackPageTitle;

	@iOSXCUITFindBy(id="Mit 4G|LTE zufrieden. Oder Du surfst einen Tag kostenlos.")
	public 	WebElement netzfeedbackPageSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"FAQ\"]")
	public 	WebElement FAQPageTitle;

	@iOSXCUITFindBy(id="Finde Dein Thema")
	public 	WebElement FAQPageSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Mein Tarif\"]")
	public 	WebElement tariffPageTitle;

	@iOSXCUITFindBy(id="Red Internet und Phone 50 DSL")
	public 	WebElement tariffPageSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Angebote\"]")
	public 	WebElement angebotePageTitle;

	@iOSXCUITFindBy(id="Hol Dir das Produkt, das Dir fehlt")
	public 	WebElement angebotePageContent_EMPFEHLUNGEN;

	@iOSXCUITFindBy(id="NoOffersGigaLive")
	public 	WebElement angebotePageContent_NoOffersGigaLive;

	@iOSXCUITFindBy(id="OK")
	public 	WebElement shofinderWarningOkBtn;

	@iOSXCUITFindBy(id="Abbrechen")
	public 	WebElement shopfinderAbbrechenBtn;

	@iOSXCUITFindBy(id="Vodafone-Shops in meiner Nähe")
	public 	WebElement shopFinderPageSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Shopfinder\"]")
	public 	WebElement shopFinderPageTitle;

	@iOSXCUITFindBy(id="vfTocTools")
	public 	WebElement netMapValidationPoint;

	@iOSXCUITFindBy(id="collectionView")
	public 	WebElement homepageCollectionView;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Posteingang\"]")
	public 	WebElement inboxPageTitle;

	@iOSXCUITFindBy(id="Dein Posteingang ist im Moment leer.")
	public 	WebElement inboxPageSubtitle;

	@iOSXCUITFindBy(id="Logout und Neuanmeldung")
	public WebElement mobileLogoutOption;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\'Einstellungen & Infos\']")
	public WebElement settingsAndInfoPageTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\'Netz okay?\']")
	public WebElement netzInfoPageTitle;

	@iOSXCUITFindBy(id="Dein Netz an Deinem Standort")
	public WebElement netzInfoPageSubtitle;

	@iOSXCUITFindBy(id="Dein Mobilfunknetz im Bereich der Postleitzahl")
	public WebElement netzInfoPage_MobileNetzSubtitle;
	//XCUIElementTypeOther[@name="Bearbeitungsstand"]
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Bearbeitungsstand\"]")
	public WebElement bestellstatusPageTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Bearbeitungsstand\"]")
	public WebElement bestellstatusPageSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\'Quickcheck\']")
	public WebElement quickCheckPageTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\'SpeedTest\']")
	public WebElement speedTestPageTitle;
	
	@iOSXCUITFindBy(id="Aktuelle Daten-Geschwindigkeit in Deiner Region")
	public WebElement speedTestPageSubTitle;
	
	@iOSXCUITFindBy(id="Letzte Rechnung")
	public WebElement billOverviewPageSubtitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"Rechnungen\"]")
	public WebElement billOverviewPageTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"Meine Daten\"]")
	public WebElement meineDatenPageTitle;
	
	@iOSXCUITFindBy(id="Hier findest Du alles rund um Deinen Vertrag: Deine Rechnungen und Verträge, Adresse und Bankverbindung, Kennwörter und mehr.")
	public WebElement meineDatenPageSubtitle;
	

	
	public void validateMeineDatenDeeplinkAction() {
		
		Helper_Class.validateDeeplinkAction_dsl(meineDatenPageTitle, meineDatenPageSubtitle);
	}
	
	public void validateBillsOverviewPageTitle() {
		Mobile_CommonActions_Set.setExplicitWait(billOverviewPageTitle, 120);
		Mobile_CommonActions_Set.setExplicitWait(billOverviewPageSubtitle, 120);
		new MenuItemsPage(GlobalDriver.appium).clickMenuIcon(); 
		Mobile_CommonActions_Set.setExplicitWait( new MenuItemsPage(GlobalDriver.appium).logoutOption, 30);
		
	}
	
	public void validateSpeedTestDeeplinkAction() {
		
		Helper_Class.validateDeeplinkAction_dsl(speedTestPageTitle, speedTestPageSubTitle);
	}
	
	public void validateQuickCheckDeeplinkAction() {
		Helper_Class.validateDeeplinkAction_dsl(quickCheckPageTitle, quickCheckPageTitle);

	}

	public void validateBestellstatusDeeplinkAction() {

		Helper_Class.validateDeeplinkAction_dsl(bestellstatusPageTitle, bestellstatusPageSubTitle);

	}

	public void validateNetzInfoDeeplinkAction(){

		Helper_Class.validateDeeplinkAction_dsl(netzInfoPageTitle, netzInfoPageSubtitle);

	}

	public void validateNetzInfoPage_MobileNetzTabDeeplincAction() {

		Helper_Class.validateDeeplinkAction_dsl(netzInfoPageTitle, netzInfoPage_MobileNetzSubtitle);

	}

	public void validateInfoDeeplinkAction() {

		Helper_Class.validateDeeplinkAction_dsl(settingsAndInfoPageTitle, mobileLogoutOption);
	}

	public void validateInboxPage() {
		Helper_Class.validateDeeplinkAction_dsl(inboxPageTitle, inboxPageSubtitle);
	}

	public void validateHomePage() {

		Mobile_CommonActions_Set.setExplicitWait(homepageCollectionView, 120);
		new MenuItemsPage(GlobalDriver.appium).clickMenuIcon(); 
		Mobile_CommonActions_Set.setExplicitWait( new MenuItemsPage(GlobalDriver.appium).logoutOption, 30);


	}

	public void validatenetzabdeckung() {

		Mobile_CommonActions_Set.setExplicitWait(netMapValidationPoint, 120);

		System.out.println(GlobalDriver.appium.getCurrentUrl());
	}

	public void validateShopFinderPage() {
		//CommonActions_Set.setExplicitWait(shofinderWarningOkBtn, 30);
		Mobile_CommonActions_Set.Click(shofinderWarningOkBtn);

		Mobile_CommonActions_Set.setExplicitWait(shopfinderAbbrechenBtn, 20);
		Mobile_CommonActions_Set.Click(shopfinderAbbrechenBtn);

		Helper_Class.validateDeeplinkAction_dsl(shopFinderPageTitle, shopFinderPageSubTitle);

	}

	public void validateAngebotePage_Empfehlungen() {

		Mobile_CommonActions_Set.setExplicitWait(angebotePageTitle, 300);

		Mobile_CommonActions_Set.setExplicitWait(angebotePageContent_EMPFEHLUNGEN, 300);

		System.out.println("tariff page Subtitle is :  " + Mobile_CommonActions_Get.getText(angebotePageTitle));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new MenuItemsPage(GlobalDriver.appium).clickMenuIcon(); 
		Mobile_CommonActions_Set.setExplicitWait( new MenuItemsPage(GlobalDriver.appium).switchToDSLBtn, 30);

	}
	
	public void validateAngebotePage_TREUE_VORTEILE() {

		Mobile_CommonActions_Set.setExplicitWait(angebotePageTitle, 300);

		Mobile_CommonActions_Set.setExplicitWait(angebotePageContent_NoOffersGigaLive, 300);

		System.out.println("tariff page Subtitle is :  " + Mobile_CommonActions_Get.getText(angebotePageTitle));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new MenuItemsPage(GlobalDriver.appium).clickMenuIcon(); 
		Mobile_CommonActions_Set.setExplicitWait( new MenuItemsPage(GlobalDriver.appium).switchToDSLBtn, 30);
	}

	public void validateTariffPage() {
		Helper_Class.validateDeeplinkAction_dsl(tariffPageTitle, tariffPageSubTitle);
	}

	
	public void validateNetzfeedbackPage() {

		Helper_Class.validateDeeplinkAction_dsl(netzfeedbackPageTitle, netzfeedbackPageSubTitle);
	} 

	public void validateRechargePage() {

		Helper_Class.validateDeeplinkAction_dsl(rechargePageTitle, rechargePageSubTitle);
	}

	public void validateForumsPage() {

		Helper_Class.validateDeeplinkAction_dsl(forumsPageTitle, forumsPageTitle);
	}

	public void validateTransferPage() {

		Helper_Class.validateDeeplinkAction_dsl(transferPageTitle, transferPageTitle);

	}

	public void validateFAQPage() {

		Helper_Class.validateDeeplinkAction_dsl(FAQPageTitle, FAQPageSubTitle);

	}
	

}
