package com.demo.coffeeshop.listener;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.demo.coffeeshop.base.TestBase;
import com.demo.coffeeshop.util.ConfigReader;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import java.io.IOException;

import static com.demo.coffeeshop.listener.ExtentTestManager.getTest;


public class TestListener extends TestBase implements ITestListener {


    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {

        takeScreenshot(result.getName());
        try {
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            System.out.println(ConfigReader.getScreenshotDirGet() + result.getName() + ".png");
            ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable(),
                    //MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\jreimers\\AquaProjects\\coffeeshop\\failed_tests_screenshots\\"+result.getName()+".png").build());
                    MediaEntityBuilder.createScreenCaptureFromPath(ConfigReader.getScreenshotDirGet() + result.getName() + ".png").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

}