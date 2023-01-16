package reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import utils.Helper;

public class ExtentReporting {
    Helper _helper = new Helper();
    ExtentReports _extentReports;
    ExtentTest _extentTest;

    public void generateExtentReport(Scenario _scenario) {
        String filePath = "src/test/java/reports/reports.html";
        _extentReports = new ExtentReports();
        ExtentSparkReporter _extentSparkReporter = new ExtentSparkReporter(filePath);
        _extentSparkReporter.config().setTheme(Theme.DARK);
        _extentSparkReporter.config().setReportName("Java Automation");
        _extentSparkReporter.config().setDocumentTitle("Automation");
        _extentSparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        _extentReports.attachReporter(_extentSparkReporter);
        _extentTest = _extentReports.createTest(_scenario.getName());
        //Desktop.getDesktop().browse(new File(filePath).toURI());
    }

    public void logTestInReport(Scenario _scenario){
        String _screenShotName = _scenario.getName().replaceAll("","_");

        if(_extentTest.getStatus() == Status.FAIL){
            _extentTest
                    .log(Status.FAIL,"Test Failed")
                    .addScreenCaptureFromBase64String(_helper.takeScreenShot(_scenario),_screenShotName);
        }else if(_extentTest.getStatus() == Status.PASS){
            _extentTest
                    .log(Status.PASS,"Test Passed");
        }else if(_extentTest.getStatus() == Status.INFO){
            _extentTest
                    .log(Status.INFO,"Test Infor");
        }else if(_extentTest.getStatus() == Status.WARNING){
            _extentTest
                    .log(Status.WARNING,"Test Warning");
        }else if(_extentTest.getStatus() == Status.SKIP){
            _extentTest
                    .log(Status.SKIP,"Test Skipped");
        }
    }

    public void flushTestReport(){
        _extentTest.getExtent().flush();
    }
}
