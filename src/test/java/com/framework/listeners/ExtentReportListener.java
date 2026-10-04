package com.framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.framework.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setReportName("Selenium Framework Results");
        spark.config().setDocumentTitle("Automation Report");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String name = result.getMethod().getMethodName();
        System.out.println("[PASS] TEST PASSED: " + name);
        test.log(Status.PASS, "TEST PASSED: " + name);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String name = result.getMethod().getMethodName();
        System.out.println("[FAIL] TEST FAILED: " + name + " -> " + result.getThrowable().getMessage());
        test.log(Status.FAIL, "TEST FAILED: " + name);
        test.fail(result.getThrowable());
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            test.log(Status.WARNING, "No screenshot: driver was null at failure time");
            return;
        }
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dir = Paths.get("test-output/screenshots");
            Files.createDirectories(dir);
            Path dest = dir.resolve(name + "_" + System.currentTimeMillis() + ".png");
            Files.copy(src.toPath(), dest);
            test.addScreenCaptureFromPath(dest.toAbsolutePath().toString());
            test.log(Status.INFO, "Screenshot saved: " + dest.toAbsolutePath());
        } catch (Exception e) {
            test.log(Status.WARNING, "Screenshot capture FAILED: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String name = result.getMethod().getMethodName();
        System.out.println("[SKIP] TEST SKIPPED: " + name);
        test.log(Status.SKIP, "TEST SKIPPED: " + name);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
