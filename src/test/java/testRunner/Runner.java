package testRunner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dataProvider.Configurations;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }
)
public class Runner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(Configurations.getReportConfigPath()));
    }
}

