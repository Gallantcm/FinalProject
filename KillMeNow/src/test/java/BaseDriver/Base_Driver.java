
package BaseDriver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Tests.Arrival_Pg;
import Tests.Contact_Us_Pg;
import Tests.Search_Results_Pg;
import Tests.Store_Locator_Pg;

public class Base_Driver {

	public static WebDriver driver;
	public Arrival_Pg arrPg;
	public Store_Locator_Pg strLPg;
	public Search_Results_Pg srchRPg;
	public Contact_Us_Pg conUsPg;

	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeSuite
	public void SetExtentReport() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/test-output/ExtentReport/myReport" + System.currentTimeMillis() + ".html");

		htmlReporter.config().setDocumentTitle("First_Cry_Test");
		htmlReporter.config().setReportName("Final_Project");
	
		reports = new ExtentReports();

		reports.attachReporter(htmlReporter);
		if (reports == null) {
			System.out.println("reports are null");
		}
	}
	
	@BeforeMethod
	public void setup(Method method) {

		driver = new ChromeDriver();
		driver.get("https://www.firstcry.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		arrPg = new Arrival_Pg(driver);
		strLPg = new Store_Locator_Pg(driver);
		srchRPg= new Search_Results_Pg(driver);
		conUsPg = new Contact_Us_Pg(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Your test passed: " + result.getName());
		} 
		
		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Your test failed: " + result.getName());
			String screenLocation = GetScreenWindow.getScreen(driver, result.getName());
			test.addScreenCaptureFromPath(screenLocation, "Screenshot");
		} 
		
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "You've skipped this test : " + result.getName());
		}
		
		driver.quit(); // Quit driver after each test method

	}

	@AfterSuite
	public void afterSuite() {

		if (reports != null) {
			reports.flush();
		}
	}
}
