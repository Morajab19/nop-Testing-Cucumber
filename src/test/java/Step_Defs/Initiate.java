package Step_Defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initiate {
    public static WebDriver driver;

    @Before
    public  static void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\user\\IdeaProjects\\NOP_AutomationTesting\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(1500);
    }
    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
