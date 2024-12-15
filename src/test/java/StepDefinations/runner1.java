package StepDefinations;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

public class runner1 {


    @CucumberOptions(
            features = "src/test/resources/Login Functionality.feature",
            glue = "StepDefinitions",
            plugin = {"pretty", "html:target/cucumber-reports.html"}
    )
    public class TestNGRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true) // Remove parallel = true if not needed
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }
}


