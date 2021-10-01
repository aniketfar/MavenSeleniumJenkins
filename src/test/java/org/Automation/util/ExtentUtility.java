package org.Automation.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ExtentUtility {

    public static ExtentTest Test;
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static String reportFolder = "";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    public static String timeStamp = "";
    public static String reportPath = null;

    @org.junit.Test
    public void getReporter() {

        timeStamp = ExtentUtility.setTimeStamp();
        reportFolder = "HtmlReport_" + timeStamp;
        //spark = new ExtentSparkReporter(new File(("ReportGenerator/" + reportFolder + "/TestReport.html")));
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("TestReport.html");
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);

        Test = extent.createTest("First Test").assignAuthor("Aniket");
        Test.pass("it was successful");
        Test.info("Loaded correctly");
        Test.fail("It failed");
        Test.log(Status.FAIL,"logged as failed");
        Test.skip("Skipped");
        Test.warning("Warning");



    }

    public synchronized static String setTimeStamp() {
        SimpleDateFormat sdfDateReport = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");// dd/MM/yyyy
        Date now = new Date();
        timeStamp = sdfDateReport.format(now);
        return timeStamp;
    }



}