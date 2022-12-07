package app.bersama;

import io.cucumber.java.an.E;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

/**
 * @author regiewby on 07/12/22
 * @project java-cucumber-learning
 */
public class Keyword {

    public Keyword() {
    }

    public static void navigateToUrl(String url) {
        DriverManager.getInstance().getDriver().get(url);
    }

    public static void closeBrowser() {
        if (DriverManager.getInstance().getDriver() !=  null) {
            DriverManager.getInstance().getDriver().close();
        }
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        if (!webElement.isDisplayed() || !webElement.isEnabled()) {
            System.out.println("element not visible or enabled");
            throw new ElementNotInteractableException(webElement.toString());
        }
    }

    public static void waitElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(),Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void takeScreenshot() {
        try {
            TakesScreenshot screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("reports/screenshot");

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertCurrentUrl(String expectedUrl) {
        String actualUrl = DriverManager.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
