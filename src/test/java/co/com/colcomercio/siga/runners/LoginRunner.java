package co.com.colcomercio.siga.runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = "cucumber.plugin",
        value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,html:target/reports/cucumber.html, json:target/reports/cucumber.json, rerun:target/rerun.txt")
public class LoginRunner {
}
