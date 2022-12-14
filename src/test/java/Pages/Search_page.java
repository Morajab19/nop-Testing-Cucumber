package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search_page {
    WebDriver driver;
    public Search_page(WebDriver driver){this.driver=driver;}

    public String checkSearchResults(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2")).getText();}

    public String checkNoProductFoundMsg(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div")).getText();}


    //search tag

    public WebElement getTag(){return driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.side-2 > div.block.block-popular-tags > div.listbox > div.tags > ul > li:nth-child(8) > a"));}

    public String getTagTxt(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]")).getText();}


}
