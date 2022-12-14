package Step_Defs;

import Pages.Login_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class LoginStepDef {
Login_page loginPage;



@Given("user navigate to the login page")
    public void openLogin() throws InterruptedException {
    loginPage=new Login_page(Initiate.driver);
    Initiate.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
}
@Given("user clicks on forget password button")
public void clickForgotPassword() throws InterruptedException {
    loginPage.clickForgetPassword();
    Thread.sleep(1500);
}

//test
    @When("^mail is \"(.*)\" and Pass is \"(.*)\"$")
    public void validlogin(String email , String pass){
    loginPage.enterEmail().sendKeys("moRajab@gmail.com");
    loginPage.enterPassword().sendKeys("Asdfgh");
    }

@When("^enter email as \"(.*)\"$")
public void enterEmail(String email){
    loginPage.enterEmail().sendKeys(email);
}
@When("^enter email \"(.*)\"$")
    public void enterValidLogin(String email ) throws InterruptedException {
     loginPage.enterEmail().sendKeys(email);

     Thread.sleep(1500);
}
@And("^enter password as \"(.*)\"$")
public void enterValidPass(String pass){
    loginPage.enterPassword().sendKeys(pass);
}
    @When("^enter email as \"(.*)\" and enter password \"(.*)\"$")
    public void enterInvalidForm(String email , String pass) throws InterruptedException {
        loginPage.enterEmail().sendKeys(email);
        loginPage.enterPassword().sendKeys(pass);
        Thread.sleep(1500);
    }
    @When("^enter email as \"(.*)\" and enter password as \"(.*)\"$")
    public void enterInvalidLogin(String email , String pass) throws InterruptedException {
        loginPage.enterEmail().sendKeys(email);
        loginPage.enterPassword().sendKeys(pass);
        Thread.sleep(1500);
    }

@And("click on Login Button")
    public void clickLoginBtn() throws InterruptedException {
    loginPage.clickLoginBtn();
    Thread.sleep(1500);

}
@And("click on Recover Button")
public void clickRecover() throws InterruptedException {
    loginPage.clickRecover();
    Thread.sleep(1000);
}
@Then("user is navigated to the home page")
    public void goToHome(){
    SoftAssert soft = new SoftAssert();
    String actual = Initiate.driver.getCurrentUrl();
    String expected = "https://demo.nopcommerce.com/";
    soft.assertEquals(actual,expected,"the user is navigated to home page");
    soft.assertAll();
}
@Then("invalid login error message appears")
    public void checkInvalidLogin(){
    String actual = loginPage.getInvalidMsg();
    String expected = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(actual,expected,"invalid email or password login");
    soft.assertAll();
}
@Then("wrong email error message appears")
    public void checkInvalidEmail(){
    String actual =loginPage.getWrongEmailMsg();
    String expected = "Wrong email";
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(actual,expected,"invalid email format");
    soft.assertAll();
}
    @Then("Email with instructions has been sent to user")
    public void checkRecoverMsg(){
        String actual =loginPage.getMailInstructionsMsg();
        String expected = "Email with instructions has been sent to you.";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actual,expected,"password recovered");
        soft.assertAll();
    }
}
