package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"stepDefinitions"},
        features = "src/test/features",
        plugin = {
                "pretty", "html:reports/myReport.html",
                "json:reports/myReport.json"
        },
        dryRun = false,
        tags = "@smoke",
        monochrome = true)

public class TestRunner {
}
