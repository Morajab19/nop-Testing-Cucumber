package Step_Defs;

import Pages.Cart_Page;
import Pages.Checkout_Page;
import Pages.Home_page;
import Pages.Login_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class CheckoutStepDef {
    Checkout_Page checkoutPage;
    Login_page loginPage;
    Home_page homePage;
    Cart_Page cartPage;
    @Given("initiate checkout")
    public void initCheckout() throws InterruptedException {
        checkoutPage=new Checkout_Page(Initiate.driver);
        homePage=new Home_page(Initiate.driver);
        loginPage=new Login_page(Initiate.driver);
        cartPage=new Cart_Page(Initiate.driver);
        loginPage.loginStep();

    }
    @When("user navigates to cart page")
    public void openCart() throws InterruptedException {
        cartPage.openCart();
        Thread.sleep(1500);
    }
    @And("confirm the terms and click checkout button")
    public void checkout() throws InterruptedException {
        cartPage.checkout();
    }
    @And("^select the country \"(.*)\", city \"(.*)\", address1 \"(.*)\", zip \"(.*)\", number \"(.*)\" and  click Continue$")
    public void sendAddressInfo(String country , String city , String address , String zip , String number ) throws InterruptedException {
        checkoutPage.selectCountry(country);
        checkoutPage.enterCity().sendKeys(city);
        checkoutPage.enterAddress().sendKeys(address);
        checkoutPage.enterZip().sendKeys(zip);
        checkoutPage.enterNumber().sendKeys(number);
        checkoutPage.clickContinue();
        Thread.sleep(2000);
    }
    @And("select the next day air shipping methode and click continue")
    public void selectShippingMethode() throws InterruptedException {
        checkoutPage.selectShippingMethode();
        Thread.sleep(1000);
    }
    @And("select the check payment method and click continue")
    public void selectPayment() throws InterruptedException {
        checkoutPage.selectCheckPayment();
        Thread.sleep(1000);
    }
    @And("^check the order email \"(.*)\", number \"(.*)\" and click confirm$")
    public void confirmOrder(String mail , String number) throws InterruptedException {
        SoftAssert soft =new SoftAssert();
        Boolean confirm = false;
        String actual = checkoutPage.mailInfo();
        String actual2 = checkoutPage.phoneInfo();
        if(actual.contains(mail) && actual2.contains(number)){
            confirm=true;
        }
        soft.assertTrue(confirm);
        soft.assertAll();
        checkoutPage.clickConfirm();
        Thread.sleep(3000);
    }
    @Then("the order is placed successfully")
    public void checkOrder(){
        SoftAssert soft =new SoftAssert();
        String actual = checkoutPage.getOrderMsg();
        String expected = "Your order has been successfully processed!";
        soft.assertEquals(actual,expected,"order is successfully placed");
        soft.assertEquals(Initiate.driver.getCurrentUrl(),"https://demo.nopcommerce.com/checkout/completed");
        soft.assertAll();
    }

}
