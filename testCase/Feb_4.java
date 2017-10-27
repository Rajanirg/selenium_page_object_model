package Everything2.Feb_4.testCase;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Feb_4 extends baseClass
{
	
	@DataProvider(name="flightsData")
	public static Object[][] data()
	{
		return new Object[][] {{"IAD","SFO","10" ,"20", "2"},
							   {"SFO","IAD","20" ,"27", "1"}};
	}
	@Test(priority=4, dataProvider="flightsData")
	public void test_Expedia(String from, String to, String depDate, String returnDate, String adults) throws Exception
	{
		FlightsPage.clickFlightsTab();
		FlightsPage.typeFlyFrom(from).typeFlyTo(to);
		FlightsPage.selectNumOfAdultsByText(adults);
		FlightsPage.selectDepartDate(true, depDate).selectReturnDate(false, returnDate);
		FlightsPage.clickSearchBtn();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try
		{
			WebElement nonStop = wait.until(ExpectedConditions.elementToBeClickable(By.id("stopFilter_stops-0")));
			nonStop.click();
		}
		catch(Exception e)
		{
			e.getMessage();
		}		
	}
	
	@Test(priority=1)
	public void test_letsKodeIt() throws Exception
	{
		driver.get("https://letskodeit.teachable.com/p/practice");
		
		List<WebElement> allRadios = driver.findElements(By.xpath("//*[@type='radio']"));
		if(allRadios.size()!=3)
		{
			test.log(LogStatus.ERROR, "Expectd: 3. But found: "+allRadios.size());
		}
		Assert.assertEquals(allRadios.size(), 3);
		
		for(WebElement radio : allRadios)
		{
			String radioText = radio.getText();
			if(radio.isDisplayed()==false)
			{
				test.log(LogStatus.ERROR, radioText+ " radio btn is not on display.");
			}
			Assert.assertTrue(radio.isDisplayed());
			if(radio.isSelected()==false)
			{
				test.log(LogStatus.INFO, radioText+ " radio btn is not currently selected.");
				radio.click();
				Thread.sleep(1000);
				if(radio.isSelected()==false)
				{
					test.log(LogStatus.ERROR, radioText+ " radio btn did not get selected after clicking on it..");
				}
				Assert.assertTrue(radio.isSelected());
				test.log(LogStatus.INFO, "Is "+radioText+ " radio btn selected now: "+radio.isSelected());
			}
			else 
			{
				test.log(LogStatus.ERROR, "How is "+radioText+ " radio btn already selected???");
			}
		}
		
		WebElement bmwCheck = driver.findElement(By.id("bmwcheck"));
		boolean isItOnDisplay=false;
		if(bmwCheck.isDisplayed()==false)
		{
			test.log(LogStatus.ERROR, "Bmw check box is not on display..");
		}
		Assert.assertTrue(bmwCheck.isDisplayed());
		isItOnDisplay=true;
		test.log(LogStatus.INFO, "Is BMW on display: "+isItOnDisplay);
		if(bmwCheck.isSelected()==true)
		{
			test.log(LogStatus.ERROR, "Bmw check should be already selected..");
		}
		Assert.assertFalse(bmwCheck.isSelected());
		test.log(LogStatus.INFO, "IS bmw check box selected: "+bmwCheck.isSelected());
		test.log(LogStatus.INFO, "Selecting it now..");
		bmwCheck.click();
		Thread.sleep(1000);
		Assert.assertTrue(bmwCheck.isSelected());
		test.log(LogStatus.INFO, "Is bmw chck box selected NOW: "+bmwCheck.isSelected());
		
		
		WebElement openwindow = driver.findElement(By.id("openwindow"));
		String parentWindowHandle = driver.getWindowHandle();
		
		openwindow.click();
		Thread.sleep(1400);
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for(String handle: allWindowHandles)
		{
			if(!handle.equals(parentWindowHandle))
			{
				driver.switchTo().window(handle);
				Thread.sleep(0500);
				WebElement search = driver.findElement(By.id("search-courses"));
				search.clear();
				search.sendKeys("I am tired af");
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindowHandle);
		
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertBtn.click();
		Thread.sleep(1000);
		
		WebDriverWait waitForAlert = new WebDriverWait(driver, 55);
		waitForAlert.until(ExpectedConditions.alertIsPresent());
		Alert jsAlert = driver.switchTo().alert();
		jsAlert.accept();
		Thread.sleep(0400);
		
		String [] expectOptions = {"BMW","Benz","Honda"}; 
		List<WebElement> allOptionsFromDropDown = driver.findElements(By.xpath("//select[@id='carselect']/option"));
		for(WebElement option : allOptionsFromDropDown)
		{
			for(int i=0; i<expectOptions.length;i++)
			{
				Assert.assertTrue(option.getText().equals(expectOptions[i]));
					//test.log(LogStatus.INFO, "Option text on UI: "+option.getText()+ " Expected: "+expectOptions[i]);
				//Assert.assertTrue(option.getText().equals(expectOptions[i]));
//				else 
//				{
//					test.log(LogStatus.ERROR, "Option text on UI: "+option.getText()+ " Expected: "+expectOptions[i]);
//				}
			}
		}
		
		
	}
}
