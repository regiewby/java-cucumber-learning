package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OrderPagePasha {

    protected WebDriver webDriver;

    public OrderPagePasha(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement orderJacket;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement orderRedShirt;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement navLinkCart;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement inputFirstName;

    @FindBy(id = "last-name")
    private WebElement inputLastName;

    @FindBy(id = "postal-code")
    private WebElement inputPostalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void orderItem(){
        Keyword.tapElement(orderJacket);
        Keyword.tapElement(orderRedShirt);
        Keyword.tapElement(navLinkCart);
        Keyword.tapElement(checkoutButton);
    }

    public void fillOutInformation(String firstName, String lastName, String zipCode){
        Keyword.inputText(inputFirstName, firstName);
        Keyword.inputText(inputLastName, lastName); ;
        Keyword.inputText(inputPostalCode, zipCode);
        Keyword.tapElement(continueButton);
        Keyword.tapElement(finishButton);
    }
}
