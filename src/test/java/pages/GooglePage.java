package pages;

import main.MainMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.awt.SystemColor.text;

public class GooglePage extends MainMethods {
    //xpaths

    private final By searchTextBox= By.xpath("");
    private By searchBox = By.name("q");
    public GooglePage(WebDriver driver) {
        super();
    }


    public GooglePage enterText(String text){

        return this;
    }

    public void enterSearchText(String seleniumWebDriver) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(seleniumWebDriver);
    }

    public void clickSearch() {
        driver.findElement(searchBox).submit();

    }
}
