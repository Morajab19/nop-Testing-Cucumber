package Step_Defs;

import Pages.Cart_Page;
import Pages.Home_page;
import Pages.Login_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CartStepDef {
    Home_page homePage;
    Login_page loginPage;
    Cart_Page cartPage;

    @Given("Initiate manage cart")
    public void initCart(){

        homePage = new Home_page(Initiate.driver);
        cartPage =new Cart_Page(Initiate.driver);
        loginPage=new Login_page(Initiate.driver);
        loginPage.loginStep();
    }
    @When("user scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button")
    public void chooseItem() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)Initiate.driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(1000);
        homePage.clickHomeAddToCart();
        Thread.sleep(2000);
    }
    @And("^enter quantity of \"(.*)\" and click on ADD TO CART Button and open cart$")
    public void enterQuantity(String q) throws InterruptedException {
        homePage.enterQuantity().clear();
        homePage.enterQuantity().sendKeys(q);
        homePage.clickProductAddToCart();
        Thread.sleep(1500);

    }
    @Then("^the product \"(.*)\" is added successfully to the cart$")
    public void checkProductAdded(String productName) throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        String actual = homePage.getCartNotification();
        String expected = "The product has been added to your shopping cart";
        soft.assertEquals(actual,expected);
        cartPage.closeNotification();
        cartPage.openCart();
        Thread.sleep(1000);
        soft.assertTrue(cartPage.itemsInCart(productName));
        System.out.println(cartPage.itemsInCart("Apple MacBook Pro 13-inch"));
        soft.assertAll();
    }
    @When("user opens the cart")
    public void openCart() throws InterruptedException {
        cartPage.openCart();
        Thread.sleep(1000);
    }
    @And("^type the updated quantity \"(.*)\" and click on update cart$")
    public void updateQ(String q) throws InterruptedException {
        cartPage.updateItem(q);
        Thread.sleep(1500);

    }
    @Then("^the product quantity is updated to \"(.*)\"$")
    public void checkUpdate(String q){
        String actual =cartPage.getQuantity();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actual,q);
        soft.assertAll();
    }
    @And("click on remove product")
    public void removeItem() throws InterruptedException {
        cartPage.removeItem();
        Thread.sleep(1000);
    }
    @Then("product is deleted from the cart")
    public void checkDeleted(){
        String actual =cartPage.checkDeleted();
        Assert.assertEquals(actual,"Your Shopping Cart is empty!");
    }

}
