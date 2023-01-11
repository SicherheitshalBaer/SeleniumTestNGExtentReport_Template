package com.demo.coffeeshop.base;

import com.demo.coffeeshop.util.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void setupDriver(String browser) throws Exception{

        System.out.println("Before Suite");

        if(browser.equalsIgnoreCase("chrome")) {
            //create chrome instance
            System.setProperty("webdriver.chrome.driver", ConfigReader.getChromePath());
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            StaticHelper.driver = driver;

        } else if(browser.equalsIgnoreCase("firefox")){
            //set path to firefoxdriver.exe
            System.setProperty("webdriver.gecko.driver", ConfigReader.getFirefoxPath());

            this.driver = new FirefoxDriver();
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            StaticHelper.driver = driver;

        } else if(browser.equalsIgnoreCase("edge")){
            //set path to edgedriver.exe
            System.setProperty("webdriver.edge.driver", ConfigReader.getEdgePath());

            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            StaticHelper.driver = driver;

        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void closeDriver() {

        System.out.println("After Suite");
        driver.quit();
    }

    /**
     * Takes screenshot of whole page and allows you to name the screenshot
     *
     * @param screenshotName The screenshot file name
     */
    public void takeScreenshot(String screenshotName) {
        TakesScreenshot screenshot = (TakesScreenshot) StaticHelper.driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(ConfigReader.getScreenshotDirCreate() + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
