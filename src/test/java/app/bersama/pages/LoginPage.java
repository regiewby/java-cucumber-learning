package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class LoginPage {

    protected WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-name")
    private WebElement input_username;

    @FindBy(id = "password")
    private WebElement input_password;

    @FindBy(id = "login-button")
    private WebElement button_login;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement snackbar_error;

    public void userLogin(String userName, String password) {
        Keyword.inputText(input_username, userName);
        Keyword.inputText(input_password, password);
        Keyword.tapElement(button_login);
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actual = snackbar_error.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
