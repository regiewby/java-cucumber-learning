package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author regiewby on 07/12/22
 * @project java-cucumber-learning
 */
public class OrderStepFadhil {
    @Given("user choose product and click button cart")
    public void userChooseProduct() {
        HomePageFadhil homePage = new HomePageFadhil(DriverManager.getInstance().getDriver());
        homePage.addToCart();
    }

    @Given("user should be navigate to url {string} and click button checkout")
    public void userCheckout(String expectedUrl) {
        Keyword.assertCurrentUrl(expectedUrl);
        CartPageFadhil cartPageFadhil = new CartPageFadhil(DriverManager.getInstance().getDriver());
        cartPageFadhil.clickCheckout();
    }

    @Given("user fill firstname, lastname and zipcode and click button continue")
    public void userCheckoutFinal() {
        CheckoutPageFadhil checkoutPageFadhil = new CheckoutPageFadhil(DriverManager.getInstance().getDriver());
        checkoutPageFadhil.checkOut("fadil","nadil","123456");
    }

    @When("user click button finish")
    public void clickButtonFinish() {
        FinishPageFadhil finishPageFadhil = new FinishPageFadhil(DriverManager.getInstance().getDriver());
        finishPageFadhil.clickButtonFinish();
    }

    @Then("user should be navigate to url {string}")
    public void userChooseProduct(String expectedUrl) {
        Keyword.assertCurrentUrl(expectedUrl);
    }


}
