package testBase;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class GlobalDriver {

	public static AppiumDriver<MobileElement>appium = null;
	public static WebDriver seleniumDriver = null; 
}