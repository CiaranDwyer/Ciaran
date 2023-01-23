package testNG_Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Util.extentReportSetup;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    ExtentTest myTest;


    /* CALLING EXTENT REPORT CLASS FOR REPORT OBJECT  */
    ExtentReports extentReports = extentReportSetup.getExtentReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        myTest = extentReports.createTest("---------- CREATE TEST ANNOTATION ---------- ").log(Status.INFO, "INFO MESSAGE HERE");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        myTest.log(Status.PASS, "---------- onTestSuccess Annotation  ---------- ");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
