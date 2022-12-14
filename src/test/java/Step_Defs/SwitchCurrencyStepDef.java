package Step_Defs;

import Pages.Home_page;
import Pages.Search_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SwitchCurrencyStepDef {
    Home_page homePage;


    @Given("user navigates to home page")
    public void openHome(){

        homePage = new Home_page(Initiate.driver);

    }


    @When("user click on the currencies list")
    public void clickOnCurrenciesList() throws InterruptedException {
        homePage.CurrenciesList().click();
        Thread.sleep(1500);
    }
    @And("^choose \"(.*)\"$")
    public void chooseCurrency(String currency)  {
        Select s= new Select(homePage.CurrenciesList());
        if((currency.equals("euro"))){
            s.selectByVisibleText("Euro");
        }
        else {
            s.selectByVisibleText("US Dollar");
        }
    }

    @Then("^product currency is switched to \"(.*)\"$")
    public void checkCurrency(String currency){
        String actual = homePage.getProductPrice();
        SoftAssert soft = new SoftAssert();
        if(currency.equals("euro")){
            soft.assertTrue(actual.contains("€"));
        }
        else
            soft.assertTrue(actual.contains("$"));

        soft.assertAll();
    }
}
