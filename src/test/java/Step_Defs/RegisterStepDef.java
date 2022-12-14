package Step_Defs;

import Pages.Login_page;
import Pages.Register_page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class RegisterStepDef {

    Register_page registerPage;

    @Given("user navigates to registration page")
    public void openRegister(){
        registerPage=new Register_page(Initiate.driver);
        Initiate.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
    }
    @When("^user choose gender \"(.*)\" , enter firstname \"(.*)\" and enter lastname \"(.*)\"$")
    public void enterGender_fullName(String gen , String fname , String lname){
        registerPage.selectGender(gen);
        registerPage.enterFirstname().sendKeys(fname);
        registerPage.enterLastname().sendKeys(lname);
    }
    @And("^user enter date of birth day \"(.*)\" month \"(.*)\" year \"(.*)\"$")
    public void enterBDate(String day , String month , String year){
        registerPage.enterBirthdate(day,month,year);
    }
    @And("^user enter email \"(.*)\" , password \"(.*)\" and confirm with \"(.*)\"$")
    public void enterMail_pass(String email , String pass , String confirm){
        registerPage.enterEmail().sendKeys(email);
        registerPage.enterPassword().sendKeys(pass);
        registerPage.confirmPassword().sendKeys(confirm);
    }
    @And("click on register button")
    public void clickRegister(){registerPage.clickRegister();}

    @Then("user is registered successfully message appears")
    public void userMsg(){
        SoftAssert soft = new SoftAssert();
        String actual = registerPage.confimaationMsg();
        String expected = "Your registration completed";
        soft.assertEquals(actual,expected,"registration completed msg");
        soft.assertAll();
    }
    @Then("mail already exist error")
    public void checkMailErr(){
        SoftAssert soft = new SoftAssert();
        String actual = registerPage.alredyExistErr();
        String expected = "The specified email already exists";
        soft.assertEquals(actual,expected,"mail already exist");
        soft.assertAll();
    }
    @Then("confirm password error")
    public void checkPassConfirmErr(){
        SoftAssert soft = new SoftAssert();
        String actual = registerPage.passwordConfirmationErr();
        String expected = "The password and confirmation password do not match.";
        soft.assertEquals(actual,expected,"The password and confirmation password do not match");
        soft.assertAll();
    }
    @Then("empty fname error")
    public void checkFnameErr(){
        SoftAssert soft = new SoftAssert();
        String actual = registerPage.emptyFirstnameErr();
        String expected = "First name is required.";
        soft.assertEquals(actual,expected,"First name is required error");
        soft.assertAll();
    }
    @Then("password is too short error")
    public void checkShortPassErr(){
        SoftAssert soft = new SoftAssert();
        String actual = registerPage.shortPasswordErr();
        String expected = "Password must meet the following rules:\nmust have at least 6 characters";
        soft.assertEquals(actual,expected,"Password is too short error");
        System.out.println(registerPage.shortPasswordErr());
        soft.assertAll();
    }

}
