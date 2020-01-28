package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.GlobalDriver;
import webUtilities.CommonActions_Set;
public class DashBoardPage {
	
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(GlobalDriver.seleniumDriver, this);
	
	}
	
	//String api ="/api/enterprise-resources/core/bss/cus-nil/mobile/customer/customer-parties/{msisdn}/marketing-indicators";

	@FindBy(xpath="//div[@class=\"container\"]/nav/ul/li/a[@class=\"btn btn-info-alt\"]")
	public WebElement dashboardBtn;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[1]/div[3]/h2[1]/a")
	public WebElement stubsname;
	
	
	
	public void click() {
		
		CommonActions_Set.click(dashboardBtn);
	}
	//WebElement allElementsInList = driver.findElement(By.xpath("//div[@class=\"col-md-12\"][1]//span[contains(text(),'"+ api +"')]"));

}
