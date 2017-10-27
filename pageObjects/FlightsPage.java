package Everything2.Feb_4.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightsPage 
{

	private WebDriver driver;
	
	
	public WebElement flightsTab()
	{
		WebElement flights = null;
		try
		{
			flights = driver.findElement(By.id("tab-flight-tab-hp"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return flights;
	}
	public WebElement from()
	{
		WebElement element=null;
		try
		{
			element = driver.findElement(By.id("flight-origin"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	public WebElement to()
	{
		WebElement element=null;
		try
		{
			element = driver.findElement(By.id("flight-destination"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	public WebElement departBox()
	{
		WebElement element = null;
		try
		{
			element=driver.findElement(By.id("flight-departing"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	public WebElement returnBox()
	{
		WebElement element = null;
		try
		{
			element=driver.findElement(By.id("flight-returning"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	
	public WebElement adultsDropDown()
	{
		WebElement element=null;
		try
		{
			element=driver.findElement(By.id("flight-adults"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	public WebElement childDropDown()
	{
		WebElement element = null;
		try
		{
			element=driver.findElement(By.id("flight-children"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	public WebElement childAgeDropDown()
	{
		WebElement element=null;
		try
		{
			element =driver.findElement(By.id(""));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	public WebElement searchBtn()
	{
		WebElement element=null;
		try
		{
			element=driver.findElement(By.id("search-button"));
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		return element;
	}
	 
	public FlightsPage clickFlightsTab()
	{
		try
		{
			flightsTab().click();
		}
		catch(WebDriverException e)
		{
			e.getMessage();
		}
		return this;
	}
	public FlightsPage typeFlyFrom(String textToType)
	{
		try
		{
			from().clear();
			from().sendKeys(textToType);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return this;
	}
	public FlightsPage typeFlyTo(String textToType)
	{
		try
		{
			to().clear();
			to().sendKeys(textToType);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return this;
	}
	public FlightsPage selectNumOfAdultsByText(String numAdults)
	{
		try
		{
			WebElement element= adultsDropDown();
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(numAdults);
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return this;
	}
	public FlightsPage clickSearchBtn()
	{
		try
		{
			searchBtn().click();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return this;
	}

	public FlightsPage selectDepartDate(boolean currentMonth, String depDate) throws Exception
	{
		try
		{
			departBox().click();
			Thread.sleep(1000);

			if(currentMonth==true)
			{
				WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
				List<WebElement> allDatesInCalMonth = calMonth.findElements(By.tagName("button"));
				
				for(WebElement date: allDatesInCalMonth)
				{
					if(date.getText().equals(depDate))
					{
						date.click();
						Thread.sleep(1200);
						break;
					}
				}
			}
			else if(currentMonth==false)
			{
				WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=2]"));
				List<WebElement> allDatesInCalMonth= calMonth.findElements(By.tagName("button"));
				
				for(WebElement date: allDatesInCalMonth)
				{
					if(date.getText().equals(depDate))
					{
						date.click();
						Thread.sleep(1200);
						break;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return this;
	}
	public FlightsPage selectReturnDate(boolean currentMonth, String retDate) throws Exception
	{
		try
		{
			returnBox().click();
			Thread.sleep(1000);

			if(currentMonth==true)
			{
				WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
				List<WebElement> allDatesInCalMonth = calMonth.findElements(By.tagName("button"));
				
				for(WebElement date: allDatesInCalMonth)
				{
					if(date.getText().equals(retDate))
					{
						date.click();
						Thread.sleep(1200);
						break;
					}
				}
			}
			else if(currentMonth==false)
			{
				WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=2]"));
				List<WebElement> allDatesInCalMonth= calMonth.findElements(By.tagName("button"));
				
				for(WebElement date: allDatesInCalMonth)
				{
					if(date.getText().equals(retDate))
					{
						date.click();
						Thread.sleep(1200);
						break;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return this;
	}

	public FlightsPage(EventFiringWebDriver driver)
	{
		this.driver=driver; 
	}
	
	
}
