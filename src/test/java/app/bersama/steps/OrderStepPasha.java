package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.HomePage;
import app.bersama.pages.OrderPagePasha;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderStepPasha {
    @When("order item")
    public void orderItem() {
        OrderPagePasha orderPagePasha = new OrderPagePasha(DriverManager.getInstance().getDriver());
        orderPagePasha.orderItem();
    }

    @Then("fillout buyer information as {string}")
    public void filloutBuyerInformationAsString(String credentialType) {

        String firstName = "pasha";
        String lastName = "jero";
        String zipCode = "12345";

        OrderPagePasha orderPagePasha = new OrderPagePasha(DriverManager.getInstance().getDriver());
        orderPagePasha.fillOutInformation(firstName, lastName, zipCode);
    }
}
