package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class HomePage {

    protected WebDriver webDriver;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement button_burger;

    @FindBy(id = "logout_sidebar_link")
    private WebElement button_logout;

    @FindBy(id = "about_sidebar_link")
    private WebElement button_about;

    public void userLogout() {
        Keyword.tapElement(button_burger);
        Keyword.tapElement(button_logout);
    }

    public void tapAbout(){
        Keyword.tapElement(button_burger);
        Keyword.tapElement(button_about);
    }


}
