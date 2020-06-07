package com.Bitrix24.tests;


import com.Bitrix24.utilities.ConfigurationsReader;
import com.Bitrix24.utilities.Driver;
import com.Bitrix24.utilities.ReportUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver = Driver.getDriver();
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    @BeforeTest
    public void beforeTest(){
        String filePath = System.getProperty("user.dir")+"/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("VyTrack results");
        extentReports.setSystemInfo("Enviroment", "qa2");
        extentReports.setSystemInfo("Browser", ConfigurationsReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));

    }
    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }
    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigurationsReader.getProperty("mainURL"));
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus()== ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                extentTest.addScreenCaptureFromPath(ReportUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            extentTest.skip("Test Case was skipped: "+result.getName());
        }

        Driver.close();
    }
}
