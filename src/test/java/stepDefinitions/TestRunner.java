package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features"
        ,glue={"stepDefinitions", "ApplicationHooks"}
        ,monochrome = true
        ,plugin = {"pretty","json:target/cucumber-reports/reports.json",
                  "junit:target/cucumber-reports/Cucumber.xml",
                   "html:target/cucumber-reports/reports2.html"}
        ,tags = "@Regression"

)
public  class TestRunner {
}