package Everything2.Feb_4.pageObjects;

import com.relevantcodes.extentreports.ExtentReports;

public class reporterBase 
{

	static ExtentReports rep;
	
	public static synchronized ExtentReports reportSetup()
	{
		rep = new ExtentReports("\\Users\\AMRIT\\Desktop\\LOGS\\grid1.html",false);
		return rep;
	}
}
