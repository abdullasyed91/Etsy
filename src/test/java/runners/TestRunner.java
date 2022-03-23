package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary", "html:target/CucumberReports/reports.html", "json:target/cucumber.json"},
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {
}
