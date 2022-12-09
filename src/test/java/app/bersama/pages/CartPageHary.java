package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CartPageHary {

    protected WebDriver webDriver;

    public CartPageHary(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement button_add_cart;
    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    private WebElement button_cart;

    @FindBy (id = "checkout")
    private WebElement button_checkout;

    @FindBy (id = "first-name")
    private WebElement input_firstname;

    @FindBy (id = "last-name")
    private WebElement input_lastname;

    @FindBy (id = "postal-code")
    private WebElement input_postalCode;

    @FindBy (id = "continue")
    private WebElement button_continue;

    @FindBy (id = "finish")
    private WebElement button_finish;

    public void addCart(){
        Keyword.tapElement(button_add_cart);
        Keyword.tapElement(button_cart);
    }

    public void tapButtonCheckout(){
        Keyword.tapElement(button_checkout);
    }

    public void fillDataBuyer(String firstName, String lastName, String postalCode){
        Keyword.inputText(input_firstname, firstName);
        Keyword.inputText(input_lastname, lastName);
        Keyword.inputText(input_postalCode, postalCode);
    }
    public void tapFinish(){
        Keyword.tapElement(button_continue);
        Keyword.tapElement(button_finish);
    }


}
