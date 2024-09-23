package NotificationPrac;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;
public class Demo {
    public static void main(String[] args) throws Exception{
        //create object ref of ChromeOptions class
        ChromeOptions options = new ChromeOptions();
        //disable the notifications which appear on the Chrome browser
        options.addArguments("--disable-notifications");
        //pass the ChromeOptions object ref as a parameter to chromeDriver constructor
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
            driver.manage().window().maximize();
            driver.get("https://www.justdial.com/");
            try {
                WebElement loginPopUp = driver.findElement(By.xpath("//div[@class='jsx-6c124d8f023ea07e mt-10']"));
                if (loginPopUp.isDisplayed()) {
                    driver.findElement(By.xpath("//a[@aria-label='May be later']")).click();
                }
            } catch (NoSuchElementException e) {
                System.out.println("Login popup not found.");
            }
            Actions actions = new Actions(driver);
            WebElement hoverOver = driver.findElement(By.id("header_language"));
            actions.moveToElement(hoverOver).perform();
            //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/header/div/div[3]/div/ul/li[1]")));
            driver.findElement(By.xpath("//div[contains(text(),'मराठी - MR')]")).click();
            js.executeScript("window.scrollBy(0,1000)","");
            driver.findElement(By.xpath("//span[contains(text(),'होम डेकॉर')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'मराठी')]")).click();
            driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/ul/li[8]/a/span[2]")).click();
        }
        catch (NoSuchElementException nsee){
            System.out.println("Element not found!");
        }
        /*finally {
            driver.quit();
        }*/
    }
}