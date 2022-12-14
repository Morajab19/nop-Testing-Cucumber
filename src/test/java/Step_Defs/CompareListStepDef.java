package Step_Defs;

import Pages.Cart_Page;
import Pages.Home_page;
import Pages.Login_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CompareListStepDef {
    Home_page homePage;
    Login_page loginPage;
    Cart_Page cartPage;
        @Given("user initiate comparelist")
        public void initCompareList(){
            homePage=new Home_page(Initiate.driver);
            loginPage=new Login_page(Initiate.driver);
            cartPage=new Cart_Page(Initiate.driver);
            loginPage.loginStep();
        }
        @When("user open home page and navigates to Cell phones category")
        public void openCellphones() throws InterruptedException {
            homePage.openCellphones();
        }
        @And("click on add to compare list button for HTC One M8 Android L 5.0 Lollipop and HTC One Mini Blue")
        public void addToCompList() throws InterruptedException {
            homePage.addPhoneToCompList();
            Thread.sleep(1500);
        }
        @And("click on open compare list notification")
    public void openCompList() throws InterruptedException {
            homePage.openCompList();
            Thread.sleep(1000);
        }
        @Then("^the \"(.*)\" and \"(.*)\" are in the compare list$")
    public void checkCompareList(String item2 ,String item1){
            System.out.println(item2);
            Assert.assertTrue(cartPage.itemsInCompareList(item1,item2));

        }



}
