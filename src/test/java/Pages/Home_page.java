package Pages;

import Step_Defs.Initiate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collections;
import java.util.List;

public class Home_page {
    public WebDriver driver;
    Login_page loginPage = new Login_page(driver);
    public Home_page(WebDriver driver){this.driver=driver;}

    public WebElement enterItemToSearch(){return Initiate.driver.findElement(By.id("small-searchterms"));}

    public void clickSearch(){driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();}

    public String getProductPrice(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span")).getText();}

    public WebElement CurrenciesList(){return driver.findElement(By.cssSelector("select[id=\"customerCurrency\"]"));}


    public List<WebElement> getCategories(){
        return driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
    }
    public List<WebElement> getSubCategories(int num){
        if(num>0 && num <=3) {
            return driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>ul[class]"));
        }
        else
            return Collections.EMPTY_LIST;
    }
    public void navigateToCategory(WebElement ele){
        if(ele!=null){
            driver.navigate().to(ele.getAttribute("href").toString());
        }
    }
    public void getSubCategory(WebElement ele, int number){
        if(ele!=null){
            List<WebElement> subElement=ele.findElements(By.tagName("a"));
            driver.navigate().to(subElement.get(number).getAttribute("href").toString());
        }
    }
    public String getPage(){
        return driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
    }

    public String getSubCategoryTitle(WebElement ele,int number){
        if(ele!=null){
            List<WebElement> subElement=ele.findElements(By.tagName("a"));
            return subElement.get(number).getAttribute("href").toString().toLowerCase();
        }
        return null;
    }
    //Color filtering
    public void selectColor(){driver.findElement(By.id("attribute-option-15")).click();}

    public WebElement getAvailableColor(){return driver.findElement(By.xpath("//*[@id=\"color-squares-10\"]/li[1]/label/span/span"));}

    public void clickOnFilteredShoe(){driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/h2/a")).click();}

    //cart management
    public void clickHomeAddToCart(){driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]")).click();}

    public WebElement enterQuantity(){return Initiate.driver.findElement(By.xpath("//*[@id=\"product_enteredQuantity_4\"]"));}

    public void clickProductAddToCart(){driver.findElement(By.id("add-to-cart-button-4")).click();}

    public String getCartNotification(){return driver.findElement(By.id("bar-notification")).getText();}
//WishList management
    public void clickAddToWL(){driver.findElement(By.id("add-to-wishlist-button-4")).click();}

    public void openWishlist(){driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]")).click();}

//compare list

    public void openCellphones() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a")).click();
    }
    public void addPhoneToCompList() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[2]")).click();
    }
    public void openCompList(){
        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();
    }




}
