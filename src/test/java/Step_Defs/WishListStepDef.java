package Step_Defs;

import Pages.Cart_Page;
import Pages.Home_page;
import Pages.Login_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

public class WishListStepDef {
    Home_page homePage;
    Cart_Page cartPage;
    Login_page loginPage;
    @Given("Initiate wishlist")
    public void initCart(){
        homePage = new Home_page(Initiate.driver);
        cartPage =new Cart_Page(Initiate.driver);
        loginPage=new Login_page(Initiate.driver);
        loginPage.loginStep();
    }
    @When("user scrolls to Apple MacBook Pro 13-inch and clicks Add to wishlist Button")
    public void chooseItem() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)Initiate.driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(1000);
        homePage.clickHomeAddToCart();
        Thread.sleep(2000);
    }
    @And("user click on add to wishlist")
    public void addToWishlist() throws InterruptedException {
        homePage.clickAddToWL();
        Thread.sleep(2000);
    }
    @Then("item is added to wishlist")
    public void checkAddedToWL(){
        cartPage.closeNotification();
        homePage.openWishlist();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(cartPage.itemsInWishlist("Apple MacBook Pro 13-inch"));
        soft.assertEquals(Initiate.driver.getCurrentUrl() , "https://demo.nopcommerce.com/wishlist");
        soft.assertAll();
    }
}
