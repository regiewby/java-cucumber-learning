package app.bersama.steps;

import app.bersama.BrowserFactory;
import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * @author regiewby on 05/12/22
 * @project java-cucumber-learning
 */
public class CommonStep {

    @Given("open browser {string} and go to url {string}")
    public void openBrowserAndGoToUrl(String browserName, String url) {
        Keyword.openBrowser(browserName);
        Keyword.navigateToUrl(url);
    }

    @When("login as {string}")
    public void loginAs(String credentialType) {

        String userName = "";
        String password = "";

        switch (credentialType) {
            case "standard_user" -> {
                userName = "standard_user";
                password = "secret_sauce";
            }
            case "locked_out_user" -> {
                userName = "locked_out_user";
                password = "secret_sauce";
            }
            case "invalid_user" -> {
                userName = "invalid_user";
                password = "wrong_password";
            }
            default -> throw new RuntimeException("credential type doesn't exist");
        }

        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.userLogin(userName, password);
    }

    @Then("current url should be {string}")
    public void currentUrlShouldBe(String expectedUrl) {
        Keyword.assertCurrentUrl(expectedUrl);
    }

    @Then("close browser")
    public void closeBrowser() {
        Keyword.closeBrowser();
    }
}
