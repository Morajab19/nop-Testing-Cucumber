package Pages;

import Step_Defs.Initiate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_page {
    WebDriver driver ;
    public Login_page(WebDriver driver){this.driver=driver;}

    public WebElement enterEmail(){return driver.findElement(By.id("Email"));}

    public WebElement enterPassword(){return driver.findElement(By.name("Password"));}

    public void clickLoginBtn(){driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();}

    public String getInvalidMsg(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();}

    public String getWrongEmailMsg(){return driver.findElement(By.id("Email-error")).getText();}

    public void clickForgetPassword(){driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span")).click();}

    public void clickRecover(){driver.findElement(By.name("send-email")).click();}

    public String getMailInstructionsMsg(){return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div")).getText();}

    //initiate valid login step to test other functionalities/features
    public void loginStep(){
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        enterEmail().sendKeys("moRajab@gmail.com");
        enterPassword().sendKeys("Asdfgh");
        clickLoginBtn();
    }

}
