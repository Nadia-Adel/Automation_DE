package ios_pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileUtilities.Mobile_CommonActions_Get;
import mobileUtilities.Mobile_CommonActions_Set;

public class NotificationLayerPage {

	public NotificationLayerPage(AppiumDriver<MobileElement>appium) {

		PageFactory.initElements(new AppiumFieldDecorator(appium), this);

	}
	


	@iOSXCUITFindBy(id="NotificationCell")
	public WebElement notificationCell;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"notification-action-button\"])[1]")
	public WebElement notificationActionBtn;

	public void openNotification() {
		
		//MEINVODAFONE, 2 minutes ago, Transfer Deep link
		//notificationCell = GlobalDriver.appium.findElement(By.xpath("//*[contains(@label,'Transfer Deep link')]"));
		
		Mobile_CommonActions_Set.elementSwipe(notificationCell);
	}
	
	public void validatePushedNotification() {
		
		assertTrue(Mobile_CommonActions_Get.getText(notificationCell).equals("Deep Link action"));
	}


}
