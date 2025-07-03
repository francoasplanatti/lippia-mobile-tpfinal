package com.crowdar.examples.customrunners;

import com.crowdar.bdd.cukes.TestNGSecuencialRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.crowdar.examples.steps", "com.crowdar.bdd.cukes"},
        tags = "@Demo and not @Ignore",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class CustomMobileRunner extends TestNGSecuencialRunner {
        public CustomMobileRunner() {
                super();
        }
}