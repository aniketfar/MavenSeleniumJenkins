package org.Automation.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/Automation/features",
        glue = {"org.Automation.stepDefinition"},
        plugin = {"pretty",
                  "html:target/Cucumber-report/CucumberPretty.html",
                   "json:target/Cucumber-report/cucumbertestreport.json",
                  "rerun:target/Cucumber-report/rerun.txt"},
        monochrome = false,
       //tags = "@SessionTest"
       tags = "@facebooktest"
)

public class testrunner {
}
