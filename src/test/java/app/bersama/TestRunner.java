package app.bersama;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */

@CucumberOptions(features = "features",
        glue = "app.bersama.steps",
        plugin = {
                "pretty",
                "html:reports/cucumber-reports.html",
                "json:reports/cucumber-reports.json"
}, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterClass
    public void afterTest() {
    }
}
