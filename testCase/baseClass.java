package Everything2.Feb_4.testCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Everything2.Feb_4.pageObjects.FlightsPage;

public class baseClass 
{
	EventFiringWebDriver driver;
	private ExtentReports report;
	ExtentTest test;
	FlightsPage FlightsPage;
	private events listener;
	String baseUrl;
	
	@Parameters("browserName")
	@BeforeClass
	public void setUp(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new EventFiringWebDriver(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "\\Users\\AMRIT\\Desktop\\backup\\Java Notes\\drivers\\");
			driver = new EventFiringWebDriver(new ChromeDriver());
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		report = reporterBase.reportSetUp();
		test = report.startTest("Testing on Jan_ 5");
		listener=new events(test);
		driver.register(listener);
		baseUrl = "http://www.expedia.com";
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void takePicOnFails(ITestResult arg0)
	{
		switch(arg0.getStatus())
		{
		case ITestResult.FAILURE:
			String img = screenshot(arg0.getTestClass().getName());
			String attchImg = test.addScreenCapture(img);
			test.log(LogStatus.FAIL, "FAIL"+attchImg);
			break;
		case ITestResult.SKIP:
			test.log(LogStatus.SKIP, "SKIPPED");
			break;
		case ITestResult.SUCCESS:
			test.log(LogStatus.PASS, "PASS");
			break;
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}

//======================================================================================================================	

	private String timeStamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	}
	private String screenshot(String fileName)
	{
		String name = fileName+ "__"+timeStamp()+".png";
		String dir= "\\Users\\AMRIT\\Desktop\\LOGS\\Screeshots\\";
		
		try
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(dir+name));
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		String dest = dir+name;
		return dest;
	}
	
}
