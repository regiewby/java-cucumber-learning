package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.CartPageHary;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author regiewby on 07/12/22
 * @project java-cucumber-learning
 */
public class OrderStep {

    @When("user add products to cart")
    public void userAddProductsToCart() {
        CartPageHary cartPage = new CartPageHary(DriverManager.getInstance().getDriver());
        cartPage.addCart();
    }

    @Then("user checkout")
    public void userCheckout() {
        CartPageHary cartPage = new CartPageHary(DriverManager.getInstance().getDriver());
        cartPage.tapButtonCheckout();
        cartPage.fillDataBuyer("hary", "utama", "203939");
        cartPage.tapFinish();

    }
}
