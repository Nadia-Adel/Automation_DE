package mobileUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ios_pages.MenuItemsPage;
import testBase.GlobalDriver;

public class Helper_Class {

	
	public static void validateDeeplinkAction_mobile(WebElement pageTitle, WebElement pageSubtitle) {
		Mobile_CommonActions_Set.setExplicitWait(pageTitle, 30);

		System.out.println("Info page Title is :  " + Mobile_CommonActions_Get.getText(pageTitle));

		Mobile_CommonActions_Set.setExplicitWait(pageSubtitle, 30);

		new MenuItemsPage(GlobalDriver.appium).clickBackBtn(); 
		Mobile_CommonActions_Set.setExplicitWait( new MenuItemsPage(GlobalDriver.appium).switchToDSLBtn, 30);
		
		
	}
	
	public static void validateDeeplinkAction_dsl(WebElement pageTitle, WebElement pageSubtitle) {
		Mobile_CommonActions_Set.setExplicitWait(pageTitle, 30);

		System.out.println("Info page Title is :  " + Mobile_CommonActions_Get.getText(pageTitle));

		Mobile_CommonActions_Set.setExplicitWait(pageSubtitle, 30);

		new MenuItemsPage(GlobalDriver.appium).clickBackBtn(); 
		Mobile_CommonActions_Set.setExplicitWait( new MenuItemsPage(GlobalDriver.appium).switchToMobileBtn, 30);
		
		
	}
	
	
	public static By toByVal(WebElement we) {
		
		System.err.println("web element is  : " + we);
		// By format = "[foundFrom] -> locator: term"
		// see RemoteWebElement toString() implementation
		String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
		String locator = data[0];
		String term = data[1];

		switch (locator) {
		case "xpath":
			return By.xpath(term);
		case "css selector":
			return By.cssSelector(term);
		case "id":
			return By.id(term);
		case "tag name":
			return By.tagName(term);
		case "name":
			return By.name(term);
		case "link text":
			return By.linkText(term);
		case "class name":
			return By.className(term);
		}
		return (By) we;
	}


}
