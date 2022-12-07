package app.bersama;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author regiewby on 07/12/22
 * @project java-cucumber-learning
 */
public class Keyword {
    private static WebDriver webDriver;

    public Keyword(WebDriver webDriver) {
        Keyword.webDriver = webDriver;
    }

    public static void openBrowser(String browserName) {
        webDriver = new BrowserFactory().launchBrowser(browserName);
        DriverManager.getInstance().setDriver(webDriver);
    }

    public static void closeBrowser() {
        if (webDriver !=  null) {
            webDriver.close();
        }
    }

    public static void navigateToUrl(String url) {
        webDriver.get(url);
    }

    public static void tapElement(WebElement webElement) {
        waitElementToBeDisplayed(webElement);
        webElement.click();
    }

    public static void inputText(WebElement webElement, String value) {
        waitElementToBeDisplayed(webElement);
        webElement.sendKeys(value);
    }

    public static void validateElementIsVisibleAndEnabled(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        if (!webElement.isDisplayed() || !webElement.isEnabled()) {
            System.out.println("element not visible or enabled");
            throw new ElementNotInteractableException(webElement.toString());
        }
    }

    public static void waitElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
