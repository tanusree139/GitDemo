package Framework.Framework.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Framework.Framework.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener
{
	ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	public void onTestStart(ITestResult result) {
	    
		test = extent.createTest(result.getMethod().getMethodName());
		
	  }

	  
	public void onTestSuccess(ITestResult result) {
	    
		test.log(Status.PASS, "Test Passed");
		
	  }

	  
	public void onTestFailure(ITestResult result) {
		
	     test.log(Status.FAIL, "Test is failed");
	     
	     test.fail(result.getThrowable());
	     
	     try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").
					 get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
	     
	  }

	  
	


	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	public void onStart(ITestContext context) {
		
	    // not implemented
	  }

	  
	public void onFinish(ITestContext context) {

		extent.flush();
		
	  }

	

}
