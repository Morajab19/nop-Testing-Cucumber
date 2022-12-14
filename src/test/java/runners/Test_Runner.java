package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src\\main\\resources\\Features"},
        glue = {"Step_Defs"},
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        tags = "@RegressionStart"
)
/*run Test Runner1 then Test Runner2 to get accurate testing*/


public class Test_Runner extends AbstractTestNGCucumberTests {

}
