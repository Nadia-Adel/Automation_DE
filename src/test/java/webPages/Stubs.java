package webPages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.GlobalDriver;
import webUtilities.CommonActions_Set;

public class Stubs {


	public Stubs(WebDriver driver) {

		PageFactory.initElements(GlobalDriver.seleniumDriver, this);

	}


	private static String apiURL;
	public WebElement allElementsInList;

	public void setApiURL(String api) {
		apiURL = api;
	}

	public void getApiURL() {
		String xPathforelement = "//div[@class=\"col-md-12\"][1]//span[contains(text(),'" + apiURL + "')]";
		// System.out.println(By.xpath(xPathforelement));
		allElementsInList = GlobalDriver.seleniumDriver.findElement(By.xpath(xPathforelement));
		allElementsInList.click();

	}
	
	public void getMultipleApiURL() {
		
		System.out.println("apiURL "+apiURL);
		String xPathforelement = "//div[@class=\"col-md-12\"][1]//span[contains(text(),'" + apiURL + "')]";
		List<WebElement> allElementsInLists = GlobalDriver.seleniumDriver.findElements(By.xpath(xPathforelement));
		System.out.println("allElementsInLists.get(1) "+allElementsInLists.get(1).getText() +allElementsInLists.size());
		allElementsInList = allElementsInLists.get(allElementsInLists.size() - 1);
		allElementsInList.click();

	}

	@FindBy(xpath = "//div[@class=\"col-md-12\"][1]")
	public WebElement stubs;

	@FindBy(xpath = "//div[@class='form-group']//label")
	WebElement pathTxt;

	@FindBy(xpath = "//div[@name='implementation']")
	WebElement response_Click;

	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement updateBtn;

	
	public WebElement response;

	public void stubsclick(String newResponse , String textAreaXpath) throws InterruptedException {

		getApiURL();

		StringSelection stringSelection = new StringSelection(newResponse);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		clipboard.setContents(stringSelection,null);

		response = GlobalDriver.seleniumDriver.findElement(By.xpath(textAreaXpath));

		response.sendKeys(Keys.chord(Keys.COMMAND,"a"));

		Thread.sleep(3000);		

		response.sendKeys(Keys.chord(Keys.COMMAND,"v"));
		
		System.out.println("insertion done");
		
		CommonActions_Set.click(updateBtn);

		Thread.sleep(15000);
	//	assertTrue(CommonActions_Set.waitElemenTobeInVisible(GlobalDriver.seleniumDriver.findElement(By.xpath("//div[@aria-expanded='true']")), 30));
	
		
		// updateBtn.isDisplayed();
	}
	
	public void stubsclickMultipleURLs(String newResponse , String textAreaXpath) throws InterruptedException {

		getMultipleApiURL();

		StringSelection stringSelection = new StringSelection(newResponse);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		clipboard.setContents(stringSelection,null);

		response = GlobalDriver.seleniumDriver.findElement(By.xpath(textAreaXpath));

		response.sendKeys(Keys.chord(Keys.COMMAND,"a"));

		Thread.sleep(3000);		

		response.sendKeys(Keys.chord(Keys.COMMAND,"v"));
		
		System.out.println("insertion done");
		
		CommonActions_Set.click(updateBtn);

		Thread.sleep(15000);
	//	assertTrue(CommonActions_Set.waitElemenTobeInVisible(GlobalDriver.seleniumDriver.findElement(By.xpath("//div[@aria-expanded='true']")), 30));
	
		
		// updateBtn.isDisplayed();
	}

}
