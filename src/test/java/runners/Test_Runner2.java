package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = {"src\\main\\resources\\Features2"},
        glue = {"Step_Defs"},
        plugin = {"pretty", "html:target/cucumber2.html",
                "json:target/cucumber2.json",
                "junit:target/cukes2.xml",
                "rerun:target/rerun2.txt"},
        tags = "@Regression"
)
/*run Test Runner1 then Test Runner2 to get accurate testing*/


public class Test_Runner2 extends AbstractTestNGCucumberTests {

}
