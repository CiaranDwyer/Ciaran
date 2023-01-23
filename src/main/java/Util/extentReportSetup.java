package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportSetup {

    /* WHEN YOU CHANGE THE METHOD HEADING TO STATIC YOU CAN ACCESS THE CLASS + METHODS WITHOUT CREATING AN OBJECT */

    public static ExtentReports getExtentReportObject() {
        String reportLocation = System.getProperty("user.dir") + "/Extent_Reports/Index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportLocation);
        sparkReporter.config().setReportName("Ciaran's SparkReport");
        sparkReporter.config().setDocumentTitle("Ciaran's Document Title");
        sparkReporter.config().setTheme(Theme.DARK);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester:", "Ciaran Jonathan Dwyer");
        return extentReports;
    }
}
