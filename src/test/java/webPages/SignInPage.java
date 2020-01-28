package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.GlobalDriver;
import webUtilities.CommonActions_Set;
public class SignInPage {

	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(GlobalDriver.seleniumDriver, this);
	}
	
	
	
	int x = 0;
	@FindBy(id = "userLogin")
	public WebElement userLoginTxt;

	@FindBy(id = "userPassword")
	public WebElement userPasswordTxt;

	@FindBy(xpath = "//*[@name='loginButton']")
	public WebElement signInBtn;

	public void login(String userName, String password) {
		
		CommonActions_Set.setTextInFields(userLoginTxt, userName);
		CommonActions_Set.setTextInFields(userPasswordTxt, password);
		CommonActions_Set.clickButton(signInBtn);

	}

}
