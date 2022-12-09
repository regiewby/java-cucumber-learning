package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FinishPageFadhil {
    protected WebDriver webDriver;

    public FinishPageFadhil(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "finish")
    private WebElement button_finish;

    public void clickButtonFinish() {
        Keyword.tapElement(button_finish);
    }
}
