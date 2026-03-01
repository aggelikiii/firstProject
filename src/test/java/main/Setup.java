package main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Setup {

        public static WebDriver driver;

        public static ExtentReports report;
        public static ExtentTest test;

        public WebDriver getDriver () {
            return driver;
        }


    }
