package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainMethods extends Setup{
    public void verifyThatElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void verifyThatElementIsNotVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    public void clear(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).clear();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void waitForPageToBeLoaded() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(webDriver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete"));
    }

    public void switchToTab(int numberOfTab) {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(numberOfTab));
    }

    public void closeTabAndSwitchToMain(int closeTab, int switchTab) {
        Set<String> handlesSet = getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<>(handlesSet);
        getDriver().switchTo().window(handlesList.get(closeTab));
        getDriver().close();
        getDriver().switchTo().window(handlesList.get(switchTab));
    }


}
