package Everything2.Feb_4.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class events implements WebDriverEventListener 
{
	private ExtentTest test;

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		test.log(LogStatus.INFO, "Changed the value on this elenment: "+arg0.toString()+ " on browser: "+arg1.toString());
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		test.log(LogStatus.INFO,"Clicked on: "+arg0.toString()+ " on browser: "+arg1.toString());
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		if (arg1 == null) {
            System.out.println("Element found: " + arg0.toString() + " on browser: " + arg2.toString() );
            test.log(LogStatus.INFO, "Element found: "+arg0.toString()+ " on browser: "+arg2.toString());
        } else {
            System.out.println("Element found: " + arg0.toString() + " inside " + arg1.toString() + " Web element on browser: " + arg2.toString() );
            test.log(LogStatus.INFO, "Element found: "+arg0.toString()+ " inside "+ arg1.toString()+ " WebElement on browser: "+arg2.toString());
        }
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		test.log(LogStatus.INFO,"Successfully navigated to: "+arg0+ " on browser: "+arg1.toString());
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		test.log(LogStatus.INFO,"About to click on : "+arg0.toString()+ " on browser: "+arg1.toString());
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		if (arg1 == null) {
            System.out.println("Just before finding element: " + arg0.toString() + " on browser: " + arg2.toString() );
            test.log(LogStatus.INFO, "Looking for element: " + arg0.toString() + " on browser: " + arg2.toString() );
        } else {
            System.out.println("Just before finding element: " + arg0.toString() + " inside " + arg1.toString() + " Web element on browser: " + arg2.toString() );
            test.log(LogStatus.INFO,"Just before finding element: " + arg0.toString() + " inside " + arg1.toString() + " Web element on browser: " + arg2.toString() );
        }
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		test.log(LogStatus.ERROR, arg0.getMessage()+ " on browser: "+arg1);
		
	}
	
	public events(ExtentTest test)
	{
		this.test=test;
	}

}
