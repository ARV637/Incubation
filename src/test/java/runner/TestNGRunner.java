package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/featurefiles",
glue="stepDefinations",
dryRun=false)
public class TestNGRunner extends AbstractTestNGCucumberTests
{

}
