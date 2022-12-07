package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.LoginPage;
import io.cucumber.java.en.Then;

/**
 * @author regiewby on 07/12/22
 * @project java-cucumber-learning
 */
public class LoginStep {

    @Then("user verify error message with value {string}")
    public void userVerifyErrorMessageWithValue(String value) {
        new LoginPage(DriverManager.getInstance().getDriver()).
                verifyErrorMessage(value);
    }
}
