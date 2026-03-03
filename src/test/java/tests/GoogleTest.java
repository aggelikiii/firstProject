package tests;

import base.BaseTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.GooglePage;
import utilities.ExtentManager;

public class GoogleTest extends BaseTest {

    @BeforeSuite
    public void setUpReport() {
        ExtentManager.createInstance("reports/AutomationReport.html");
    }

    @Test
    public void openGoogleTest() {

        ExtentManager.createTest("Open Google Test");

        GooglePage googlePage = new GooglePage(driver);

        googlePage.openPage();

        String title = driver.getTitle();

        if (title.contains("Google")) {
            ExtentManager.getTest().pass("Title is correct: " + title);
        } else {
            ExtentManager.getTest().fail("Title is incorrect: " + title);
        }
    }

    @Test
    public void googleSearchTest() {

        ExtentManager.createTest("Google Search Test");

        GooglePage googlePage = new GooglePage(driver);

        googlePage
                .openPage()
                .enterSearchText("Google")
                .clickSearch();

        if (googlePage.isResultsPageDisplayed()) {
            ExtentManager.getTest().pass("Search results are displayed");
        } else {
            ExtentManager.getTest().fail("Search results are NOT displayed");
        }
    }

    @AfterSuite
    public void tearDownReport() {
        ExtentManager.flushReports();
    }
}