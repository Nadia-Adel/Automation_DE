package webUtilities;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.GlobalDriver;

public class CommonActions_Set {

	public static void clickButton(WebElement button) {
		button.click();

	}
	//
	public static void setTextInFields(WebElement textElement, String textValue) {
		System.out.println("textValue  : "+textValue);
		System.out.println("textElement  : "+textElement.getText());
		textElement.sendKeys(textValue);
		System.out.println("textElement  : "+textElement.getText());

	}
	public static void selectTextViaKeyboard() {
	    Actions builder = new Actions(GlobalDriver.seleniumDriver);
	    Action select= builder.keyDown(Keys.COMMAND).sendKeys("v").build();
	    select.perform();
	}
	
	public static void setClipboardContents(String text , WebElement response) {
		
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//clipboard.setContents(stringSelection, null);
		clipboard.setContents(stringSelection,null);
		/////////////////////////////////////////////
	//	Dimension d = new Dimension(300,1080);
     	//Resize current window to the set dimension
	//	GlobalDriver.seleniumDriver.manage().window().setSize(d);	
	//	System.out.println("GlobalDriver.seleniumDriver.manage().window().setSize(d);");
		
		//GlobalDriver.seleniumDriver.manage().window().maximize();
		//System.out.println("GlobalDriver.seleniumDriver.manage().window().maximize();");
		
		//GlobalDriver.seleniumDriver.navigate().refresh();
		System.out.println("GlobalDriver.seleniumDriver.navigate().refresh();");
		
	//	response2.sendKeys("test");
	//	response2.sendKeys("Nooooooo");
		
		response.sendKeys(Keys.chord(Keys.COMMAND + "v"));
	 //  response2.sendKeys(Keys.chord(Keys.COMMAND + "v"));
		
	//	selectTextViaKeyboard();
		
		//////
		//response2.sendKeys(Keys.chord(Keys.COMMAND + "V"));
	
	}

	public static void waitElement(WebElement Element,int timeoutInSeconds ) {
		(new WebDriverWait(GlobalDriver.seleniumDriver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(Element));
	}

	public static boolean waitElemenTobeInVisible(WebElement Element,int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(GlobalDriver.seleniumDriver, timeoutInSeconds);
		boolean flage =wait.until(ExpectedConditions.invisibilityOf(Element));
		return	flage;
	}
	public static  boolean isElementPresent( String locatorKey) {
		try {
			GlobalDriver.seleniumDriver.findElement(By.xpath(locatorKey));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static void clearTxt(WebElement Element) {

		Element.sendKeys(Keys.chord(Keys.COMMAND,"a"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void click(WebElement Element) {
		Element.click();

	}
}
