package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class HomePageFadhil {

    protected WebDriver webDriver;

    public HomePageFadhil(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement button_burger;

    @FindBy(id = "logout_sidebar_link")
    private WebElement button_logout;

    @FindBy(id= "add-to-cart-sauce-labs-backpack")
    private WebElement add_cart1;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElement add_cart2;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement button_cart;

    public void userLogout() {
        Keyword.tapElement(button_burger);
        Keyword.tapElement(button_logout);
    }

    public void addToCart() {
        Keyword.tapElement(add_cart1);
        Keyword.tapElement(add_cart2);
        Keyword.tapElement(button_cart);
    }
}
