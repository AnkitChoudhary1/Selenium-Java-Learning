package testComponents;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;

    // ThreadLocal ensures reports don't mix up during Parallel Execution
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Before every test, create a new entry in the report
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); // Put into ThreadLocal
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // 1. Log the failure error
        extentTest.get().fail(result.getThrowable());

        // 2. Capture the Driver from the failing test method
        // (This uses Java Reflection to "steal" the driver field from the test class)
        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. Take Screenshot and Attach to Report
        try {
            String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
            // This line adds the screenshot to the report
            extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Quick Fix: You need to extend BaseTest in Listeners to use 'getScreenshot'
    // OR create an object of BaseTest.
    // SIMPLEST WAY: Make 'Listeners' extend 'BaseTest'
    // Change: public class Listeners extends BaseTest implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        // Vital: This writes the file to the disk!
        extent.flush();
    }
}
