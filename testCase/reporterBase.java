package Everything2.Feb_4.testCase;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class reporterBase 
{

	private static ExtentReports rep;
	
	public static synchronized ExtentReports reportSetUp()
	{
		rep=new ExtentReports("\\Users\\AMRIT\\Desktop\\LOGS\\Feb_4.html", false, DisplayOrder.NEWEST_FIRST);
		return rep;
	}
	
	
	
}
