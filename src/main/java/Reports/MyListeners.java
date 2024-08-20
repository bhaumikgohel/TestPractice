package Reports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.TestBase;
import utils.util;

public class MyListeners implements ITestListener{
	
	public static ExtentSparkReporter UI;
	public static ExtentReports common;
	public static ExtentTest test;
	
	 public void onStart(ITestContext context) {
		 
		 UI = new ExtentSparkReporter("D:\\Automation\\rover\\src\\main\\java\\Reports\\ExecutionReport\\index.html");
		 
		 UI.config().setDocumentTitle("End to End Ecom Testing");
		 UI.config().setReportName("All Report Data");
		 UI.config().setTheme(Theme.STANDARD);
		 
		 common = new ExtentReports();
		 common.attachReporter(UI);
		 common.setSystemInfo("Browser", "Chrome");
		 common.setSystemInfo("OS", "Windows");
		 common.setSystemInfo("Company", "TechRover");
		 common.setSystemInfo("Executed by", "Bhaumik GOhel");
		    
		  }
	
	 public void onTestSuccess(ITestResult result) {
		  
		 test = common.createTest(result.getName());
//		 test.log(Status.PASS, "Test Case is Pass "+ result.getName());
		 
		 if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test Casae is Pass" + result.getName());
				
				String screenshotdestination = null;
				try {
					screenshotdestination = util.getScreenshot(TestBase.driver, result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.log(Status.PASS, screenshotdestination);
			}
		 
		 
		  }
	 
	 public void onTestFailure(ITestResult result) {
		   
//		 test = common.createTest(result.getName());
//		 test.log(Status.FAIL,"Test Case is Fail "+ result.getName());
//		 test.log(Status.FAIL, "Test Case Fail due to "+ result.getThrowable());
//		 
		 if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, "Test Casae is Fail" + result.getName());
				test.log(Status.FAIL, "Test Casae is Fail" + result.getThrowable());
				
				String screenshotdestination = null;
				try {
					screenshotdestination = util.getScreenshot(TestBase.driver, result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.log(Status.FAIL, screenshotdestination);
			}
		 
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		   
		 test = common.createTest(result.getName());
		 test.log(Status.SKIP, "Test case is Skipped "+ result.getName());
		 
		  }
	 
	 public void onFinish(ITestContext context) {
		 
		 common.flush();
		 
		  }
}
