package Step_Defs;

import Pages.Home_page;
import Pages.Login_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ColorFilterStepDef {
    Home_page homePage;
    Login_page loginPage;


    @Given("user navigate to shoes category page")
    public void initColorFilter() throws InterruptedException {

        homePage = new Home_page(Initiate.driver);
        loginPage=new Login_page(Initiate.driver);
        loginPage.loginStep();
        Thread.sleep(1000);
        Initiate.driver.navigate().to("https://demo.nopcommerce.com/shoes");
    }
    @When("user select red color")
    public void selectColor() throws InterruptedException {
        homePage.selectColor();
        Thread.sleep(2000);
    }
    @Then("the red shoes are displayed")
    public void checkShoesColor(){
        homePage.clickOnFilteredShoe();
        WebElement color = homePage.getAvailableColor();
        String actualColor = color.getCssValue("background-color");
        System.out.println(color.getCssValue("background-color"));
        Assert.assertTrue(actualColor.contains("102, 48, 48, 1"));
    }
}
