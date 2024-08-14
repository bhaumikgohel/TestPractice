package Reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListeners implements ITestListener{

	
	ExtentSparkReporter UI;
	ExtentReports common;
	ExtentTest test;
	
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
		 test.log(Status.PASS, "Test Case is Pass "+ result.getName());
		 
		 
		  }
	 
	 public void onTestFailure(ITestResult result) {
		   
		 test = common.createTest(result.getName());
		 test.log(Status.FAIL,"Test Case is Fail "+ result.getName());
		 test.log(Status.FAIL, "Test Case Fail due to "+ result.getName());
		 
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		   
		 test = common.createTest(result.getName());
		 test.log(Status.SKIP, "Test case is Skipped "+ result.getName());
		 
		  }
	 
	 public void onFinish(ITestContext context) {
		 
		 common.flush();
		 
		  }
}
