package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutPageFadhil {
    protected WebDriver webDriver;

    public CheckoutPageFadhil(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "first-name")
    private WebElement input_firstName;

    @FindBy(id = "last-name")
    private WebElement input_lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement button_continue;

    public void checkOut(String firstname, String lastname, String postalcode) {
        Keyword.inputText(input_firstName, firstname);
        Keyword.inputText(input_lastName, lastname);
        Keyword.inputText(postalCode, postalcode);
        Keyword.tapElement(button_continue);
    }
}
