package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;




public class webTestBase {
	
	public String browserNamee;
	public static String responseJson;
	
	//@BeforeSuite
	public static void startDriver() {
		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
//		GlobalDriver.seleniumDriver = new ChromeDriver();
//		GlobalDriver.seleniumDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//		GlobalDriver.seleniumDriver.manage().window().maximize();
//		GlobalDriver.seleniumDriver.get("https://getsandbox.com/signin#overview");
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
		GlobalDriver.seleniumDriver = new FirefoxDriver();
		GlobalDriver.seleniumDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		GlobalDriver.seleniumDriver.manage().window().maximize();
		GlobalDriver.seleniumDriver.get("https://getsandbox.com/signin#overview");

		
	}
	
	public static void setSizeDriver() {
	
		Dimension d = new Dimension(300,1080);
     	//Resize current window to the set dimension
		GlobalDriver.seleniumDriver.manage().window().setSize(d);
	}

	public static void resizeDriver() {
		
		//Resize current window to the set dimension
		GlobalDriver.seleniumDriver.manage().window().maximize();
	}
	
	/*public void readData() throws IOException {
		//Scanner br = new Scanner(System.in);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter user name and password and stubsName");
		userName = br.readLine();
		password = br.readLine();
		stubsName = br.readLine();
		path = br.readLine();
		apiii = br.readLine();
		br.close();
		StubsObject = new Stubs(GlobalDriver.seleniumDriver);
		StubsObject.setApiURL(apiii);
		responseJson = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
	}
	*/


	//@AfterSuite
	public static void stopDriver() {
		//GlobalDriver.seleniumDriver.manage().deleteAllCookies();
		GlobalDriver.seleniumDriver.close();
	}

}
