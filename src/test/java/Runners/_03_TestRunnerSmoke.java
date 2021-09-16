package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        tags = {"@SmokeTest"},//virgul koyup baska testler yazilabilir
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},

        plugin = {//basit rapor olusturan plugin :jenkis icin eklendi
                "html:target/cucumber-report", "json:target/cucumber.json"
        }

)
public class _03_TestRunnerSmoke extends AbstractTestNGCucumberTests {

}
