package reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import utils.Helper;
import java.io.IOException;

public class ExtentReporting {
    Helper _helper = new Helper();
    static ExtentReports _extentReports;


    public static void flushReport(){
        _extentReports.flush();
        _extentReports.getReport();
    }

    public void generateExtentReport(Scenario _scenario) throws IOException {
        String filePath = "src/test/java/reports/reports.html";
        String _screenShotName = _scenario.getName().replaceAll("","_");
        _extentReports = new ExtentReports();
        ExtentSparkReporter _extentSparkReporter = new ExtentSparkReporter(filePath);
        _extentSparkReporter.config().setTheme(Theme.DARK);
        _extentSparkReporter.config().setReportName("Java Automation");
        _extentSparkReporter.config().setDocumentTitle("Automation");
        _extentSparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");

        _extentReports.attachReporter(_extentSparkReporter);

        if(_scenario.isFailed()){

            _extentReports.createTest(_scenario.getName())

                    .log(Status.FAIL,"Test Failed")
                    .addScreenCaptureFromBase64String(_helper.takeScreenShot(_scenario),_screenShotName);
        }else{
            _extentReports.createTest(_scenario.getName())

                    .log(Status.PASS,"Test Passed");
        }
        _extentReports.flush();
        //Desktop.getDesktop().browse(new File(filePath).toURI());
    }
}
