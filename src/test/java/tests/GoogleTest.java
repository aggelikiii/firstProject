package tests;

import base.BaseTest;
import main.MainMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pages.GooglePage;
import utilities.ExtentManager;

public class GoogleTest extends BaseTest {

    GooglePage googlePage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUpReport() {
        extent = ExtentManager.createInstance("reports/AutomationReport.html");
        googlePage = new GooglePage(driver);
    }

    @Test
    public void openGoogleTest() {
        test = ExtentManager.createTest("Open Google Test");

        driver.get("https://www.google.com");
        String title = driver.getTitle();

        if (title.contains("Google")) {
            test.pass("Title is correct: " + title);
        } else {
            test.fail("Title is incorrect: " + title);
        }
    }

    @Test
    public void googleSearchTest() {
        test = ExtentManager.createTest("Google Search Test");

        driver.get("https://www.google.com");

        googlePage = new GooglePage(driver);

        googlePage.enterSearchText("Selenium WebDriver");
        googlePage.clickSearch();

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("search")) {
            test.pass("Search results page opened successfully");
        } else {
            test.fail("Search did not work properly");
        }
    }


    @AfterClass
    public void tearDownReport() {
        ExtentManager.flushReports();
    }
}
