package Framework.Framework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\SmokeTestResult.html";
		
		ExtentSparkReporter report = new ExtentSparkReporter(path);		
		report.config().setReportName("Automation Smoke Test Report");		
		report.config().setDocumentTitle("Updated Test Result");
		
		ExtentReports extent = new ExtentReports();		
		extent.attachReporter(report);		
		extent.setSystemInfo("New Tester", "Study");
		extent.createTest(path);
		
		return extent;
	}

}
