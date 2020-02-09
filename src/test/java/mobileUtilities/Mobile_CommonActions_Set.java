package mobileUtilities;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import servicesAndAPIs.urbanAirShipAPIHandeller;
import testBase.GlobalDriver;

public class Mobile_CommonActions_Set {


	private static Dimension screenSize;


	public static boolean checkPresenceOfElement(WebElement element) {
		boolean check;

		try {
			//System.err.println("I'm on Try Block");
			check = element.isDisplayed();
			return check;


		} catch (NoSuchElementException e) {
			
			//System.err.println("I'm on Catch Block");
			check = false;
			return check;
		}
	}
	public static void setExplicitWait(WebElement element, int timeoutInSeconds) {

		(new WebDriverWait(GlobalDriver.appium, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));

	}

	public static boolean checkIfElementISDisplayed(WebElement element) {

		return element.isDisplayed();

	}

	public static void waitPrsenceOfElement(By element, int timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(GlobalDriver.appium, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}
	public static void Click(WebElement element)
	{
		element.click();

	}
	public static void enterText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);		
	}

	public static void setAppIntoTheBackground() {

		GlobalDriver.appium.runAppInBackground(Duration.ofSeconds(-1));
	}

	public static void pushNotification(String userUMDID, String Platform, String deepLink,String notificationMessage) {
		urbanAirShipAPIHandeller.sendNotification(userUMDID,Platform,deepLink,notificationMessage);
	}

	public static void showNotifications() {
		System.out.println("Now, swip to show the notification .....");
		manageNotifications(true);
	}

	public static void hideNotifications() {
		manageNotifications(false);
	}

	private static void manageNotifications(Boolean show) {

		screenSize = GlobalDriver.appium.manage().window().getSize();
		int yMargin = 5;
		int xMid = screenSize.width / 2;
		PointOption top = PointOption.point(xMid, yMargin);
		PointOption bottom = PointOption.point(xMid, screenSize.height - yMargin);

		TouchAction action = new TouchAction(GlobalDriver.appium);
		if (show) {
			action.press(top);
		} else {
			action.press(bottom);
		}
		action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
		if (show) {
			action.moveTo(bottom);
		} else {
			action.moveTo(top);
		}
		action.perform();
	}


	public static void elementSwipe (WebElement element) {

		Mobile_CommonActions_Set.setExplicitWait(element, 120);
		JavascriptExecutor js =(JavascriptExecutor) GlobalDriver.appium;
		Map<String, Object>params = new HashMap<>();
		params.put("direction", "right");
		params.put("element", ((RemoteWebElement)element).getId());
		js.executeScript("mobile: swipe", params);

	}


	public static void screenSwipe(){
		TouchAction touchAction = new TouchAction(GlobalDriver.appium);
		int pressX =  GlobalDriver.appium.manage().window().getSize().width; /// 2;

		System.out.println("pressX .... "+pressX);
		int bottomY = GlobalDriver.appium.manage().window().getSize().height;

		System.out.println("bottomY .... "+bottomY);

		int topY = GlobalDriver.appium.manage().window().getSize().height;
		System.out.println("topY .... "+topY);

		//  touchAction.longPress(PointOption.point(pressX, bottomY * 3/4)).waitAction()
		//  .moveTo(PointOption.point(pressX, (int) (topY * 1/4))).release().perform();

		//pressX * 4 / 5, bottomY
		// pressX * 45 / 100, topY
		touchAction.longPress(PointOption.point(pressX / 100, bottomY)).waitAction()
		.moveTo(PointOption.point(pressX * 60 / 100, topY)).release().perform();

		/*
             switch (platform) {
             case "native-android": {
                 touchAction.press(PointOption.point(pressX, bottomY * 3/4)).waitAction()
                         .moveTo(PointOption.point(pressX, topY * 1/4)).release().perform();
             }
             break;
             case "react-android": {
                 touchAction.press(PointOption.point(pressX, bottomY * 3/4)).waitAction()
                         .moveTo(PointOption.point(pressX, topY * 1/4)).release().perform();
             }
             break;
             case "native-ios": {
                 touchAction.longPress(PointOption.point(pressX, bottomY * 3/4)).waitAction()
                         .moveTo(PointOption.point(pressX, (int) (topY * 1/4))).release().perform();
             }
             break;
             case "react-ios": {
                 touchAction.longPress(PointOption.point(pressX, bottomY * 3/4)).waitAction()
                         .moveTo(PointOption.point(pressX, topY * 1/4)).release().perform();
             }
             break;
         }    
		 */

	}


	public static void killApp() {

		GlobalDriver.appium.terminateApp("com.tsse.meinvodafone");


	}

	public static void scrollDownTo(WebElement element, int timeout, String platformName) {

		//System.out.println("platform "+ platformName); 

		long TimeMillis = System.currentTimeMillis();
		long startTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
		long currentTime = startTime;
		boolean isDisplayed = false;
		int pressX = 0;
		int topY = 0;
		int bottomY = 0;

		while (currentTime < startTime + timeout) {
			try {
				pressX = GlobalDriver.appium.manage().window().getSize().width/2;
				bottomY = GlobalDriver.appium.manage().window().getSize().height;
				topY = GlobalDriver.appium.manage().window().getSize().height;
				isDisplayed = element.isDisplayed();
				//System.out.println("pressX "+ pressX); 
				//System.out.println("topY "+ topY); 
				//System.out.println("bottomY "+ bottomY);
			//	System.out.println("isDisplayed "+ isDisplayed); 
				if (!isDisplayed) {
					throw new NoSuchElementException("Element Not Displayed");
				}
				currentTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
				if (isDisplayed) {
					break;
				}
			} catch (NoSuchElementException e) {
				TouchAction touchAction = new TouchAction(GlobalDriver.appium);

				switch (platformName) {
				case "native-android": {
					touchAction.press(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
					.moveTo(PointOption.point(pressX, topY * 40 / 100)).release().perform();
				}
				break;
				case "react-android": {
					touchAction.press(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
					.moveTo(PointOption.point(pressX, topY * 36 / 100)).release().perform();
				}
				break;
				case "native-ios": {
					touchAction.longPress(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
					.moveTo(PointOption.point(pressX, (int) (topY * 45.7 / 100))).release().perform();

					//System.out.println("INNNNNNNNNNN "); 
				}
				break;
				case "react-ios": {
					touchAction.longPress(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
					.moveTo(PointOption.point(pressX, topY * 45 / 100)).release().perform();
				}
				break;
				}
				currentTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
				if (currentTime > startTime + timeout) {
					throw e;
				}
			}
		}
	}

}
