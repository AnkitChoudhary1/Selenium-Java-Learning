package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    public static ExtentReports getReportObject() {
        // 1. Define the path where the report will be created
        // It will create a folder "reports" and a file "index.html"
        String path = System.getProperty("user.dir") + "/reports/index.html";

        // 2. Configure the Report Look & Feel (Title, Name)
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        // 3. Attach the configuration to the main Report object
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ankit Choudhary"); // Your name here!
        return extent;
    }
}
