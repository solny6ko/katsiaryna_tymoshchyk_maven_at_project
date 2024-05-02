package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import tests.BaseStepsJUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "summary"},
        glue = { "steps"},
        features = {
                "src/test/resources/features/firstfeature/bookingBdd.feature",
                "src/test/resources/features/firstfeature/demoQABdd.feature"
        }
)
public class CucumberRunner  extends BaseStepsJUnit {
}
