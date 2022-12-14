package Step_Defs;

import Pages.Home_page;
import Pages.Login_page;
import Pages.Search_page;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class TagStepDef {

    Search_page searchPage;
    Login_page loginPage;

    @Given("user navigates to search page")
    public void tagInit() throws InterruptedException {
        loginPage=new Login_page(Initiate.driver);
        searchPage=new Search_page(Initiate.driver);
        loginPage.loginStep();
        Thread.sleep(1500);
        Initiate.driver.navigate().to("https://demo.nopcommerce.com/search");
    }
    @When("user click on cool tag")
    public void clickTag() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)Initiate.driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(1000);
        searchPage.getTag().click();
        Thread.sleep(1500);
    }
    @Then("products tagged with cool are displayed")
    public void getTagTitle(){
        SoftAssert soft = new SoftAssert();
        String actual = searchPage.getTagTxt();
        String expected = "Products tagged with 'cool'";
        soft.assertEquals(actual,expected,"products tagged");
        soft.assertEquals(Initiate.driver.getCurrentUrl(),"https://demo.nopcommerce.com/cool");
        soft.assertAll();
    }

}
