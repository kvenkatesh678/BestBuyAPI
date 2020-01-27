package Helpers;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ProductListeners extends TestListenerAdapter {

	public static ExtentHtmlReporter Reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String file="C:/Users/user/eclipse-workspace/RestAssuredAPI/Reports/ProductsAPI's.html";

	
	@BeforeSuite
	public void onStart(ITestContext testContext) {
		Reporter = new ExtentHtmlReporter(file);
		Reporter.config().setDocumentTitle("RestAssured Automation API Testing");
		Reporter.config().setReportName("RestAssured API Testing Product's API Report");
		
		extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("User","Venkatesh");
		extent.setSystemInfo("Host","LocalHost");
		extent.setSystemInfo("OS","Windows");
//		test.log(Status.INFO, "TestCase Started is :" +testContext.getName());
	}	

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started:" +result.getName());
	}
	
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.INFO, "TestCase Started is :" +tr.getName());
		System.out.println("Test failed is:" +tr.getName());
		test.log(Status.FAIL, "TestCase failed  is :" +tr.getName());
		test.log(Status.FAIL, "TestCase failed  is :" +tr.getThrowable());
	}
	
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.INFO, "TestCase Skipped  is :" +tr.getName());
		test.log(Status.SKIP, "TestCase Skipped  is :" +tr.getName());
		System.out.println("Test Skipped is:" +tr.getName());
	}
	
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.INFO, "TestCase Started is :" +tr.getName());
		test.log(Status.PASS, "TestCase passed is :" +tr.getName());
		System.out.println("Test Passed is:" +tr.getName());
	}
	
	@AfterSuite
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
