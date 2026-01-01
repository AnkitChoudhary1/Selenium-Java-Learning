package testComponents;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

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
        // Log the error message to the report
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Vital: This writes the file to the disk!
        extent.flush();
    }
}
