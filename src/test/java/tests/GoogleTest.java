package tests;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.ExtentManager;

public class GoogleTest extends BaseTest {

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUpReport() {
        extent = ExtentManager.createInstance("reports/AutomationReport.html");
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

    @AfterClass
    public void tearDownReport() {
        ExtentManager.flushReports();
    }
}
