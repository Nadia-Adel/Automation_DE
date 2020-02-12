package testBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataFilesHandeller.CapabilitiesFileReader;
import dataFilesHandeller.ConfigurationFileHandeller;
import dataFilesHandeller.GetUserFromJson;
import dataFilesHandeller.SandboxConfigReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import ios_pages.HomePage;
import ios_pages.LoginPage;
import ios_pages.MenuItemsPage;
import ios_pages.DeeplinkPagesValidator_DSL;
import ios_pages.DeeplinkPagesValidator_Mobile;
import mobileUtilities.Mobile_CommonActions_Set;
import sandboxTestCases.UpdateSandBox;
import servicesAndAPIs.UnbilledUsage_Get;

public class MobileTestBase {

	public HomePage homePageObject =null; 
	public WebElement globalElement =null;
	public LoginPage loginPageObject =null;
	public DeeplinkPagesValidator_Mobile pagesValidatorObject_mobile = null;
	public DeeplinkPagesValidator_DSL pagesValidatorObject_dsl = null;
	public MenuItemsPage menuObject = null;
	public UnbilledUsage_Get unbilledUsageGetObject=null;
	public String userUDID;
	public String platformName;
	public String deepLink;
	public String notifcationMessage;
	public String resFilePath;
	public String apiURL;
	public String stubsName;
	public String textAreaXPath;
	public static String SavedAmount=null;
	public static String UnitOfMeasure=null;
	public static String ServiceIdentfier=null;
	
    //Test Reports
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    String TEST_REPORTS = System.getProperty("user.dir")+"/test-reports/";
    		
	@BeforeSuite
    public void setUp(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        htmlReporter = new ExtentHtmlReporter(TEST_REPORTS+"ExtentReport_"+timeStamp+"_.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

	@BeforeClass
	public void baseTest () throws MalformedURLException {

		CapabilitiesFileReader cap = new CapabilitiesFileReader();

		if(ConfigurationFileHandeller.getPlatformName().equalsIgnoreCase("ios")) {

			System.out.println("lauching IOS ....");
			GlobalDriver.appium = new IOSDriver<MobileElement>(new URL(ConfigurationFileHandeller.getAppiumServerURL()),cap.getCapabilities());
		}
		else if(ConfigurationFileHandeller.getPlatformName().equalsIgnoreCase("android")) {

			System.out.println("lauching Android ....");
			GlobalDriver.appium = new AndroidDriver<MobileElement>(new URL(ConfigurationFileHandeller.getAppiumServerURL()),cap.getCapabilities());			
		}

		GlobalDriver.appium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeTest
    public void initializeTestRun(final ITestContext testContext) {
        test = extent.createTest(testContext.getName());
        test.log(Status.INFO, "Test suite currently being executed : " + testContext.getName());
    }


	//@Test
	// demo
	public void Step1_dslLogin() throws IOException, ParseException {

		System.out.println("Step 1, user is logging in ......");

		LoginPage lgn = new LoginPage(GlobalDriver.appium);
		lgn.dslLogin(GetUserFromJson.getUsername("DSLUser"),GetUserFromJson.getpassword("DSLUser"));
	}

	@AfterClass
	public void tearDown() {

		GlobalDriver.appium.closeApp();
	}

	public void setStatusCode(String resFilePath, String apiURL,String stubsName,String textAreaXpath) throws InterruptedException, IOException {

		webTestBase.startDriver();

		String username = SandboxConfigReader.getProberty("username");
		String password = SandboxConfigReader.getProberty("password");

		UpdateSandBox.update(username, password, stubsName, apiURL, resFilePath,textAreaXpath);

		webTestBase.stopDriver();

	}
	
	public void setStatusCodeMulltipleURLs(String resFilePath, String apiURL,String stubsName,String textAreaXpath) throws InterruptedException, IOException {

		webTestBase.startDriver();

		String username = SandboxConfigReader.getProberty("username");
		String password = SandboxConfigReader.getProberty("password");

		UpdateSandBox.updateMultipleURLs(username, password, stubsName, apiURL, resFilePath,textAreaXpath);

		webTestBase.stopDriver();

	}


	public void TerminateTheAppAfterSuccessCode() throws InterruptedException {

		Thread.sleep(3000);
		Mobile_CommonActions_Set.scrollDownTo(loginPageObject.acceptGDBR, 10000, "native-ios");
		Mobile_CommonActions_Set.setExplicitWait(loginPageObject.acceptGDBR, 30);
		Mobile_CommonActions_Set.killApp();
	}
	
	  @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
	                    ExtentColor.RED));
	            test.fail(result.getThrowable());
	            //String path = ScreenshotUtil.captureScreenShot(result.getMethod().getTestClass().getName());
	            //test.fail("Snapshot below: " + test.addScreenCaptureFromPath(path));
	            // This will attach the screenshot only for Failed test cases
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " Test Case PASSED", ExtentColor.GREEN));
	        } else {
	            test.log(Status.SKIP,
	                    MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }

	    @AfterSuite
	    public void tearDownSuite(){
	        extent.flush();
	    }

////Users/medhatali/eclipse-workspace/MobileFramework/cms/cms
	//Users/medhatali/Documents/MobileFramework/cms/cms
}
