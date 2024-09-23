package NotificationPrac;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            // Find the dropdown options, make sure the XPath points to the correct elements
            List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='jsx-d39a6926719b9d5a headnav_language_dropdown ']"));
            for (WebElement option : dropdownOptions) {
                // Hover again before clicking each option
                actions.moveToElement(hoverOver).perform();
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(option));
                String optionText = option.getText();
                System.out.println("Clicking on: " + optionText);
                // Check if the option is Marathi
                if (optionText.contains("मराठी - MR")) {
                    option.click();
                    System.out.println("Selected: "+optionText);
                    break;
                }
                option.click();
                Thread.sleep(1000);
            }
            //driver.findElement(By.xpath("//div[contains(text(),'मराठी - MR')]")).click();
            System.out.println("Script executed successfully!");
        }
        catch (NoSuchElementException nsee){
            System.out.println("Element not found!");
        }
        /*finally {
            driver.quit();
        }*/
    }
}
