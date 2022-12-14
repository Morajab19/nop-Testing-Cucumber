package Step_Defs;

import Pages.Home_page;
import Pages.Login_page;
import Pages.Search_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SearchStepDef {

    Home_page homePage;
    Search_page searchPage;
    Login_page loginPage;

    @Given("initiate search feature")
    public void initSearch() throws InterruptedException {
        homePage =new Home_page(Initiate.driver);
        searchPage =new Search_page(Initiate.driver);
        loginPage=new Login_page(Initiate.driver);
        loginPage.loginStep();
        Thread.sleep(1000);
    }


    @When("^user enters the product name \"(.*)\"$")
    public void typeSearch(String item){
        homePage.enterItemToSearch().sendKeys(item);
    }
    @And("Click on search button")
    public void clickSearch() throws InterruptedException {
        homePage.clickSearch();
        Thread.sleep(1000);
    }
    @Then("^the item \"(.*)\" is displayed in the search results$")
    public void checkItemDisplayed(String item){

            String actual = searchPage.checkSearchResults();
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(actual.contains(item));
            soft.assertAll();

    }
    @Then("item not found message")
    public void checkItemNotFound(){

        String actual = searchPage.checkNoProductFoundMsg();
        String expected = "No products were found that matched your criteria.";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actual,expected,"no product found");
        soft.assertAll();

    }
}
