package Step_Defs;

import Pages.Home_page;
import Pages.Login_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CategoryStepDef {

    Home_page homePage;
    Login_page loginPage;


    @Given("initialize hover to categories feature")
    public void initCategory() {
        homePage = new Home_page(Initiate.driver);
        loginPage=new Login_page(Initiate.driver);
        loginPage.loginStep();
    }

    @When("user click on random category he is navigated to it")
    public void categoryHover() throws InterruptedException {
        Actions action = new Actions(Initiate.driver);
        String expected=null;
        List<WebElement> categories = homePage.getCategories();
        int size = categories.size();
        int min = 0;
        int max = size - 1;
        int selectedCategory = (int) Math.floor(Math.random() * (max - min + 1) + min); //make the automation selects random category to hover at
        action.moveToElement(categories.get(selectedCategory)).perform();
        Thread.sleep(2000);
        if(homePage.getSubCategories(selectedCategory).isEmpty()){
            expected= categories.get(selectedCategory).getText();
            homePage.navigateToCategory(categories.get(selectedCategory));
            Assert.assertEquals(homePage.getPage(),expected);
        }
        else {
            List<WebElement> subCategories= homePage.getSubCategories(selectedCategory);
            size = subCategories.size();
            max = size - 1;
            int selectedSubCat = (int) Math.floor(Math.random() * (max - min + 1) + min);
            if(homePage.getSubCategoryTitle(subCategories.get(selectedCategory),selectedSubCat)!=null){
                expected = homePage.getSubCategoryTitle(subCategories.get(selectedCategory),selectedSubCat);
            }
            homePage.getSubCategory(subCategories.get(selectedCategory),selectedSubCat);
            System.out.println(homePage.getPage());
            Assert.assertTrue(expected.contains(homePage.getPage().toLowerCase()));
        }
        Thread.sleep(1500);
//        driver.quit();
    }


}
