package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private WebDriver driver;

    private By searchBox = By.name("q");
    private By resultsStats = By.id("result-stats");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public GooglePage openPage() {
        driver.get("https://www.google.com");
        return this;
    }

    public GooglePage enterSearchText(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
        return this;
    }

    public GooglePage clickSearch() {
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        return this;
    }

    public boolean isResultsPageDisplayed() {
        return driver.findElements(resultsStats).size() > 0;
    }
}