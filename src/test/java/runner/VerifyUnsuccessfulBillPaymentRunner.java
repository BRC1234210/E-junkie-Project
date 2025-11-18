package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/VerifyUnsuccessfulBillPayment.feature",
        glue = {"Step_definitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class VerifyUnsuccessfulBillPaymentRunner extends AbstractTestNGCucumberTests {
}
