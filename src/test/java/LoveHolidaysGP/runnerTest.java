package LoveHolidaysGP;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dhinesh.dillum on 24/04/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",
        plugin = {
                "pretty", "html:target/cucumber-html-reports",
                "json:target/cucumber.json"},
        tags ="@Done")

public class runnerTest {
}
